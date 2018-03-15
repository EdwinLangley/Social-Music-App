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
    public ArrayList<UserData> allUsers;
    public ArrayList<UserData> onlineFriends;
    public ArrayList<PostData> friendsPosts;
    public ArrayList<SongData> inYourNetwork;
    public ArrayList<SongData> yourQueue;
    public ArrayList<UserData> iRequestedFriendShip;
    public ArrayList<UserData> requestedMyFriendShipFrom;

    public MainPageData() {
    }

    public MainPageData(ArrayList<UserData> allFriends,ArrayList<UserData> allUsers, ArrayList<UserData> onlineFriends, ArrayList<PostData> friendsPosts, ArrayList<SongData> inYourNetwork, ArrayList<SongData> yourQueue,ArrayList<UserData> iRequestedFriendShip, ArrayList<UserData> requestedMyFriendShipFrom ) {
        this.command = "MainPageData";
        this.allFriends = allFriends;
        this.allUsers = allUsers;
        this.onlineFriends = onlineFriends;
        this.friendsPosts = friendsPosts;
        this.inYourNetwork = inYourNetwork;
        this.yourQueue = yourQueue;
        this.iRequestedFriendShip = iRequestedFriendShip;
        this.requestedMyFriendShipFrom = requestedMyFriendShipFrom;
    }
}
