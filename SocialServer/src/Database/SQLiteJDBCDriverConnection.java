/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import DataPacket.PostData;
import DataPacket.SongData;
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
import java.util.ArrayList;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author Edwin
 * 
 */


public class SQLiteJDBCDriverConnection {
    
        
    private Connection connect()throws IOException, SQLException {
        // SQLite connection string
        String url = "jdbc:sqlite:db/SocialServer.db";
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

    public void insertUser(String FirstName, String LastName, String UserName, String Email, String GenreList, byte[] blob) throws IOException, SQLException {
        String sql = "INSERT INTO UserData(FirstName,LastName,UserName, Email, GenreList,Picture) VALUES(?,?,?,?,?,?)";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, FirstName);
        pstmt.setString(2, LastName);
        pstmt.setString(3, UserName);
        pstmt.setString(4, Email);
        pstmt.setString(5, GenreList);
        pstmt.setBytes(6, blob);
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

    public void insertSong(int ID, String SongName, byte[] songData,byte[] picData, String Artist, String GenreList, String UserName) throws IOException, SQLException {
        String sql = "INSERT INTO Songs(ID,Name,Data,Art,Artist,Genres,UserName) VALUES(?,?,?,?,?,?,?)";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        pstmt.setString(2, SongName);
        pstmt.setBytes(3, songData);
        pstmt.setBytes(4, picData);
        pstmt.setString(5, Artist);
        pstmt.setString(6, GenreList);
        pstmt.setString(7, UserName);
        pstmt.executeUpdate();
        
        conn.close();
        
        
    }
    
        public void addPost(int ID, String Content, int Song, String Mood, String UserName) throws IOException, SQLException {
        String sql = "INSERT INTO Posts(ID,Content,AttachedSong,Mood,UserName) VALUES(?,?,?,?,?)";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        pstmt.setString(2, Content);
        pstmt.setInt(3, Song);
        pstmt.setString(4, Mood);
        pstmt.setString(5, UserName);
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
        
        public PostData getPostsByID(int ID)throws IOException, SQLException,UnsupportedAudioFileException{
            PostData returnPost = null;
            
        String sql = "SELECT * FROM Posts WHERE ID = ? ";
        
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            ResultSet rs    = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                returnPost = new PostData(rs.getInt("ID"), this.getSongByID(ID), rs.getString("Content"), rs.getString("Mood"));
            }
            
        conn.close();
            
        return returnPost;
    }
        
        public SongData getSongByID(int ID)throws IOException, SQLException, UnsupportedAudioFileException{
        File albumArt = null;
        File song = null;
        ArrayList<String> Genres = new ArrayList<String>();
        SongData returnSong = null;
        String sql = "SELECT * FROM Songs WHERE ID = ? ";
        
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            ResultSet rs    = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                Genres.add(rs.getString("Genres"));
                returnSong = new SongData(rs.getInt("ID"), rs.getString("Name"), rs.getString("Artist"),rs.getString("Album") , Genres, albumArt, song);
            }
            
        conn.close();
        
        return returnSong;
            
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
        
        public int getCurrentPostID()throws IOException, SQLException{
        String sql = "SELECT ID FROM Posts ORDER BY ID DESC LIMIT 1";
        
        
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            
            int Index = 0;
            
            while(rs.next()){
                Index = rs.getInt("ID");
            }

              conn.close();
              return Index;
        
        }
        
        public int getNextSongID()throws IOException, SQLException{
        String sql = "SELECT ID FROM Songs ORDER BY ID DESC LIMIT 1";
        
        
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
        
         public void addNewFriend(String username1, String username2)throws IOException, SQLException{
        String sql = "INSERT INTO Friendships VALUES(?,?)";
        
        
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username1);
            pstmt.setString(2, username2);
            pstmt.executeUpdate();
            
            conn.close();
              
        
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
        
        public void updatePicture(String UserName, String filename)throws IOException, SQLException {
        // update sql
        String updateSQL = "UPDATE UserData "
                + "SET picture = ? "
                + "WHERE UserName=?";
 
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(updateSQL);
 
            // set parameters
            pstmt.setBytes(1, readFile(filename));
            pstmt.setString(2, UserName);
 
            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");
 
    }
            

             
    
    public static void main(String[] args) throws IOException, SQLException,UnsupportedAudioFileException {
        SQLiteJDBCDriverConnection app = new SQLiteJDBCDriverConnection();
        //app.selectAll();
        
//        if(app.isGoodLogin("Edwin", "Password")){
//            System.out.println("Good login");
//        } else {
//            System.out.println("Bad login");
//        }

          
//        app.addPost(app.getNextPostID(), "Content", "TimeStamp", "Song", "Mood", "Edwin");
//        app.addPost(app.getNextPostID(), "Content", "TimeStamp", "Song", "Mood", "Joe");
//        
//        app.insertSong(app.getNextSongID(), "SongName", "Data", "Artist", "GenreList", "UserName");


          //app.insertUser("FirstName", "LastName", "UserName", "Email", "GenreList", "blob");
        
          app.addNewFriend("Ed", "Joe");
          
          //PostData posts = app.getPostsByID(0);
          
          //System.out.println(posts.ID + posts.postMessage + posts.username + posts.postMood);
        System.out.println("================");

        //app.updatePicture("UserName", "D:\\Users\\Edwin\\Downloads\\14463110_1206091416079967_1082422483814707867_n.jpg");
        
    }
}
