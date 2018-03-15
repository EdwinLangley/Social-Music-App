/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.io.Serializable;

/**
 *
 * @author jcgri
 */
public class ChatData implements Serializable {

    public String sendingUser, recievingUser, mesageContent, extension;
    public int songID;
    public byte[] image;
    
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
