/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import static DataPacket.UserData.buildByteArray;
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
    public String genre;
    private File songFile;
    public long songLength;
    public byte[] song;
    public String userName;

    public SongData() {
    }

    public SongData(int ID, String songName, String artist, String album, String genre, long songLength) {
        this.ID = ID;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.songLength = songLength;
    }

    public SongData(int ID, String songName, String artist, String album, String genre, String UserName,
            File albumArt, File song) throws UnsupportedAudioFileException, IOException {
        this.command = "SongData";
        this.ID = ID;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        AudioFileFormat aff = AudioSystem.getAudioFileFormat(song);
        this.songFile = song;
        this.songLength = aff.getFrameLength();
        this.image = buildByteArray(albumArt);
        this.song = buildByteArray(song);
        this.userName = UserName;
    }
    
    public SongData(int ID, String songName, String artist, String album, String genre, String UserName) throws UnsupportedAudioFileException, IOException {
        this.command = "SongData";
        this.ID = ID;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.userName = UserName;
    }

    public AudioInputStream buildSong() throws IOException, UnsupportedAudioFileException {
        InputStream bais = new ByteArrayInputStream(this.song);
        AudioInputStream returnSong = new AudioInputStream(bais, getFormat(), this.songLength);
        return returnSong;
    }

    public AudioFormat getFormat() throws UnsupportedAudioFileException, IOException {
        AudioFileFormat aff = AudioSystem.getAudioFileFormat(this.songFile);
        AudioFormat extension;
        extension = aff.getFormat();
        return extension;
    }

}