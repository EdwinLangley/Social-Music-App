package musicsocial;

import DataPacket.DataPacket;
import DataPacket.MainPageData;
import DataPacket.NetworkInterfaces;
import DataPacket.PostData;
import DataPacket.SongData;
import DataPacket.UserData;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edwin
 */
public class MusicSocialUI extends javax.swing.JFrame {

    boolean isPlaying = false;
    AudioInputStream audioInputStream;
    Clip clip;
    int clipTime;
    String currentUser = "";
    JScrollPane scrollPane;
    MainPageData mpd;
    DefaultListModel friendsModel = new DefaultListModel();
    DefaultListModel allModel = new DefaultListModel();
    DefaultListModel allFriendsPostsModel = new DefaultListModel();
    DefaultListModel allMySongsModel = new DefaultListModel();
    DefaultTableModel allMySongsTableModel;
    DefaultTableModel allNetworkSongsTableModel;

    /**
     * Creates new form MusicSocialUI
     */
    public MusicSocialUI() {
        
        initComponents();   
        initListeners();
                    
        setAlbumArt();
        
        
        getAllPosts();
    }

    public MusicSocialUI(String username) throws IOException {
        initComponents();   
        initListeners();
        currentUser = username;
        
        WelcomeLabel.setText("Welcome to MusicSocial " + username + "!");
        allMySongsTableModel = (DefaultTableModel) YourQueueTable.getModel();
        allNetworkSongsTableModel = (DefaultTableModel) InYourNetworkTable.getModel();
        setAlbumArt();
        
        getMainPageData();
        
        // you want to put any updates here because above this point the main page data will not exist yet
        
        setFriends();
        
        //getAllPosts();

    }
    
    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SecondSep = new javax.swing.JSeparator();
        FirstSep = new javax.swing.JSeparator();
        Play = new javax.swing.JLabel();
        Skip = new javax.swing.JLabel();
        Previous = new javax.swing.JLabel();
        Repeat = new javax.swing.JLabel();
        Mute = new javax.swing.JLabel();
        AlbumArt = new javax.swing.JLabel();
        ProgressSlider = new javax.swing.JSlider();
        TitleFriendsPost = new javax.swing.JLabel();
        TimePlayed = new javax.swing.JLabel();
        TimeToGo = new javax.swing.JLabel();
        TitleRecommendation = new javax.swing.JLabel();
        AddFriendsLabel = new javax.swing.JLabel();
        TitleInYourNetwork = new javax.swing.JLabel();
        addSongButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PostField = new javax.swing.JTextArea();
        MoodDropDown = new javax.swing.JComboBox<>();
        AttatchedSong = new javax.swing.JComboBox<>();
        MoodLabel = new javax.swing.JLabel();
        AttatchedSongLabel = new javax.swing.JLabel();
        PostButton = new javax.swing.JButton();
        ChatButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PostsDisplay = new javax.swing.JList<>();
        WelcomeLabel = new javax.swing.JLabel();
        TitleFriends1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        YourFriendsList = new javax.swing.JList<>();
        AddFriendButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        AllUsersList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        YourQueueTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        InYourNetworkTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Music Social");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));

        SecondSep.setOrientation(javax.swing.SwingConstants.VERTICAL);

        FirstSep.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png"))); // NOI18N
        Play.setText("jLabel1");
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayMouseClicked(evt);
            }
        });

        Skip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        Skip.setText("jLabel2");

        Previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        Previous.setText("jLabel2");

        Repeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/repeat.png"))); // NOI18N
        Repeat.setText("jLabel3");

        Mute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mute.png"))); // NOI18N
        Mute.setText("jLabel4");

        AlbumArt.setText("jLabel6");

        TitleFriendsPost.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        TitleFriendsPost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleFriendsPost.setText("P O S T S");

        TimePlayed.setText("00:00");

        TimeToGo.setText("00:00");

        TitleRecommendation.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        TitleRecommendation.setText("Y O U R    Q U E U E");

        AddFriendsLabel.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        AddFriendsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AddFriendsLabel.setText("A D D    F R I E N D S  ");

        TitleInYourNetwork.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        TitleInYourNetwork.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleInYourNetwork.setText("I N   Y O U R   N E T W O R K");

        addSongButton.setText("Upload Song to Collection");
        addSongButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSongButtonMouseClicked(evt);
            }
        });
        addSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSongButtonActionPerformed(evt);
            }
        });

        PostField.setColumns(20);
        PostField.setRows(5);
        jScrollPane1.setViewportView(PostField);

        MoodDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Happy", "Sad", "Nostalgic", "Confused", "Angry", "Excited" }));

        AttatchedSong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        MoodLabel.setText("Mood");

        AttatchedSongLabel.setText("Attatched Song");

        PostButton.setText("POST");
        PostButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PostButtonMouseClicked(evt);
            }
        });

        ChatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chat.png"))); // NOI18N
        ChatButton.setText(" Chat With Friends!");
        ChatButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChatButtonMouseClicked(evt);
            }
        });
        ChatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChatButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        PostsDisplay.setPreferredSize(null);
        jScrollPane2.setViewportView(PostsDisplay);

        WelcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        WelcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel.setText("welcome");

        TitleFriends1.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        TitleFriends1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleFriends1.setText("Y O U R    F R I E N D S");

        jScrollPane5.setViewportView(YourFriendsList);

        AddFriendButton.setText("ADD");

        jScrollPane6.setViewportView(AllUsersList);

        YourQueueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Song", "Artist", "Genres", "Belongs To User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(YourQueueTable);

        InYourNetworkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Song", "Artist", "Genres", "Belongs To User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(InYourNetworkTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddFriendsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(AddFriendButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(ChatButton)))
                .addGap(18, 18, 18)
                .addComponent(FirstSep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(TitleInYourNetwork))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TitleFriendsPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MoodLabel)
                                .addGap(18, 18, 18)
                                .addComponent(MoodDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AttatchedSongLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AttatchedSong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(SecondSep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TitleRecommendation)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addSongButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Mute, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Skip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(Repeat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(AlbumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(TimePlayed)
                        .addGap(18, 18, 18)
                        .addComponent(ProgressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TimeToGo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TitleFriends1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1368, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SecondSep)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleFriendsPost, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MoodLabel)
                            .addComponent(MoodDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AttatchedSongLabel)
                            .addComponent(AttatchedSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PostButton))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TitleInYourNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(AlbumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProgressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TimePlayed)
                                    .addComponent(TimeToGo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Skip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Repeat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mute, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(WelcomeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AddFriendsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addSongButton)
                                .addGap(18, 18, 18)
                                .addComponent(TitleRecommendation, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AddFriendButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ChatButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(FirstSep, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(TitleFriends1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(655, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initListeners(){
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                DataPacket extPacket = new DataPacket("EXT", currentUser);
                System.exit(0);
            }
        
        });
        
    }
    
    private void setFriends() throws IOException { 
    
        ArrayList<UserData> friends = mpd.allFriends;
        
        for(int i = 0; i < friends.size(); i++){
            UserData friend = friends.get(i);
            String friendUserName = friend.username;
            friendsModel.addElement(friendUserName);
        }
        
        YourFriendsList.setModel(friendsModel);
        
        
        ArrayList<UserData> all = mpd.allUsers;
        
        for(int i = 0; i < all.size(); i++){
            UserData single = all.get(i);
            String singleUserName = single.username;
            allModel.addElement(singleUserName);
        }
        
        AllUsersList.setModel(allModel);
        
        ArrayList<PostData> AllFriendsPostsArray = mpd.friendsPosts;
        
        for(int i = 0; i < AllFriendsPostsArray.size(); i++){
            PostData singlePost = AllFriendsPostsArray.get(i);
            String singlePostString = (singlePost.TimePostedString + "    " + singlePost.username + "  posted:  \"" + singlePost.postMessage + "\"" );
            
            allFriendsPostsModel.addElement(singlePostString);
        }
        
        PostsDisplay.setModel(allFriendsPostsModel);
        
        ArrayList<SongData> AllMySongsArray = mpd.yourQueue;
        
        for(int i = 0; i < AllMySongsArray.size(); i++){
            String genreOutputString = "";
            SongData mySingleSong = AllMySongsArray.get(i);
            for(int x = 0; x < mySingleSong.genre.size(); x++){
                genreOutputString += mySingleSong.genre.get(x)+",";
            }
            
            allMySongsTableModel.addRow(new Object[]{mySingleSong.ID,mySingleSong.songName,mySingleSong.artist, genreOutputString, mySingleSong.username});
        }
        
        TableColumnModel allMyQueueColumnModel = YourQueueTable.getColumnModel();
        allMyQueueColumnModel.getColumn(0).setPreferredWidth(10);
      
        YourQueueTable.setModel(allMySongsTableModel);
        
        ArrayList<SongData> inYourNetwoekQueue = mpd.inYourNetwork;
        
        for(int i = 0; i < inYourNetwoekQueue.size(); i++){
            String genreOutputString = "";
            SongData yourSingleSong = inYourNetwoekQueue.get(i);
            for(int x = 0; x < yourSingleSong.genre.size(); x++){
                genreOutputString += yourSingleSong.genre.get(x)+",";
            }
            
            allNetworkSongsTableModel.addRow(new Object[]{yourSingleSong.ID,yourSingleSong.songName,yourSingleSong.artist, genreOutputString, yourSingleSong.username});
        }
      
        TableColumnModel allNetworkSongsTableColumnModel = InYourNetworkTable.getColumnModel();
        allNetworkSongsTableColumnModel.getColumn(0).setPreferredWidth(10);
        
        InYourNetworkTable.setModel(allNetworkSongsTableModel);
        
        
            
    } 
    
    
    private void getMainPageData() throws IOException { 
        
        DataPacket MainPagePacket = new DataPacket("UMP", currentUser);
        
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket socket = null;
        
        try {
          
        socket = new Socket(address, 9090);    
        
        NetworkInterfaces.SendDataPacket(socket, MainPagePacket);
        mpd = NetworkInterfaces.RecieveMainPageData(socket);
        
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hi");
    } 
    
    private void PlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMouseClicked
        String trackName = "D:\\Users\\Edwin\\Music\\marbles-daniel_simon.wav";

        try {
            if (isPlaying == false) {

                audioInputStream = AudioSystem.getAudioInputStream(new File(trackName).getAbsoluteFile());
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                if (clipTime < clip.getFrameLength()) {
                    clip.setFramePosition(clipTime);
                }
                clip.start();
                isPlaying = true;
            } else {

                clipTime = clip.getFramePosition();
                clip.stop();
                isPlaying = false;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_PlayMouseClicked

    private void addSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSongButtonActionPerformed

    private void addSongButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSongButtonMouseClicked
        new UploadSong().setVisible(true);
    }//GEN-LAST:event_addSongButtonMouseClicked

        private void setAlbumArt() { 
        //URL url = getClass().getResource("src/images/6027fe7edf669a864347e7b011d7c126.jpg");
        File file = new File("./src/images/6027fe7edf669a864347e7b011d7c126.jpg");
        System.out.println(file.getAbsolutePath());
        String filename = file.getAbsolutePath();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(AlbumArt.getWidth(), AlbumArt.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        AlbumArt.setIcon(icon);
   }                                          

    
    private void PostButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PostButtonMouseClicked
        String retrievedPostContent = PostField.getText();
        String retrievedMood = MoodDropDown.getSelectedItem().toString();
        String retrievedSong = AttatchedSong.getSelectedItem().toString();
        
        //PostData postData = new PostData(AttatchedSong, retrievedPostContent, retrievedMood);
        
        DataPacket PostDataPacket = new DataPacket("PST");
        //PostData PostContent = new PostData(0, retrievedSong, retrievedPostContent, retrievedMood);
        
        InetAddress address = null;
        
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Socket socket = null;
        try {
            socket = new Socket(address, 9090);
            //Send multiple bits of data over same socket connection should always be in pairs
            //First DataPacket preps server
            //Second sends data
            //Only close socket afterwards
            NetworkInterfaces.SendDataPacket(socket, PostDataPacket);
            //NetworkInterfaces.SendPostData(socket, postData);
        } catch (IOException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PostButtonMouseClicked

    private void ChatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChatButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChatButtonActionPerformed

    private void ChatButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatButtonMouseClicked
        new Messaging().setVisible(true);
    }//GEN-LAST:event_ChatButtonMouseClicked

    
    private void getAllPosts() {   
        
        DefaultListModel dlm = new DefaultListModel();
        for(int i = 0; i < 10; i++){
            dlm.addElement("06/03/2018 " + " 22:00:00 " + " Edwin: "  + " Feeling good listening to X Song " + "\n" );          
        }
        
        PostsDisplay.setModel(dlm);
    }  
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusicSocialUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicSocialUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicSocialUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicSocialUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicSocialUI().setVisible(true);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddFriendButton;
    private javax.swing.JLabel AddFriendsLabel;
    private javax.swing.JLabel AlbumArt;
    private javax.swing.JList<String> AllUsersList;
    private javax.swing.JComboBox<String> AttatchedSong;
    private javax.swing.JLabel AttatchedSongLabel;
    private javax.swing.JButton ChatButton;
    private javax.swing.JSeparator FirstSep;
    private javax.swing.JTable InYourNetworkTable;
    private javax.swing.JComboBox<String> MoodDropDown;
    private javax.swing.JLabel MoodLabel;
    private javax.swing.JLabel Mute;
    private javax.swing.JLabel Play;
    private javax.swing.JButton PostButton;
    private javax.swing.JTextArea PostField;
    private javax.swing.JList<String> PostsDisplay;
    private javax.swing.JLabel Previous;
    private javax.swing.JSlider ProgressSlider;
    private javax.swing.JLabel Repeat;
    private javax.swing.JSeparator SecondSep;
    private javax.swing.JLabel Skip;
    private javax.swing.JLabel TimePlayed;
    private javax.swing.JLabel TimeToGo;
    private javax.swing.JLabel TitleFriends1;
    private javax.swing.JLabel TitleFriendsPost;
    private javax.swing.JLabel TitleInYourNetwork;
    private javax.swing.JLabel TitleRecommendation;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JList<String> YourFriendsList;
    private javax.swing.JTable YourQueueTable;
    private javax.swing.JButton addSongButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
