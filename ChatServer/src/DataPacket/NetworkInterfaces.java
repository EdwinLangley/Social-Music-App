/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author jcgri
 *
 */
public class NetworkInterfaces {

    /**
     *
     * @param destination
     * @param outputObject
     * @throws IOException
     * 
     * Don't close any input or output, messes with flow
     * Socket will be closed at the end of the ClientNetworkInterface(Hopefully)
     * 
     */
    public static void SendChat(Socket socket, ChatMessages outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("SendChat");
        output.writeObject(outputObject);
        output.flush();
        System.out.println("OutputClosed");
    }

    public static ChatData RecieveChat(Socket socket) throws IOException {
        ObjectInputStream input = null;
        ChatData inputData = null;
        input = new ObjectInputStream(socket.getInputStream());
        System.out.println("Getting Input:RecieveChatt");
        try {
            inputData = (ChatData) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;
    }
    
    public static void SendDataPacket(Socket socket, DataPacket outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("SendDataPacket");
        System.out.println(outputObject.getCommand());
        output.writeObject(outputObject);
        output.flush();
        System.out.println("OutputClosed");
    }

    public static DataPacket RecieveDataPacket(Socket socket) throws IOException {
        ObjectInputStream input = null;
        DataPacket inputData = null;
        input = new ObjectInputStream(socket.getInputStream());
        System.out.println("Getting Input:RecieveDataPacket");
        try {
            inputData = (DataPacket) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;
    }
}