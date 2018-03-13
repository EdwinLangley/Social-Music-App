/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author jcgri
 */
public class ChatData implements Serializable {

    private String sendingUser, recievingUser, mesageContent, extension;
    private int songID;
    private byte[] image;
    
    //Sending a song and message
    public ChatData(String sendingUser, String recievingUser, String mesageContent, String extension, int songID) {
        this.sendingUser = sendingUser;
        this.recievingUser = recievingUser;
        this.mesageContent = mesageContent;
        this.extension = extension;
        this.songID = songID;
    }
    
    //Sending a picture and message
    public ChatData(String sendingUser, String recievingUser, String mesageContent, String extension, byte[] image) {
        this.sendingUser = sendingUser;
        this.recievingUser = recievingUser;
        this.mesageContent = mesageContent;
        this.extension = extension;
        this.image = image;
    }
    
    //Sending just a message
    public ChatData(String sendingUser, String recievingUser, String mesageContent) {
        this.sendingUser = sendingUser;
        this.recievingUser = recievingUser;
        this.mesageContent = mesageContent;
    }

    public ChatData() {
    }

}
