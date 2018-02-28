/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


/**
 *
 * @author Edwin
 */
public class SQLiteJDBCDriverConnection {
    
    
  
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:D:/Users/Edwin/Documents/SystemsSoftware/SocialServer/db/SocialServer.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
public void selectAll(){
        String sql = "SELECT * FROM Users";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + "," + rs.getString("LastName")+ "," + rs.getString("UserName") + "," + rs.getString("Password")+ "," + rs.getString("Email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

public void insertUser(String FirstName, String LastName, String UserName, String Password, String Email, String blob) {
        String sql = "INSERT INTO Users VALUES(?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, FirstName);
            pstmt.setString(2, LastName);
            pstmt.setString(3, UserName);
            pstmt.setString(4, Password);
            pstmt.setString(5, Email);
            pstmt.setString(6, blob);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }
    

    public void updatePicture(String UserName, String filename) {
        // update sql
        String updateSQL = "UPDATE Users "
                + "SET Picture = ? "
                + "WHERE UserName=?";
 
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
 
            // set parameters
            pstmt.setBytes(1, readFile(filename));
            pstmt.setString(2, UserName);
 
            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SQLiteJDBCDriverConnection app = new SQLiteJDBCDriverConnection();
        app.selectAll();
        //app.insertUser("Edwin", "Langley", "EdwinLangley1", "password", "edwin@langley.co.uk", "01010101010");
        app.updatePicture("EdwinLangley2", "D:\\Users\\Edwin\\Downloads\\14463110_1206091416079967_1082422483814707867_n.jpg");
        
    }
}
