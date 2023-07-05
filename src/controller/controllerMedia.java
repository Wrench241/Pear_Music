package controller;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TimerTask;

import com.bumptech.glide.load.engine.Initializable;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import screens.MainScreen;

public class controllerMedia implements Initializable {

    private Media midia;

    private MediaPlayer mediaPlayer;

    private File diretctoryFile;

    private File[] files;

    private ArrayList<File> soungs;

    private int soundNumber;

    private Time timer;

    private TimerTask task;

    private boolean running;

    private javafx.util.Duration duration;

   

    MainScreen m = new MainScreen();
    @Override
    public void initialize() {

        soungs = new ArrayList<File>();
        diretctoryFile = new File("src/music");
        files = diretctoryFile.listFiles();

        if (files != null) {
            for (File file : files) {
                soungs.add(file);
                System.out.println(file);

            }
        }
        midia = new Media(soungs.get(soundNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(midia);

    }
    public static void revlist(ArrayList<File> list){
        ArrayList<File> result = new ArrayList<>();
        for (int i = list.size() + 1; i >=0; i--){
            result.add((File) list.get(i));
        }
    }
    
    public void play() {

       duration = mediaPlayer.getCurrentTime();
        mediaPlayer.seek(duration);
        mediaPlayer.play();
    
    }

    public void pause() {
        duration = mediaPlayer.getCurrentTime();
        mediaPlayer.seek(duration);
        mediaPlayer.stop();
        
    }
   

    public void nextSound() {

        if (soundNumber < soungs.size() - 1) {
            m.player.setText("pause");
            if (mediaPlayer.getStatus().equals(Status.PAUSED)){
                m.player.setText("play");

            }
            
            soundNumber++;
            mediaPlayer.stop();
            midia = new Media(soungs.get(soundNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(midia);
            
            play();
        } else {
            m.player.setText("play");
             soundNumber= 0;
            mediaPlayer.stop();
            midia = new Media(soungs.get(soundNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(midia);
            m.next.setText(soungs.get(soundNumber).getName());
            play();
        }
    }

    public void previousSound() {
        if (soundNumber < soungs.size() + 1) {
            soundNumber--;
            mediaPlayer.stop();
            midia = new Media(soungs.get(soundNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(midia);
            play();
        } else {
             soundNumber = 0;
            mediaPlayer.stop();
            midia = new Media(soungs.get(soundNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(midia);
            m.next.setText(soungs.get(soundNumber).getName());
            play();
        }
    }

    public void beginTimer() {

    }

    public ArrayList<File> getSoungs() {
        return soungs;
    }

    public int getSoundNumber() {
        return soundNumber;
    }

    
}
