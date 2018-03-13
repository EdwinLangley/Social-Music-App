/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import DataPacket.ChatData;
import DataPacket.NetworkInterfaces;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcgri
 */
public class ChatHandler implements Runnable {

    private Socket socket = null;
    public boolean openConnection = true;

    public ChatHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ChatData recievedMessage = new ChatData();
        try {
            recievedMessage = NetworkInterfaces.RecieveChat(socket);
//            NetworkInterfaces.SendChat(/*Call get ip address function*/, recievedMessage);
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
