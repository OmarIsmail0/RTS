package esper;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Elevator;
import model.ElevatorController;
import model.Request;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Main {
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);
        // Register events
        Config.registerEvents();
        
        //final EmergencyStopController elevator = new EmergencyStopController();
        final Elevator elevator = new Elevator();
        //System.out.println(elevator.getGui().getCarPnel().getLocation().y);
        Config.createStatement("select trigger_emergency from EmergencyStopEvent")
                .setSubscriber(new Object() {
                    public void update(boolean status) throws InterruptedException {
                        
                        elevator.setEmergencyTrigger(status);
                        if (status){
                            elevator.RunEmergency();
                        }
                    }
                });
        
        Config.createStatement("select doorstate from DoorEvent")
                
                .setSubscriber(new Object() {
                    public void update(boolean isOpen) throws InterruptedException {
                        elevator.getDoorCtrl().changeDoorStatus(isOpen);
                       // elev.getDoorController().setIsOpen(isopen);
                        if (isOpen == true)
                            elevator.OpenDoor();
                        else
                            elevator.CloseDoor();
                    }
                });

        Config.createStatement("select destinationFloor, type from ChooseFloorEvent")
                .setSubscriber(new Object() {
                    public void update(int destinationFloor, String type) throws InterruptedException {
                        JButton clickedBtn = null;
                        String btnName = "";
                        JPanel panel;
                        if(type.equals("CallElevatorBtn")){
                            btnName = type + destinationFloor;
                            panel = elevator.getGui().getCallPanl();
                        }
                        else{
                            btnName = type + destinationFloor + "btn";
                            panel = elevator.getGui().getElevatorControllerPanel();
                        }

                        //Searching for the clicked button
                        for (Component c : panel.getComponents()) {
                            try {
                                if (c instanceof JButton) {
                                    if (c.getName().compareToIgnoreCase(btnName) == 0) {
                                        clickedBtn = (JButton) c;
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }

                        if (elevator.getCurrentFloor() != destinationFloor) {
                            clickedBtn.setBackground(Color.GREEN);
                            elevator.AddRequest(new Request(destinationFloor,clickedBtn));
                        }
                    }
                });
        Config.createStatement("select isMoving, carPositionY, currentFloor from ElevatorStateReading")
                .setSubscriber(new Object() {
                    public void update( boolean isMoving, int carPositionY, int currentFloor) throws InterruptedException {
                        elevator.setMoving(isMoving);
                        elevator.setElevatorPositionY(carPositionY);
                        elevator.setCurrentFloor(currentFloor);
                        if (!isMoving) {
                            elevator.getGui().getDoorBtn().setEnabled(true);
                        }

                    }
                });
        
    }
}
