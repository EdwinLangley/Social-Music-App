/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.sound.sampled.*;

/**
 *
 * @author jcgri
 */
public class SongData extends UserData {

    public int ID;
    public String songName;
    public String artist;
    public String album;
    public ArrayList<String> genre;
    private AudioFormat extension;
    public long songLength;
    private byte[] song;

    public SongData(int ID, String songName, String artist, String album, ArrayList<String> genre, File albumArt, File song) throws UnsupportedAudioFileException, IOException {
        this.ID = ID;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        AudioFileFormat aff=AudioSystem.getAudioFileFormat(song);
        this.extension = aff.getFormat();
        this.songLength = aff.getFrameLength();
        this.image = buildByteArray(albumArt);
        this.song = buildByteArray(song);
    }
    
    public AudioInputStream buildSong() throws IOException{
        InputStream bais=new ByteArrayInputStream(this.song);
        AudioInputStream returnSong= new AudioInputStream(bais,this.extension,this.songLength);
        return returnSong;
    }

}
