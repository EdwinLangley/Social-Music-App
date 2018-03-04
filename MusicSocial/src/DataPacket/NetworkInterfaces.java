/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author jcgri
 *
 */
public class NetworkInterfaces {

    /**
     *
     * @param socket
     * @param outputObject
     * @throws IOException
     *
     * Don't close any input or output, messes with flow Socket will be closed
     * at the end of the ClientNetworkInterface(Hopefully)
     *
     */
    public static void SendDataPacket(Socket socket, DataPacket outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("OutputData");
        System.out.println(outputObject.getCommand());
        output.writeObject(outputObject);
        output.flush();
        System.out.println("OutputClosed");
    }

    public static DataPacket RecieveDataPacket(Socket socket) throws IOException {
        ObjectInputStream input = null;
        DataPacket inputData = null;
        input = new ObjectInputStream(socket.getInputStream());
        System.out.println("Getting Input:DataPacket");
        try {
            inputData = (DataPacket) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;
    }

    public static void SendLoginData(Socket socket, LoginData outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("OutputData");
        output.writeObject(outputObject);
        output.flush();
        output.close();
        System.out.println("OutputClosed");
    }

    public static LoginData RecieveLoginData(Socket socket) throws IOException {
        ObjectInputStream input = null;
        LoginData inputData = null;
        input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        System.out.println("Getting Input:LoginData");
        try {
            inputData = (LoginData) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;
    }

    public static void SendUserData(Socket socket, UserData outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("OutputData");
        output.writeObject(outputObject);
        output.flush();
        System.out.println("OutputClosed");
    }

    public static UserData RecieveUserData(Socket socket) throws IOException {
        ObjectInputStream input = null;
        UserData inputData = null;
        input = new ObjectInputStream(socket.getInputStream());
        System.out.println("Getting Input:UserData");
        try {
            inputData = (UserData) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;
    }

    public static void SendPostData(Socket socket, PostData outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("OutputData");
        output.writeObject(outputObject);
        output.flush();
        System.out.println("OutputClosed");
    }

    public static PostData RecievePostData(Socket socket) throws IOException {
        ObjectInputStream input = null;
        PostData inputData = null;
        input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        System.out.println("Getting Input:PostData");
        try {
            inputData = (PostData) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;
    }

    public static void SendSongData(Socket socket, SongData outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("OutputData");
        output.writeObject(outputObject);
        output.flush();
        System.out.println("OutputClosed");
    }

    public static SongData RecieveSongData(Socket socket) throws IOException {
        ObjectInputStream input = null;
        SongData inputData = null;
        input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        System.out.println("Getting Input:SongData");
        try {
            inputData = (SongData) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;

    }

    public void SendMainPageData(Socket socket, MainPageData outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("OutputData");
        output.writeObject(outputObject);
        output.flush();
        System.out.println("OutputClosed");
    }

    public static MainPageData RecieveMainPageData(Socket socket) throws IOException {
        ObjectInputStream input = null;
        MainPageData inputData = null;
        input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        System.out.println("Getting Input:MainPageData");
        try {
            inputData = (MainPageData) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;
    }

    public void SendNotificationPacket(Socket socket, NotificationPacket outputObject) throws IOException {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("OutputData");
        output.writeObject(outputObject);
        output.flush();
        System.out.println("OutputClosed");
    }

    public static NotificationPacket RecieveNotificationPacket(Socket socket) throws IOException {
        ObjectInputStream input = null;
        NotificationPacket inputData = null;
        input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        System.out.println("Getting Input:NotificationPacket");
        try {
            inputData = (NotificationPacket) input.readObject();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return inputData;
    }

}
