/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.util.ArrayList;

/**
 *
 * @author jcgri
 */
public class MainPageData extends DataPacket {

    public ArrayList<UserData> allFriends;
    public ArrayList<UserData> onlineFriends;
    public ArrayList<PostData> friendsPosts;
    public ArrayList<SongData> inYourNetwork;
    public ArrayList<SongData> yourQueue;

    public MainPageData() {
    }

    public MainPageData(ArrayList<UserData> allFriends, ArrayList<UserData> onlineFriends, ArrayList<PostData> friendsPosts, ArrayList<SongData> inYourNetwork, ArrayList<SongData> yourQueue) {
        this.command = "MainPageData";
        this.allFriends = allFriends;
        this.onlineFriends = onlineFriends;
        this.friendsPosts = friendsPosts;
        this.inYourNetwork = inYourNetwork;
        this.yourQueue = yourQueue;
    }
}
