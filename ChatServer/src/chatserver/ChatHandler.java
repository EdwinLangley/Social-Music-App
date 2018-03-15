/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import DataPacket.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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

        DataPacket inputData = new DataPacket();
        try {
            inputData = NetworkInterfaces.RecieveDataPacket(socket);
//            ui.outputToConsole("DATA PACKET RECIEVED");
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        String inputCommand = inputData.getCommand();
        switch (inputCommand) {
            case "SND"://Send chat message
                ChatData recievedMessage = new ChatData();
                try {
                    recievedMessage = NetworkInterfaces.RecieveChat(socket);
                    //Add database entry here
                } catch (IOException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "REC"://Recieve chat message
                ChatMessages voicemail = null;
                try {
                    //ChatMessages voicemail = Pull messages from database();
                    if (voicemail.messages.length < 1) {
                        voicemail.isEmpty = true;
                    } else {
                        voicemail.isEmpty = false;
                    }
                    NetworkInterfaces.SendChat(socket, voicemail);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
    }

}
