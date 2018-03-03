/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DataPacket.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author jcgri
 * @param <t1>
 */
public class NetworkInterfaces<t1> {

    public void SendData(Socket socket, t1 outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("OutputData");
        output.writeObject(outputObject);
        output.flush();
        output.close();
        System.out.println("OutputClosed");
    }

    public t1 RecieveData(Socket socket) throws IOException {
        ObjectInputStream input = null;
        t1 inputData = null;
        input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        if (input.read() != -1) {
            System.out.println("Getting Input");
            try {
                inputData = (t1) input.readObject();
            } catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
            return inputData;
        }
        return inputData;
    }
}