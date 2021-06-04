
package model;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmergencyStopController {

     private final ElevatorController elevator; 

    public EmergencyStopController(ElevatorController elevator) {
        this.elevator = elevator;
    }


    public void EmergencyCall() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++)
                {
                    System.out.println("Emergancy !");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EmergencyStopController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                   
                    //elevator.getDoor().setDoorState(true);
                    if (elevator.getGUI().getEmergencyStopBtn().getBackground() != Color.RED) {
                        elevator.getGUI().getEmergencyStopBtn().setBackground(Color.RED);
                        
                    } else {
                        elevator.getGUI().getEmergencyStopBtn().setBackground(Color.WHITE);
                        
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EmergencyStopController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
            }
        }).start();
    }

   
    

}
