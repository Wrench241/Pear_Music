package controller;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TimerTask;

import com.bumptech.glide.load.engine.Initializable;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    
    public void play() {

        mediaPlayer.play();
    }

    public void pause() {

        mediaPlayer.stop();
        mediaPlayer.stop();
    }

    public void nextSound() {

        if (soundNumber < soungs.size() - 1) {
            soundNumber++;
            mediaPlayer.stop();
            midia = new Media(soungs.get(soundNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(midia);
            
            play();
        } else {
             soundNumber= 0;
            mediaPlayer.stop();
            midia = new Media(soungs.get(soundNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(midia);
            m.next.setText(soungs.get(soundNumber).getName());
            play();
        }
    }

    public void previousSound() {

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
