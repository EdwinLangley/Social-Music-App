/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DataPacket.*;
import DataPacket.NetworkInterfaces;
import java.net.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import static server.ControlHandler.databaseCheck;

/**
 *
 * @author Joe
 */
public class ClientNetworkInterface implements Runnable {

    private Socket socket = null;
    public boolean openConnection = true;
    public ServerUI ui;

    public ClientNetworkInterface(Socket socket, ServerUI ui) {
        this.socket = socket;
        this.ui = ui;
    }

    @Override
    public void run() {
        //insert client listener in here
//        ClientHandler newClient = new ClientHandler();
//        newClient.setUpClientInstance(socket);

        DataPacket inputData = new DataPacket();
        
        try {
            inputData = NetworkInterfaces.RecieveDataPacket(socket);
            ui.outputToConsole("DATA PACKET RECIEVED");
        } catch (IOException ex) {
            Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        ui.outputToConsole("Run hit for: " + inputData.username);
        String inputCommand = inputData.getCommand();
        OpenConnectionLoop:
        while (openConnection) {
            /**
             * Case statements for each command new Control handler object that
             * takes input Datapacket as a control sequence and then sends
             * appropriate data back Also needs to switch so it then takes data
             * input from client Ensure break after each major statement
             *
             */
            ui.outputToConsole("SwitchStatement");
            ui.outputToConsole(inputData.getCommand());
            switch (inputCommand) {
                case "EXT"://Logout
                    ui.outputToConsole("EXT Switch hit");
                    openConnection = false;
                    for (int i = 0; i < server.Server.currentUsers.size(); i++) {
                        UserData single = server.Server.currentUsers.get(i);
                        if (single.username.equals(inputData.username)) {
                            server.Server.currentUsers.remove(i);
                        }
                    }
                    ui.outputToConsole("hit");
                    break OpenConnectionLoop;
                case "REG"://Register User
                    ui.outputToConsole("REG Switch hit");
                    UserData registerUserData = null;
                    try {
                        registerUserData = NetworkInterfaces.RecieveUserData(socket);
                        ui.outputToConsole("USERDATA PACKET RECIEVED");
                    } catch (IOException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        ControlHandler.RegisterUser(registerUserData);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Server.currentUsers.add(registerUserData);
                    ui.outputToConsole("GOT USER DATA:" + registerUserData.firstName);
                    break OpenConnectionLoop;
                //Call relevant function
                case "LGN"://Login
                    ui.outputToConsole("LGN Switch hit");
                    LoginData loginData = null;
                    NotificationPacket loginResponse = new NotificationPacket();
                    try {
                        loginData = NetworkInterfaces.RecieveLoginData(socket);
                        if (ControlHandler.Login(loginData)) {
                            loginResponse.setCommand("ACK");
                            loginResponse.setNotification("Good Login");
                            NetworkInterfaces.SendNotificationPacket(socket, loginResponse);
                            UserData login = databaseCheck.getUserDataByUserName(loginData.username);
                            login.IPAddress = loginData.IPAddress;
                            server.Server.currentUsers.add(login);
                        } else {
                            loginResponse.setCommand("NAK");
                            loginResponse.setNotification("Bad Login");
                            NetworkInterfaces.SendNotificationPacket(socket, loginResponse);
                        }
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                case "SFR"://Search for Friend Recomendations
                    //Call relevant function
                    break;
                case "AFR"://Add Friend
                    ui.outputToConsole("AFR Switch hit");
                    try {
                        FriendData friendData = NetworkInterfaces.RecieveFriendData(socket);
                        ControlHandler.addFriend(friendData);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                case "FFR"://Friend Request Response
                    ui.outputToConsole("FFR Switch hit");
                    try {
                        FriendData friendData = NetworkInterfaces.RecieveFriendData(socket);
                        if ("Accepted".equals(friendData.status)) {
                            ControlHandler.acceptFriend(friendData);
                        } else {
                            ControlHandler.rejectFriend(friendData);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                case "PST"://Upload Post
                    ui.outputToConsole("PST Switch hit");
                    try {
                        PostData postData = NetworkInterfaces.RecievePostData(socket);
                        ControlHandler.uploadPost(postData);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                case "RPT"://Request Posts
                    ui.outputToConsole("RPT Switch hit");
                    try {
                        NetworkInterfaces.SendPostsData(socket, ControlHandler.getPosts());
                    } catch (IOException | SQLException | UnsupportedAudioFileException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                case "UPS"://Upload Song
                    ui.outputToConsole("UPS Switch hit");
                    try {
                        SongData songData = NetworkInterfaces.RecieveSongData(socket);
                        ControlHandler.uploadSong(songData);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                case "RSG"://Request song
                    ui.outputToConsole("RSG Switch hit");
                    try {
                        NetworkInterfaces.SendSongData(socket, ControlHandler.getSong(inputData));
                    } catch (IOException | SQLException | UnsupportedAudioFileException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;

                case "UMP"://Update the Main Page
                    ui.outputToConsole("UMP Switch hit");
                    try {
                        NetworkInterfaces.SendMainPageData(socket, ControlHandler.buildMainPage(inputData));
                    } catch (IOException | SQLException | UnsupportedAudioFileException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break OpenConnectionLoop;
                default:
                    break OpenConnectionLoop;
            }
        }
        ui.outputToConsole("End of Thread");
    }
}
