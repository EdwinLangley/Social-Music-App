/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import DataPacket.ChatData;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
 
/**
 *
 * @author Edwin
 */

//String url = "jdbc:sqlite:db/ChatServer.db";
public class SQLiteJDBCDriverConnection {
     /**
     * Connect to a sample database
     */
    private Connection connect() throws IOException, SQLException {
        // SQLite connection string
        String url = "jdbc:sqlite:db/ChatServer.db";
        Connection conn = null;

        conn = DriverManager.getConnection(url);

        return conn;
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws IOException, SQLException {
//        SQLiteJDBCDriverConnection app = new SQLiteJDBCDriverConnection();
//        //ChatData test =  new ChatData("ed", "joe", "Helloooo");
//        //app.insertMessageIntoDatabase(test);
//
//    }

    public void insertMessageIntoDatabase(ChatData recievedMessage/*,String path*/) throws IOException, SQLException {
        String sql = "INSERT INTO Messages(SentFrom,SentTo,Message) VALUES(?,?,?)";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, recievedMessage.sendingUser);
        pstmt.setString(2, recievedMessage.recievingUser);
        pstmt.setString(3, recievedMessage.mesageContent);

        pstmt.executeUpdate();

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteJDBCDriverConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ChatData> readAndDelete(String sentTo ,String sentFrom ) throws SQLException, IOException {
        String sql = "SELECT * FROM Messages WHERE SentTo = ? AND SentFrom = ? ";
        
        ArrayList<ChatData> sendBack = new ArrayList<ChatData>();

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sentTo);
        pstmt.setString(2, sentFrom);

        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            sendBack.add(new ChatData(rs.getString("SentFrom"), rs.getString("SentTo"),rs.getString("Message"), rs.getString("FileStuff"), rs.getInt("songID")));
        }

        conn.close();
        
        
        sql = "DELETE FROM Messages WHERE SentTo = ? AND SentFrom = ?  ";

        conn = this.connect();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sentTo);
        pstmt.setString(2, sentFrom);

        pstmt.executeUpdate();

        conn.close();

        return sendBack;
        
    }
    
    public void readAndDeletetest(String sentTo ,String sentFrom ) throws SQLException, IOException {
        String sql = "SELECT * FROM Messages WHERE SentTo = ? AND SentFrom = ? ";
        
        ArrayList<ChatData> sendBack = new ArrayList<ChatData>();

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sentTo);
        pstmt.setString(2, sentFrom);

        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            //sendBack.add(new ChatData(rs.getString("SentFrom"), rs.getString("SentTo"),rs.getString("Message"), rs.getString("FileStuff"), rs.getInt("songID")));
            System.out.println(rs.getString("SentFrom") + rs.getString("SentTo") + rs.getString("Message") + rs.getString("FileStuff") + rs.getInt("songID"));
        }

        conn.close();

} 
    
    
    public static void main(String[] args) throws IOException, SQLException, UnsupportedAudioFileException {
        SQLiteJDBCDriverConnection app = new SQLiteJDBCDriverConnection();
  
        
        app.readAndDeletetest("ed","io");
        
    }

    
}

