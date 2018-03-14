/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import DataPacket.PostData;
import DataPacket.SongData;
import DataPacket.UserData;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Edwin
 *
 */
public class SQLiteJDBCDriverConnection {

    private Connection connect() throws IOException, SQLException {
        // SQLite connection string
        String url = "jdbc:sqlite:db/SocialServer.db";
        Connection conn = null;

        conn = DriverManager.getConnection(url);

        return conn;
    }

    public boolean isGoodLogin(String UserName, String Password) throws IOException, SQLException {
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
    
        public void insertIP(String IP, String UserName) throws IOException, SQLException {
        String sql = "UPDATE UserData SET IP = ? WHERE UserName = ?";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, IP);
        pstmt.setString(2, UserName);

        pstmt.executeUpdate();

        conn.close();

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

    public void insertSong(int ID, String SongName, String songData, String picData, String Artist, String GenreList, String UserName) throws IOException, SQLException {
        String sql = "INSERT INTO Songs(ID,Name,Data,Art,Artist,Genres,UserName) VALUES(?,?,?,?,?,?,?)";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        pstmt.setString(2, SongName);
        pstmt.setString(3, songData);
        pstmt.setString(4, picData);
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

    public void selectAll() throws IOException, SQLException {
        String sql = "SELECT * FROM UserData";

        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // loop through the result set
        while (rs.next()) {
            System.out.println(rs.getString("FirstName") + "," + rs.getString("LastName") + "," + rs.getString("UserName") + "," + rs.getString("Email"));
        }

        conn.close();

    }

    public ArrayList<PostData> getPostsBy(String UserName) throws IOException, SQLException {

        ArrayList<PostData> posts = new ArrayList<PostData>();
        String sql = "SELECT * FROM Posts WHERE UserName = ? ";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, UserName);
        ResultSet rs = pstmt.executeQuery();

        // loop through the result set
        while (rs.next()) {
            PostData temppost = new PostData(rs.getInt("ID"),rs.getString("UserName"), rs.getString("Time") ,rs.getInt("AttachedSong"), rs.getString("Content"), rs.getString("Mood"));
            posts.add(temppost);
        }

        conn.close();

        return posts;
    }

    public PostData getPostsByID(int ID) throws IOException, SQLException, UnsupportedAudioFileException {
        PostData returnPost = null;

        String sql = "SELECT * FROM Posts WHERE ID = ? ";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        ResultSet rs = pstmt.executeQuery();

        // loop through the result set
        while (rs.next()) {
            returnPost = new PostData(rs.getInt("ID"),rs.getString("UserName"), rs.getString("Time") ,rs.getInt("AttachedSong"), rs.getString("Content"), rs.getString("Mood"));
        }

        conn.close();

        return returnPost;
    }

    public ArrayList<String> getSongByID(int ID) throws IOException, SQLException, UnsupportedAudioFileException {

        ArrayList<String> fileLocations = new ArrayList<String>();
        
        String sql = "SELECT * FROM Songs WHERE ID = ? ";
        
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        ResultSet rs = pstmt.executeQuery();
        

        // loop through the result set
        while (rs.next()) {
            fileLocations.add(rs.getString("Data"));
            fileLocations.add(rs.getString("Art"));
        }

        conn.close();

        return fileLocations;

    }

    public ArrayList<SongData> getSongByUserName(String UserName) throws IOException, SQLException, UnsupportedAudioFileException {
        ArrayList<SongData> songs = new ArrayList<SongData>();
        File albumArt = null;
        File song = null;
        SongData returnSong = null;
        String sql = "SELECT * FROM Songs WHERE UserName = ? ";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, UserName);
        ResultSet rs = pstmt.executeQuery();

        // loop through the result set
        while (rs.next()) {

            String genreList = rs.getString("Genres");
            List<String> genres = Arrays.asList(genreList.split("\\s*,\\s*"));
            ArrayList<String> genreArrayList = new ArrayList<>(genres);

            returnSong = new SongData(rs.getInt("ID"), rs.getString("Name"), rs.getString("Artist"), rs.getString("Album"), rs.getString("Genres"),rs.getString("UserName") );
            songs.add(returnSong);
        }

        conn.close();

        return songs;

    }

    public int getNextPostID() throws IOException, SQLException {
        String sql = "SELECT ID FROM Posts ORDER BY ID DESC LIMIT 1";

        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        int Index = 0;

        while (rs.next()) {
            Index = rs.getInt("ID");
        }

        conn.close();
        return Index + 1;

    }

    public int getCurrentPostID() throws IOException, SQLException {
        String sql = "SELECT ID FROM Posts ORDER BY ID DESC LIMIT 1";

        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        int Index = 0;

        while (rs.next()) {
            Index = rs.getInt("ID");
        }

        conn.close();
        return Index;

    }

    public int getNextSongID() throws IOException, SQLException {
        String sql = "SELECT ID FROM Songs ORDER BY ID DESC LIMIT 1";

        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        int Index = 0;

        while (rs.next()) {
            Index = rs.getInt("ID");
        }

        conn.close();
        return Index + 1;

    }
//CHANGE THIS SO IT SETS STATUS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void addNewFriend(String username1, String username2) throws IOException, SQLException {
        String sql = "INSERT INTO Friendships VALUES(?,?)";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username1);
        pstmt.setString(2, username2);
        pstmt.executeUpdate();

        conn.close();

    }

    public ArrayList<UserData> returnFriends(String username) throws IOException, SQLException {//ArrayList<UserData>

        ArrayList<UserData> returnedFriendsData = new ArrayList<UserData>();
        String sql = "SELECT username2 FROM Friendships where username1 = ?";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<String> returnedFriends = new ArrayList<String>();

        while (rs.next()) {
            returnedFriends.add(rs.getString("username2"));
        }

        conn.close();

        for (int i = 0; i < returnedFriends.size(); i++) {
            returnedFriendsData.add(this.getUserDataByUserName(returnedFriends.get(i)));
        }

        return returnedFriendsData;

    }

    public UserData getUserDataByUserName(String username) throws IOException, SQLException {//ArrayList<UserData>

        UserData returnedFriends = null;
        String sql = "SELECT * FROM UserData WHERE UserName = ? ";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        File file = new File("./src/images/6027fe7edf669a864347e7b011d7c126.jpg");
        String password = "";

        while (rs.next()) {
            //UserData newUser = new UserData(UserData(rs.getInt("ID"),rs.getString("UserName"),password,rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Email"), rs.getString("GenreList"), file))
            String genreList = rs.getString("GenreList");
            List<String> genres = Arrays.asList(genreList.split("\\s*,\\s*"));
            ArrayList<String> genreArrayList = new ArrayList<>(genres);

            returnedFriends = new UserData(rs.getInt("ID"), rs.getString("UserName"), password, rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), genreArrayList, file);

        }

        conn.close();

        return returnedFriends;

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

    public void updatePicture(String UserName, String filename) throws IOException, SQLException {
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

    public static void main(String[] args) throws IOException, SQLException, UnsupportedAudioFileException {
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
        //app.addNewFriend("Ed", "Joe");
        //PostData posts = app.getPostsByID(0);
        //System.out.println(posts.ID + posts.postMessage + posts.username + posts.postMood);
        app.returnFriends("Ed");
        //app.getUserDataByUserName("griffindore");
        System.out.println("================");

        //app.updatePicture("UserName", "D:\\Users\\Edwin\\Downloads\\14463110_1206091416079967_1082422483814707867_n.jpg");
    }

    public ArrayList<UserData> returnAllUsers()throws IOException, SQLException, UnsupportedAudioFileException {
        ArrayList<UserData> returnedUserData = new ArrayList<UserData>();
        String sql = "SELECT * FROM UserData";

        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        File file = new File("./src/images/6027fe7edf669a864347e7b011d7c126.jpg");
        
        while(rs.next()){
            
            String genreList = rs.getString("GenreList");
            List<String> genres = Arrays.asList(genreList.split("\\s*,\\s*"));
            ArrayList<String> genreArrayList = new ArrayList<>(genres);
            
            UserData tempUser = new UserData(rs.getInt("ID"), rs.getString("UserName"), "", rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), genreArrayList, file);
            
            returnedUserData.add(tempUser);
            
        }
        
        conn.close();

        

        return returnedUserData;

    }
}
