/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author jcgri
 */
public class UserData extends LoginData {

    public int userID;
    public String firstName, lastName, email;
    public ArrayList<String> genreList;
    public ArrayList<SongData> songList;
    public ArrayList<PostData> postIDs;
    public ArrayList<String> friendsList;
    public byte[] image;
    public boolean isOnline;

    public UserData() {
    }

    public UserData(int userID, String username, String password, String firstName, String lastName,
            String email, ArrayList<String> genreList, ArrayList<SongData> songList, ArrayList<PostData> postIDs,
            File profilePicture, ArrayList<String> friendsList, boolean isOnline) {
        this.Command = "UserData";
        this.userID = userID;
        this.username = username;
        this.passsword = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.genreList = genreList;
        this.songList = songList;
        this.postIDs = postIDs;
        this.friendsList = friendsList;
        this.image = buildByteArray(profilePicture);
        this.isOnline = isOnline;
    }

    public UserData(int userID, String username, String password, String firstName, String lastName, String email, ArrayList<String> genreList) {
        this.Command = "UserData";
        this.userID = userID;
        this.username=username;
        this.passsword=password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.genreList = genreList;
    }

    public static byte[] buildByteArray(File inputFile) {
        ByteArrayOutputStream baos = null;
        try {
            FileInputStream inputImageStream = new FileInputStream(inputFile);
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int len; (len = inputImageStream.read(buffer)) != -1;) {
                baos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        //this.image = baos != null ? baos.toByteArray() : null;
        return baos != null ? baos.toByteArray() : null;
    }

    public BufferedImage buildImage() throws IOException {
        BufferedImage returnImage = ImageIO.read(new ByteArrayInputStream(this.image));
        return returnImage;
    }

}
