/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Edwin
 */
public class SQLiteJDBCDriverConnection {
    
    
    public static void connect(){
    
        Connection conn = null;
        try{
            
            String url = "jdbc:sqlite:D:/Users/Edwin/Documents/SystemsSoftware/SocialServer/db/SocialServer.db";
            
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    }
}
