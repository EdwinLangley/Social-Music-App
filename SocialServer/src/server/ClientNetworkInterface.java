/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DataPacket.DataPacket;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joe
 */
public class ClientNetworkInterface extends ClientHandler implements Runnable {

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
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        while (openConnection) {

            try {
                //Client has to create this in the opposite order
                //output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (input.read() != -1) {
                    System.out.println("Getting Input");
                    try {
                        inputData = (DataPacket) input.readObject();
                    } catch (IOException i) {
                        i.printStackTrace();
                        return;
                    } catch (ClassNotFoundException c) {
                        System.out.println("Class not found");
                        c.printStackTrace();
                        return;
                    }
                    //Insert Control block here
                    //Case statements for each command
                    //new Control handler object that takes input Datapacket as a control sequence and then sends appropriate data back
                    //Also needs to switch so it then takes data input from client
                    switch (inputData.getCommand()) {
                        case "EXT":
                            //Call relevant function
                            break;
                        case "REG"://Register User
                            //Call relevant function
                            break;
                        case "LGN"://Login
                            //Call relevant function
                            break;
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
                            //Call relevant function
                            break;
                        case "RSL"://Request song list
                            //Call relevant function
                            break;
                        case "RPD"://Request profile data
                            //Call relevant function
                            break;
                        case "UFL"://Update Friends list
                            //Call relevant function
                            break;
                        case "UPL"://Update Post List
                            //Call relevant function
                            break;
                        case "SCT"://Start chat
                            //Call relevant function
                            break;
                        default:

                    }

                }
            } catch (IOException i) {
                i.printStackTrace();
                return;
            }

            //Code to handle network output here
//            if ("EXT".equals(outputData.getCommand())) {
//                System.out.println("Close Connection");
//                break;
//            }
//
//            //Output data whatever it is
//            if (!"null".equals(outputData.getCommand())) {
//                try {
//                    System.out.println("OutputData");
//                    output.writeObject(outputData);
//                    output.flush();
//                } catch (IOException i) {
//                    i.printStackTrace();
//                    return;
//                }
//            }
            //output.close();
            System.out.println("OutputClosed");
        }

        Server.currentUsers--;
    }
}
