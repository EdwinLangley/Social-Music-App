/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DataPacket.*;
import Database.SQLiteJDBCDriverConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author jcgri
 *
 * Contains a list of static methods that are used to control data flow for the
 * server Is only used in the switch statement in ClientNetworkInterface
 *
 */
public class ControlHandler {

    public static SQLiteJDBCDriverConnection databaseCheck = new SQLiteJDBCDriverConnection();

    public static void RegisterUser(UserData userInfo) throws IOException, SQLException {
        databaseCheck.insertUser(userInfo.firstName, userInfo.lastName, userInfo.username, userInfo.email, userInfo.genreListString, userInfo.image);
        databaseCheck.insertLoginData(userInfo.username, userInfo.passsword);
    }

    public static boolean Login(LoginData loginInfo) throws IOException, SQLException {
        return databaseCheck.isGoodLogin(loginInfo.username, loginInfo.passsword) == true;
    }

    public static void SearchForFriendRecommendations() {

    }

    public static ArrayList<PostData> getPosts() throws IOException, SQLException, UnsupportedAudioFileException {

        ArrayList<PostData> postList = new ArrayList<PostData>();

        for (int i = databaseCheck.getCurrentPostID(); ((i > (databaseCheck.getCurrentPostID() - 5)) || (i < 0)); i--) {
            postList.add(databaseCheck.getPostsByID(i));
        }

        return postList;

    }

    public static void addFriend(FriendData friendData) throws IOException, SQLException {
        databaseCheck.addNewFriend(friendData.username, friendData.otherUsername, friendData.status);
        databaseCheck.addNewFriend(friendData.otherUsername, friendData.username, friendData.status);
    }

    public static void acceptFriend(FriendData friendData) throws IOException, SQLException {
        databaseCheck.updateFriendStatus(friendData);
    }

    public static void rejectFriend(FriendData friendData) throws IOException, SQLException {
        databaseCheck.removeFriendPair(friendData);
    }

    public static void uploadSong(SongData songInfo) throws IOException, SQLException {
        System.out.println(songInfo.userName);
        File AudioDir = new File("Audio/" + songInfo.songName + ".wav");
        File ImgDir = new File("IMG/" + songInfo.songName + ".png");
        String dbPathAudio = "Audio/" + songInfo.songName + ".wav";
        String dbPathIMG = "IMG/" + songInfo.songName + ".png";

        byte[] songData = songInfo.song;
        FileOutputStream retreievdClientSong = new FileOutputStream(AudioDir);
        retreievdClientSong.write(songData);

        byte[] artData = songInfo.AlbumArt;
        FileOutputStream retreievdAlbumArt = new FileOutputStream(ImgDir);
        retreievdAlbumArt.write(artData);

        databaseCheck.insertSong(databaseCheck.getNextSongID(), songInfo.songName, dbPathAudio, dbPathIMG, songInfo.artist, songInfo.genre, songInfo.userName);
    }

    public static void uploadPost(PostData postData) throws IOException, SQLException {
        databaseCheck.addPost(databaseCheck.getNextPostID(), postData.postMessage, postData.attachedSong, postData.postMood, postData.username);
    }

    public static SongData getSong(DataPacket dataPacket) throws IOException, UnsupportedAudioFileException, SQLException {
        ArrayList<String> requestedSong = databaseCheck.getSongByID(dataPacket.ID);
        FileInputStream songData;
        FileInputStream ArtWork;

        songData = new FileInputStream(requestedSong.get(0));
        byte[] songBuffer = new byte[songData.available()];
        songData.read(songBuffer);

        ArtWork = new FileInputStream(requestedSong.get(1));
        byte[] ArtBuffer = new byte[ArtWork.available()];
        ArtWork.read(ArtBuffer);

        SongData returnSong = new SongData(ArtBuffer, songBuffer);

        return returnSong;
    }

    public static MainPageData buildMainPage(DataPacket dataPacket) throws IOException, SQLException, UnsupportedAudioFileException {
        ArrayList<UserData> allFriends = databaseCheck.returnFriends(dataPacket.username);
        ArrayList<UserData> allUsers = databaseCheck.returnAllUsers();
        ArrayList<UserData> onlineFriends = new ArrayList<>();
        if (!server.Server.currentUsers.isEmpty()) {
            for (int i = 0; i < server.Server.currentUsers.size(); i++) {
                onlineFriends.add(server.Server.currentUsers.get(i));
            }
        }

        ArrayList<PostData> friendsPosts = new ArrayList<>();
        ArrayList<SongData> inYourNetwork = new ArrayList<>();
        for (int i = 0; i < allFriends.size(); i++) {
            //Get Posts
            friendsPosts.addAll(databaseCheck.getPostsBy(allFriends.get(i).username));
            //Get friends songs
            inYourNetwork.addAll(databaseCheck.getSongByUserName(allFriends.get(i).username));
        }
        ArrayList<SongData> yourQueue = new ArrayList<>();
        yourQueue = databaseCheck.getSongByUserName(dataPacket.username);
        MainPageData mainPage = new MainPageData(allFriends, allUsers, onlineFriends, friendsPosts, inYourNetwork, yourQueue);
        return mainPage;
    }

    public static UserData getUserData(String Username) throws IOException {
        try {
            return databaseCheck.getUserDataByUserName(Username);
        } catch (SQLException ex) {
            Logger.getLogger(ControlHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
