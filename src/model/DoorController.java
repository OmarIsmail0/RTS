/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Laptop Shop
 */
public class DoorController {
    private boolean isOpen;
    private final ElevatorController elevator;
    

    public DoorController(boolean isOpen, ElevatorController elevator) {
        this.isOpen = isOpen;
        this.elevator = elevator;
    }
    
    
    public void changeDoorStatus(boolean doorStatus){
        //System.out.println(doorStatus);
        this.isOpen = doorStatus;

        if (doorStatus == true){
            elevator.getGUI().getLightPanel().setBackground(Color.GREEN);
            elevator.getGUI().getDoorStatus().setText("Open");
            elevator.getGUI().getDoorBtn().setEnabled(false);

            elevator.getSound().playOpenDoorSound();
            try {
                Thread.sleep(150);
                elevator.getSound().setOpenDoorSound(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else {
            elevator.getGUI().getLightPanel().setBackground(Color.RED);
            elevator.getGUI().getDoorStatus().setText("Closed");
            elevator.getGUI().getDoorBtn().setEnabled(true);
        }
        
        
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    
    
}
