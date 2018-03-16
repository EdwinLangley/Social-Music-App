/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import DataPacket.*;
import Database.SQLiteJDBCDriverConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcgri
 */
public class OutboundChatHandler implements Runnable {

    public static SQLiteJDBCDriverConnection databaseCheck = new SQLiteJDBCDriverConnection();

    private Socket outboundSocket = null;
    public boolean openConnection = true;

    public OutboundChatHandler(Socket outboundSocket) throws UnknownHostException, IOException {
        this.outboundSocket = outboundSocket;
    }

    @Override
    public void run() {

        DataPacket inputData = new DataPacket();
//        DataPacket recievePacket = new DataPacket();
        try {
            inputData = NetworkInterfaces.RecieveDataPacket(outboundSocket);
//            recievePacket = NetworkInterfaces.RecieveDataPacket(outboundSocket);
//            ui.outputToConsole("DATA PACKET RECIEVED");
        } catch (IOException ex) {
            Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("REC Switch hit");
        ChatMessages voicemail = null;
        try {
            //ChatMessages voicemail = Pull messages from database();
           //ChatMessages changed = new ChatMessafes(databaseCheck.readAndDelete(inputData.username, inputData.secondUsername));
//            ArrayList<ChatData> changed = new ArrayList<ChatData>();
//
//            FileInputStream ArtWork;
//
//            for (int i = 0; i < changeForOutput.size(); i++) {
//                ChatData temp = changeForOutput.get(i);
//                ArtWork = new FileInputStream(temp.extension);
//                byte[] ArtBuffer = new byte[ArtWork.available()];
//                ArtWork.read(ArtBuffer);
//
//                ChatData addToOutput = new ChatData(temp.sendingUser, temp.recievingUser, temp.mesageContent, temp.extension, ArtBuffer);
//                changed.add(addToOutput);
//            }

            voicemail = new ChatMessages(databaseCheck.readAndDelete(inputData.username, inputData.secondUsername));
            if (voicemail.messages.size() < 1) {
                voicemail.isEmpty = true;
            } else {
                voicemail.isEmpty = false;
            }
            //System.out.println(voicemail.messages.get(0).mesageContent);
            NetworkInterfaces.SendChat(outboundSocket, voicemail);
        } catch (UnknownHostException ex) {
            Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread End");
    }
}
