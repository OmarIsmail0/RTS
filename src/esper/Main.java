package esper;

import model.ElevatorController;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Main {
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);
        // Register events
        Config.registerEvents();
        
        //final EmergencyStopController elevator = new EmergencyStopController();
        final ElevatorController elev = new ElevatorController();
        
        Config.createStatement("select trigger_emergency from EmergencyStopEvent")
                .setSubscriber(new Object() {
                    public void update(boolean status) throws InterruptedException {
                        
                        elev.setEmergencyTrigger(status);
                        if (status){
                            elev.RunEmergency();
                        }
                    }
                });
        
        Config.createStatement("select doorstate from DoorEvent")
                
                .setSubscriber(new Object() {
                    public void update(boolean isOpen) throws InterruptedException {
                        elev.getDoorController().changeDoorStatus(isOpen);
                       // elev.getDoorController().setIsOpen(isopen);
                        if (isOpen == true)
                            elev.OpenDoor();
                        else
                            elev.CloseDoor();
                    }
                });

        
        
    }
}
