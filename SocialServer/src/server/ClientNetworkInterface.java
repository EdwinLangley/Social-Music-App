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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joe
 */
public class ClientNetworkInterface /*extends ClientHandler*/ implements Runnable {

    private Socket socket = null;
    public boolean openConnection = true;

    public ClientNetworkInterface(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //insert client listener in here
//        ClientHandler newClient = new ClientHandler();
//        newClient.setUpClientInstance(socket);

        DataPacket inputData = new DataPacket();
        System.out.println("Run hit for: " + Server.currentUsers);
        try {
            inputData = NetworkInterfaces.RecieveDataPacket(socket);
            System.out.println("DATA PACKET RECIEVED");
        } catch (IOException ex) {
            Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            System.out.println("SwitchStatement");
            System.out.println(inputData.getCommand());
            switch (inputCommand) {
                case "EXT"://Logout
                    System.out.println("EXT Switch hit");
                    openConnection = false;
                    Server.currentUsers--;
                    break OpenConnectionLoop;
                case "REG"://Register User
                    System.out.println("REG Switch hit");
                    Server.currentUsers++;
                    UserData registerUserData = null;
                    try {
                        registerUserData = NetworkInterfaces.RecieveUserData(socket);
                        System.out.println("USERDATA PACKET RECIEVED");
                    } catch (IOException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        ControlHandler.RegisterUser(registerUserData);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(ClientNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(registerUserData.firstName);
                    System.out.println("GOT USER DATA BREAK NEXT");
                    break OpenConnectionLoop;
                //Call relevant function
                case "LGN"://Login
                    LoginData loginData = null;
                    Server.currentUsers++;
                    NotificationPacket loginResponse = new NotificationPacket();
                    try {
                        loginData = NetworkInterfaces.RecieveLoginData(socket);
                        if (ControlHandler.Login(loginData)) {
                            loginResponse.setCommand("OKAY");
                            loginResponse.setNotification("Good Login");
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
                    //Call relevant function
                    break;
                case "FFR"://Friend Request Response
                    //Call relevant function
                    break;
                case "PST"://Push Posts to other clients
                    //Call relevant function
                    break;
                case "PYM"://Play music?
                    //Call relevant function
                    break;
                case "UPS"://Upload Song
                    System.out.println("UPS Switch hit");
                    break OpenConnectionLoop;
                //Call relevant function
                case "RSL"://Request song list
                    //Call relevant function
                    break;
                case "UMP"://Update the Main Page
                    System.out.println("UMP Switch hit");

                    //Call relevant function
                    break;
                case "SCT"://Start chat
                    //Call relevant function
                    break;
                default:
                    break OpenConnectionLoop;
            }
        }
        System.out.println("End of Thread");
    }
}
