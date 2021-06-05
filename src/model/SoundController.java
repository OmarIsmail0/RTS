package model;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundController {
    private static Clip openDoorSound;
    private static Clip waitingMusic;
    private static Clip emergencyStopSound;
    
    public void playDoorSound() {
        if (openDoorSound != null)
            return;
        
        try {
            URL loc = getClass().getResource("../sounds/OpenDoor.wav");
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
           // waitingMusic.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void playEmergencySound() {
        if (emergencyStopSound != null)
            return;
        
        try {
            URL loc = getClass().getResource("../sounds/EmergencyAlarm.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(loc);
            emergencyStopSound = AudioSystem.getClip();
            emergencyStopSound.open(audioInputStream);
            emergencyStopSound.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }
    }
}
