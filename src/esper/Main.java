package esper;

import event.CallElevatorEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import jdk.nashorn.internal.objects.NativeDebug;
import model.Elevator;
import model.MoveDirectionEnum;
import model.Request;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Main {
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);
        // Register events
        Config.registerEvents();

        System.out.println(NativeDebug.getClass(args, args));
        // Create Elevator
        final Elevator elevator = new Elevator();
        
        Config.createStatement("select requestedFloor, direction from CallElevatorEvent")
                .setSubscriber(new Object() {
                    public void update(int floorNumber, CallElevatorEvent.MoveDirectionEnum direction) throws InterruptedException {
                        JButton clickedBtn = null;
                        String btnName;
                        
                        if (direction == CallElevatorEvent.MoveDirectionEnum.DOWNWARDS)
                            btnName = "D";
                        else
                            btnName = "U";
                        
                        btnName += floorNumber;
                        
                        //Searching for the clicked button
                        for (Component c : elevator.getGui().getElevPanel().getComponents()){
                            if (c instanceof JButton){
                                if (((JButton)c).getName().compareToIgnoreCase(btnName) == 0){
                                    clickedBtn = (JButton)c;
                                }
                            }
                        }
                        
                        if (elevator.getCurrentFloor() != floorNumber){
                            clickedBtn.setBackground(Color.YELLOW);
                            //elevator.AddRequest(new Request(floorNumber, direction, clickedBtn));
                        }
                    }
                });
        
        Config.createStatement("select floorNumber from RequestFloorEvent")
                .setSubscriber(new Object() {
                    public void update(int floorNumber) throws InterruptedException {
                        JButton clickedBtn = null;
                        String btnName = "B" + floorNumber;
                        
                        //Searching for the clicked button
                        for (Component c : elevator.getGUI().getButtonsPanel().getComponents()){
                            if (c instanceof JButton){
                                if (((JButton)c).getName().compareToIgnoreCase(btnName) == 0){
                                    clickedBtn = (JButton)c;
                                    break;
                                }
                            }
                        }
                        
                        if (elevator.getCurrentFloor() != floorNumber){
                            clickedBtn.setBackground(Color.YELLOW);
                            elevator.AddRequest(new Request(floorNumber, clickedBtn));
                        }
                    }
                });
        
    }
}
