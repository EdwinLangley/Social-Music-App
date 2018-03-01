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
    
    private Connection connect()throws IOException, SQLException {
        // SQLite connection string
        String url = "jdbc:sqlite:D:/Users/Edwin/Documents/SystemsSoftware/SocialServer/db/SocialServer.db";
        Connection conn = null;

        conn = DriverManager.getConnection(url);

        return conn;
    }
    
    
    public boolean isGoodLogin(String UserName, String Password)throws IOException, SQLException{
        String sql = "SELECT * FROM Logins WHERE UserName = ? AND Password = ?";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, UserName);
        pstmt.setString(2, Password);
        ResultSet rs = pstmt.executeQuery();
        conn.close();
            // loop through the result set
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
        
        
    }

    public void insertUser(String FirstName, String LastName, String UserName, String Email, String GenreList, String blob) throws IOException, SQLException {
        String sql = "INSERT INTO UserData(FirstName,LastName,UserName, Email, GenreList,Picture) VALUES(?,?,?,?,?,?)";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, FirstName);
        pstmt.setString(2, LastName);
        pstmt.setString(3, UserName);
        pstmt.setString(4, Email);
        pstmt.setString(5, GenreList);
        pstmt.setString(6, blob);
        pstmt.executeUpdate();
        
        conn.close();
        
        
    }

    public void insertLoginData(String UserName, String Password) throws IOException, SQLException {
        String sql = "INSERT INTO Logins(UserName,Password) VALUES(?,?)";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, UserName);
        pstmt.setString(2, Password);
        pstmt.executeUpdate();
        
        conn.close();
        
        
    }

    public void insertSong(int ID, String SongName, String Data, String Artist, String GenreList, String UserName) throws IOException, SQLException {
        String sql = "INSERT INTO Songs(ID,Name,Data,Artist,Genres,UserName) VALUES(?,?,?,?,?,?)";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        pstmt.setString(2, SongName);
        pstmt.setString(3, Data);
        pstmt.setString(4, Artist);
        pstmt.setString(5, GenreList);
        pstmt.setString(6, UserName);
        pstmt.executeUpdate();
        
        conn.close();
        
        
    }
    
        public void addPost(int ID, String Content, String TimeStamp, String Song, String Mood, String UserName) throws IOException, SQLException {
        String sql = "INSERT INTO Posts(ID,Content,Time,AttachedSong,Mood,UserName) VALUES(?,?,?,?,?,?)";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        pstmt.setString(2, Content);
        pstmt.setString(3, TimeStamp);
        pstmt.setString(4, Song);
        pstmt.setString(5, Mood);
        pstmt.setString(6, UserName);
        pstmt.executeUpdate();
        
        conn.close();
        
        
    }
    
    public void selectAll()throws IOException, SQLException{
        String sql = "SELECT * FROM UserData";
        
            Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + "," + rs.getString("LastName")+ "," + rs.getString("UserName") + ","  + rs.getString("Email"));
            }
            
        conn.close();
            
    }
    
        public void getPostsBy(String UserName)throws IOException, SQLException{
        String sql = "SELECT * FROM Posts WHERE UserName = ? ";
        
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, UserName);
            ResultSet rs    = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "," + rs.getString("Content")+ "," + rs.getString("Time"));
            }
            
        conn.close();
            
    }
        
        public int getNextPostID()throws IOException, SQLException{
        String sql = "SELECT ID FROM Posts ORDER BY ID DESC LIMIT 1";
        
        
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            
            int Index = 0;
            
            while(rs.next()){
                Index = rs.getInt("ID");
            }

              conn.close();
              return Index + 1;
        
        }
            

             
    
    public static void main(String[] args) throws IOException, SQLException {
        SQLiteJDBCDriverConnection app = new SQLiteJDBCDriverConnection();
        app.selectAll();
        
//        if(app.isGoodLogin("Edwin", "Password")){
//            System.out.println("Good login");
//        } else {
//            System.out.println("Bad login");
//        }

        app.addPost(app.getNextPostID(), "Content", "TimeStamp", "Song", "Mood", "Edwin");
        app.addPost(app.getNextPostID(), "Content", "TimeStamp", "Song", "Mood", "Edwin");
        app.addPost(app.getNextPostID(), "Content", "TimeStamp", "Song", "Mood", "Joe");
        
        System.out.println("================");
        
    }
}
