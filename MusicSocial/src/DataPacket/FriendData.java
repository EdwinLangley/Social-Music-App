/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

/**
 *
 * @author jcgri
 */
public class FriendData extends DataPacket {

    public String otherUsername;

    public FriendData(String command, String username, String otherUsername) {
        super(command, username);
        this.otherUsername = otherUsername;
    }

}