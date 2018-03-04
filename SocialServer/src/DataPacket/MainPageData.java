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

    public ArrayList<String> friends;
    public ArrayList<PostData> friendsPosts;
    public ArrayList<PostData> inYourNetwork;
    public ArrayList<SongData> yourQueue;

    public MainPageData() {
    }

    public MainPageData(ArrayList<String> friends, ArrayList<PostData> friendsPosts, ArrayList<PostData> inYourNetwork, ArrayList<SongData> yourQueue) {
        this.command = "MainPageData";
        this.friends = friends;
        this.friendsPosts = friendsPosts;
        this.inYourNetwork = inYourNetwork;
        this.yourQueue = yourQueue;
    }
}
