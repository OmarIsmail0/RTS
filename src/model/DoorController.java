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
    
    

    public DoorController(ElevatorController elevator) {
        this.isOpen = true;
        this.elevator = elevator;
    }
    
    
    public void changeDoorStatus(boolean doorStatus){
        this.isOpen = doorStatus;
        if (doorStatus == true){
            elevator.getGUI().getLightPanel().setBackground(Color.GREEN);
            elevator.getGUI().getDoorStatus().setText("Open");
            //elevator.getController().getAudioController().playOpenDoor();
        }
        else {
            elevator.getGUI().getLightPanel().setBackground(Color.RED);
            elevator.getGUI().getDoorStatus().setText("Closed");
        }
        
        
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    

public class DoorController {
    private boolean isOpen;
    private Elevator elevator;

    public DoorController(boolean isOpen, Elevator elevator) {
        this.isOpen = isOpen;
        this.elevator = elevator;
    }


    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setElevator() {
        if(this.isOpen == false){
            
        }
    }


    
    
    
}
