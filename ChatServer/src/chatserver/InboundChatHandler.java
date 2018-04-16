/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import DataPacket.*;
import Database.SQLiteJDBCDriverConnection;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
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
    ChatUI ui;

    InboundChatHandler(Socket serverSocket, ChatUI ui) {
        this.inboundSocket = serverSocket;
        this.ui = ui;
    }

    @Override
    public void run() {

        DataPacket inputData = new DataPacket();
        try {
            inputData = NetworkInterfaces.RecieveDataPacket(inboundSocket);
            ui.outputToConsole("DATA PACKET RECIEVED");
        } catch (IOException ex) {
            Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        OpenConnectionLoop:
        while (openConnection) {
            String inputCommand = inputData.getCommand();
            switch (inputCommand) {
                case "SND"://Send chat message
                    ui.outputToConsole("SND Switch hit");
                    ChatData recievedMessage = new ChatData();
                    try {
                        recievedMessage = NetworkInterfaces.RecieveChat(inboundSocket);
                        ui.outputToConsole("Message Recieved");
                        databaseCheck.insertMessageIntoDatabase(recievedMessage); //dbPathIMG);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(InboundChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                default:
                    break OpenConnectionLoop;
            }
        }
        ui.outputToConsole("Thread End");
    }
}
