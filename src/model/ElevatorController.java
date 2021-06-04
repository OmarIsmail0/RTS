/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import view.ElevatorUI;

import esper.Config;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author Laptop Shop
 */
public class ElevatorController {
    // The Elevator GUI
    private final ElevatorUI gui;
    private final DoorController doorc;
    
    // Elevator Components
    
    // Elevators StatusW
    private boolean emergencyTrigger;
    //private boolean isOpen;
    
    public ElevatorController() {
        this.gui = new ElevatorUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        this.doorc = new DoorController(this);
        // Initialize Elevator Status
    }
    
    public void OpenDoor(){
        this.doorc.changeDoorStatus(true);
    }
    
    public void CloseDoor(){
        this.doorc.changeDoorStatus(false);
    }
    
    
    public void RunEmergency(){
       this.gui.getEmergencyStopBtn().setEnabled(false);
       this.gui.getElevatorPanel().setEnabled(false);
       this.gui.getElevPanel().setEnabled(false);
        for (Component c : this.getGUI().getElevatorPanel().getComponents()) {
            if (c instanceof JButton) {
                c.setEnabled(false);
                c.setBackground(java.awt.Color.RED);
                //System.out.print("Emergency disabled");
            }
        }
        for (Component c : this.getGUI().getElevPanel().getComponents()) {
            if (c instanceof JButton) {
                c.setEnabled(false);
                c.setBackground(java.awt.Color.RED);
                //System.out.print("Emergency disabled");
            }
       
    }
    }
    
    public DoorController getDoorController(){
        return doorc;
    }
    

    public ElevatorUI getGUI() {
        return gui;
    }


    public boolean isEmergencyTrigger() {
        return emergencyTrigger;
    }
    
    
  public void setEmergencyTrigger(boolean emergencyTrigger) {
        this.emergencyTrigger = emergencyTrigger;
    }
    
    
    
    
}

