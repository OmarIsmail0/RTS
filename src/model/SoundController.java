package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SoundController implements LineListener{

    private static Clip openDoorSound;
    private static Clip waitingMusic;
    private static Clip emergencyStopSound;
     boolean playCompleted;

    public SoundController() {
    }
    
    
    /*
    public void playDoorSound() {
        if (openDoorSound != null)
            return;
        
        try {
            URL loc = getClass().getResource("../view/sounds/Emergency.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(loc);
            openDoorSound = AudioSystem.getClip();
            openDoorSound.open(audioInputStream);
            openDoorSound.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void playWaitingMusic() {
        if (waitingMusic != null)
            return;
        
        try {
            URL loc = getClass().getResource("../sounds/ElevatorMusic.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(loc);
            waitingMusic = AudioSystem.getClip();
            waitingMusic.open(audioInputStream);
            waitingMusic.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void playEmergencySound() {
        System.out.print("1");
        if (emergencyStopSound != null){
        System.out.print("2");
            return;
        }
        System.out.print("3");
        try {
            System.out.print("4");
            URL loc = getClass().getResource("../view/sounds/Emergency.wav");
            System.out.print("5");
            AudioInputStream AOC = AudioSystem.getAudioInputStream(loc);
            System.out.print("6");
            emergencyStopSound = AudioSystem.getClip();
            System.out.print("7");
            emergencyStopSound.open(AOC);
            System.out.print("8");
            emergencyStopSound.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("9");
    }*/
    
    void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
 
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
 
            AudioFormat format = audioStream.getFormat();
 
            DataLine.Info info = new DataLine.Info(Clip.class, format);
 
            Clip audioClip = (Clip) AudioSystem.getLine(info);
 
            audioClip.addLineListener(this);
 
            audioClip.open(audioStream);
             
            audioClip.start();
             
            while (!playCompleted) {
                // wait for the playback completes
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
             
            audioClip.close();
             
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
         
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
 
    }
    
    
}