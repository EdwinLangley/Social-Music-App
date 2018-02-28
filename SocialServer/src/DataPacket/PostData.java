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
public class PostData extends DataPacket{
    public int ID;
    public Date datePosted;
    public Time timePosted;
    public SongData attachedSong;
    public String postMessage;
    public String postMood;
    
    //Everything
    public PostData(int ID,Date datePosted,Time timePosted,SongData attachedSong,String postMessage,String postMood){
        this.ID=ID;
        this.datePosted=Date.valueOf(LocalDate.now());
        this.timePosted=Time.valueOf(LocalTime.now());
        this.attachedSong=attachedSong;
        this.postMessage=postMessage;
        this.postMood=postMood;
    }
    //No mood but song
    public PostData(int ID,Date datePosted,Time timePosted,SongData attachedSong,String postMessage){
        this.ID=ID;
        this.datePosted=Date.valueOf(LocalDate.now());
        this.timePosted=Time.valueOf(LocalTime.now());
        this.attachedSong=attachedSong;
        this.postMessage=postMessage;
    }
    //Mood but no song
    public PostData(int ID,Date datePosted,Time timePosted,String postMessage,String postMood){
        this.ID=ID;
        this.datePosted=Date.valueOf(LocalDate.now());
        this.timePosted=Time.valueOf(LocalTime.now());
        this.postMessage=postMessage;
        this.postMood=postMood;
    }
    //Just message
    public PostData(int ID,Date datePosted,Time timePosted,String postMessage){
        this.ID=ID;
        this.datePosted=Date.valueOf(LocalDate.now());
        this.timePosted=Time.valueOf(LocalTime.now());
        this.postMessage=postMessage;
    }
}
