package model;

import java.io.File;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundController {

    private Clip openDoorSound, errorSound;
    private static Clip waitingMusic;
    private static Clip emergencyStopSound;
    
    public static void setWaitingMusic(Clip waitingMusic) {
        SoundController.waitingMusic = waitingMusic;
    }

    public static Clip getEmergencyStopSound() {
        return emergencyStopSound;
    }

    public void setOpenDoorSound(Clip openDoorSound) {
        this.openDoorSound = openDoorSound;
    }

    public Clip getOpenDoorSound() {
        return openDoorSound;
    }

    public static Clip getWaitingMusic() {
        return waitingMusic;
    }

    public void playWaitingMusic() {
        if (waitingMusic != null) {
            return;
        }
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

    public void playOpenDoorSound() {
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
    
    public void playErrorSound() {
        try {
            URL loc = getClass().getResource("../sounds/Error.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(loc);
            errorSound = AudioSystem.getClip();
            errorSound.open(audioInputStream);
            errorSound.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void playEmergencySound() {
        if (emergencyStopSound != null) {
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

    

}
