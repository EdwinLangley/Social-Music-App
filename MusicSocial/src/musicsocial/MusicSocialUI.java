package musicsocial;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

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

    /**
     * Creates new form MusicSocialUI
     */
    public MusicSocialUI() {
        initComponents();
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
        TitleFriends = new javax.swing.JLabel();
        TitleInYourNetwork = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        AlbumArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6027fe7edf669a864347e7b011d7c126.jpg"))); // NOI18N
        AlbumArt.setText("jLabel6");

        TitleFriendsPost.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 48)); // NOI18N
        TitleFriendsPost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleFriendsPost.setText("FRIENDS POSTS");

        TimePlayed.setText("00:00");

        TimeToGo.setText("00:00");

        TitleRecommendation.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 48)); // NOI18N
        TitleRecommendation.setText("YOUR QUEUE");

        TitleFriends.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 48)); // NOI18N
        TitleFriends.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleFriends.setText("FRIENDS");

        TitleInYourNetwork.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 48)); // NOI18N
        TitleInYourNetwork.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleInYourNetwork.setText("IN YOUR NETWORK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(TitleFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, Short.MAX_VALUE)
                .addComponent(FirstSep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TitleInYourNetwork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleFriendsPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(SecondSep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(TimePlayed)
                                .addGap(18, 18, 18)
                                .addComponent(ProgressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TimeToGo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(Mute, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Skip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Repeat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(AlbumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TitleRecommendation, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FirstSep)
            .addComponent(SecondSep)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleFriendsPost, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                .addComponent(TitleInYourNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
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
                            .addComponent(Mute, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TitleFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(TitleRecommendation, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 257, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel AlbumArt;
    private javax.swing.JSeparator FirstSep;
    private javax.swing.JLabel Mute;
    private javax.swing.JLabel Play;
    private javax.swing.JLabel Previous;
    private javax.swing.JSlider ProgressSlider;
    private javax.swing.JLabel Repeat;
    private javax.swing.JSeparator SecondSep;
    private javax.swing.JLabel Skip;
    private javax.swing.JLabel TimePlayed;
    private javax.swing.JLabel TimeToGo;
    private javax.swing.JLabel TitleFriends;
    private javax.swing.JLabel TitleFriendsPost;
    private javax.swing.JLabel TitleInYourNetwork;
    private javax.swing.JLabel TitleRecommendation;
    // End of variables declaration//GEN-END:variables
}
