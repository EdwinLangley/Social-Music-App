/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Chat.ChatServer;
import DataPacket.DataPacket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class ClientHandler {

    int ID;
    java.net.InetAddress IPAddress;
    DataPacket inputPacket, outputPacket;

    //Insert commmands here
    public void testFunction(String data) {
        DataPacket testpacket = new DataPacket();
//	testpacket.buildDataPacket("PCK",data,["hello","I'm an array"]); 
    }

    public void setUpClientInstance(java.net.Socket socket) {
        //this.ID = Server.currentUsers;
        this.IPAddress = socket.getInetAddress();
    }

    public void setInputPacket(DataPacket inputPacket) {
        this.inputPacket = inputPacket;
    }

    public DataPacket getOutputPacket() {
        return outputPacket;
    }

    //Insert commands here
    public DataPacket clientControlBlock(DataPacket dataPacket) {
        String command = dataPacket.getCommand();
        //System.out.println(command);
        //Case statements for each command
        switch (command) {
            case "EXT":
                outputPacket.setCommand("EXT");
                break;
            case "REG"://Register User
                System.out.println("REG Switch hit");
                outputPacket = RegisterUser(dataPacket);
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
            //outputPacket.buildDataPacket("null", "null", null);
        }
        return outputPacket;
    }

    private DataPacket RegisterUser(DataPacket inputData) {
        // System.out.println(inputData.getArray());
        DataPacket outputData = new DataPacket();
        ArrayList<String> emptyList = new ArrayList();
        //outputData.buildDataPacket("null", "null", emptyList);
        return outputData;
    }

    private DataPacket LoginUser(DataPacket inputData) {
        ArrayList<String> loginData = new ArrayList<>();
        //loginData=inputData.getArray();
        String username, password;
        username = loginData.get(0);
        password = loginData.get(1);
        //Add find username and password things here
        DataPacket returnData = new DataPacket();
        //returnData.buildDataPacket("GDL", "null", null);
        return returnData;
    }

    private void StartChat(DataPacket inputData) {
        boolean running = true;
        //int portNumber=Integer.parseInt(args[0]);
        int portNumber = 9091;
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (running) {
                //Do server stuff
                new Thread(new ChatServer(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            System.err.println("Error on port" + portNumber + e);
            System.exit(-1);
        }
    }
}
