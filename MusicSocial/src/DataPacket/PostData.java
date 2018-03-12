/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author jcgri
 */
public class PostData extends DataPacket {

    public int ID;
    public Date datePosted;
    public Time timePosted;
    public String TimePostedString;
    public int attachedSong;
    public String postMessage;
    public String postMood;
    public String username;

    public PostData() {
    }

    //Everything
    public PostData(int ID, Date datePosted, Time timePosted, int attachedSong, String postMessage, String postMood) {
        this.command = "PostData";
        this.ID = ID;
        this.datePosted = Date.valueOf(LocalDate.now());
        this.timePosted = Time.valueOf(LocalTime.now());
        this.attachedSong = attachedSong;
        this.postMessage = postMessage;
        this.postMood = postMood;
    }
    
    public PostData(int ID, String UserName,String timePosted, int attachedSong, String postMessage, String postMood) {
        this.command = "PostData";
        this.ID = ID;
        this.username = UserName;
        this.TimePostedString = timePosted;
        this.attachedSong = attachedSong;
        this.postMessage = postMessage;
        this.postMood = postMood;
    }
    
    public PostData(int ID, int attachedSong, String postMessage, String postMood, String UserName) {
        this.command = "PostData";
        this.ID = ID;
        this.attachedSong = attachedSong;
        this.postMessage = postMessage;
        this.postMood = postMood;
        this.username = UserName;
    }

    //No mood but song
    public PostData(int ID, Date datePosted, Time timePosted, int attachedSong, String postMessage) {
        this.command = "PostData";
        this.ID = ID;
        this.datePosted = Date.valueOf(LocalDate.now());
        this.timePosted = Time.valueOf(LocalTime.now());
        this.attachedSong = attachedSong;
        this.postMessage = postMessage;
    }

    //Mood but no song
    public PostData(int ID, Date datePosted, Time timePosted, String postMessage, String postMood) {
        this.command = "PostData";
        this.ID = ID;
        this.datePosted = Date.valueOf(LocalDate.now());
        this.timePosted = Time.valueOf(LocalTime.now());
        this.postMessage = postMessage;
        this.postMood = postMood;
    }

    //Just message
    public PostData(int ID, Date datePosted, Time timePosted, String postMessage) {
        this.command = "PostData";
        this.ID = ID;
        this.datePosted = Date.valueOf(LocalDate.now());
        this.timePosted = Time.valueOf(LocalTime.now());
        this.postMessage = postMessage;
    }

}
