/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DataPacket.*;
import Database.SQLiteJDBCDriverConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
        databaseCheck.addNewFriend(friendData.username, friendData.otherUsername);
        databaseCheck.addNewFriend(friendData.otherUsername, friendData.username);
    }

    public static void uploadSong(SongData songInfo) throws IOException, SQLException {
        databaseCheck.insertSong(databaseCheck.getNextSongID(), songInfo.songName, songInfo.song, songInfo.image, songInfo.artist, songInfo.genreListString, songInfo.username);
    }

    public static void uploadPost(PostData postData) throws IOException, SQLException {
        databaseCheck.addPost(databaseCheck.getNextPostID(), postData.postMessage, postData.attachedSong, postData.postMood, postData.username);
    }

    public static SongData getSong(DataPacket dataPacket) throws IOException, UnsupportedAudioFileException, SQLException {
        SongData requestedSong = databaseCheck.getSongByID(dataPacket.ID);
        return requestedSong;
    }

    public static MainPageData buildMainPage(DataPacket dataPacket) throws IOException, SQLException, UnsupportedAudioFileException {
        ArrayList<UserData> allFriends = databaseCheck.returnFriends(dataPacket.username);
        ArrayList<UserData> onlineFriends = new ArrayList<>();
        for (int i = 0; i < server.Server.currentUsers.size(); i++) {
            if (allFriends.contains(server.Server.currentUsers.get(i))) {
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
        MainPageData mainPage = new MainPageData(allFriends, onlineFriends, friendsPosts, inYourNetwork, yourQueue);
        return mainPage;
    }

}
