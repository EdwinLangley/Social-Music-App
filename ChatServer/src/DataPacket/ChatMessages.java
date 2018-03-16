/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jcgri
 */
public class ChatMessages implements Serializable{

    public ArrayList<ChatData> messages;
    public boolean isEmpty;

    public ChatMessages(ArrayList<ChatData> messages) {
        this.messages = messages;
    }

}
