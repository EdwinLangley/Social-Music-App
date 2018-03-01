/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.io.File;
import java.io.IOException;
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
    private AudioFileFormat extension;
    public int songLength;
    private byte[] song;

    public SongData(int ID, String songName, String artist, String album, ArrayList<String> genre, int songLength, File albumArt, File song) throws UnsupportedAudioFileException, IOException {
        this.ID = ID;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.extension = AudioSystem.getAudioFileFormat(song);
        this.songLength = songLength;
        this.image = buildByteArray(albumArt);
        this.song = buildByteArray(song);
    }
    
    public File buildSong() throws IOException{
        AudioInputStream returnSong(new ByteArrayInputStream(this.song),)
    }

}
