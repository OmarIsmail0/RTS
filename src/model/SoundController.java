package model;

import java.io.File;

 

import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;


import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundController implements LineListener { 

    private  Clip openDoorSound;
    private static Clip waitingMusic;
    private static Clip emergencyStopSound;
    boolean playCompleted;

    
    public void playWaitingMusic() {
        if (waitingMusic != null)
            return;
        
        try {

            URL loc = getClass().getResource("../sounds/ElevatorMusic.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(loc);
            waitingMusic = AudioSystem.getClip();
            waitingMusic.open(audioInputStream);
            waitingMusic.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setWaitingMusic(Clip waitingMusic) {
        SoundController.waitingMusic = waitingMusic;
    }

    public static Clip getEmergencyStopSound() {
        return emergencyStopSound;
    }

    public void setOpenDoorSound(Clip openDoorSound) {
        this.openDoorSound = openDoorSound;
    }

    public void playOpenDoorSound() {
        if (openDoorSound != null){

            return;
        }

        try {

            URL loc = getClass().getResource("../sounds/OpenDoor.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(loc);
            openDoorSound = AudioSystem.getClip();
            openDoorSound.open(audioInputStream);
            openDoorSound.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  Clip getOpenDoorSound() {
        return openDoorSound;
    }

    public void playEmergencySound() {
        if (emergencyStopSound != null){
            return;
        }

        try {

            URL loc = getClass().getResource("../sounds/EmergencyAlarm.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(loc);
            emergencyStopSound = AudioSystem.getClip();
            emergencyStopSound.open(audioInputStream);
            emergencyStopSound.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Clip getWaitingMusic() {
        return waitingMusic;
    }

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
                    Thread.sleep(500);
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