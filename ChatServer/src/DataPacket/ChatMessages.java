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
public class ChatMessages {

    public ChatData[] messages;
    public boolean isEmpty;

    public ChatMessages(ChatData[] messages) {
        this.messages = messages;
    }

}
