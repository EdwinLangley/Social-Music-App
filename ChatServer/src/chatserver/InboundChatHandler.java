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
public class InboundChatHandler implements Runnable {

    public static SQLiteJDBCDriverConnection databaseCheck = new SQLiteJDBCDriverConnection();

    private Socket inboundSocket = null;
    public boolean openConnection = true;

    public InboundChatHandler(Socket serverSocket) throws UnknownHostException, IOException {
        this.inboundSocket = serverSocket;
    }

    @Override
    public void run() {

        DataPacket inputData = new DataPacket();
//        DataPacket recievePacket = new DataPacket();
        try {
            inputData = NetworkInterfaces.RecieveDataPacket(inboundSocket);
//            recievePacket = NetworkInterfaces.RecieveDataPacket(outboundSocket);

//            ui.outputToConsole("DATA PACKET RECIEVED");
        } catch (IOException ex) {
            Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        OpenConnectionLoop:
        while (openConnection) {
            String inputCommand = inputData.getCommand();
            switch (inputCommand) {
                case "SND"://Send chat message
                    System.out.print("SND Switch hit");
                    ChatData recievedMessage = new ChatData();
                    try {
                        recievedMessage = NetworkInterfaces.RecieveChat(inboundSocket);

                        File ImgDir = new File("IMG/1.png");
                        String dbPathIMG = "IMG/1.png";

                        byte[] artData = recievedMessage.image;
                        FileOutputStream retreievdAlbumArt = new FileOutputStream(ImgDir);
                        retreievdAlbumArt.write(artData);

                        databaseCheck.insertMessageIntoDatabase(recievedMessage, dbPathIMG);
                        //Add database entry here adding messages to the database 
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;

                case "REC"://Recieve chat message
                    System.out.print("REC Switch hit");
                    ChatMessages voicemail = null;
                    try {
                        //ChatMessages voicemail = Pull messages from database();
                        ArrayList<ChatData> changeForOutput = databaseCheck.readAndDelete(inputData.username, inputData.secondUsername);
                        ArrayList<ChatData> changed = new ArrayList<ChatData>();

                        FileInputStream ArtWork;

                        for (int i = 0; i < changeForOutput.size(); i++) {
                            ChatData temp = changeForOutput.get(i);
                            ArtWork = new FileInputStream(temp.extension);
                            byte[] ArtBuffer = new byte[ArtWork.available()];
                            ArtWork.read(ArtBuffer);

                            ChatData addToOutput = new ChatData(temp.sendingUser, temp.recievingUser, temp.mesageContent, temp.extension, ArtBuffer);
                            changed.add(addToOutput);
                        }

                        voicemail = new ChatMessages(changed);
                        if (voicemail.messages.size() < 1) {
                            voicemail.isEmpty = true;
                        } else {
                            voicemail.isEmpty = false;
                        }
                        NetworkInterfaces.SendChat(inboundSocket, voicemail);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                default:
                    break OpenConnectionLoop;
            }
        }
        System.out.println("Thread End");
    }
}
