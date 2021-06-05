package esper;

import event.CallElevatorEvent.MoveDirectionEnum;
import model.CarRequest;
import model.Elevator;
import model.ElevatorTranslateThread;
import model.Request;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);
        // Register events
        Config.registerEvents();
        //System.out.println(NativeDebug.getClass(args, args));
        // Create Elevator
        final Elevator elevator = new Elevator();

        //210, 330, 437
       /* Config.createStatement("select requestedFloor, direction from CallElevatorEvent")
                .setSubscriber(new Object() {
                    public void update(int floorNumber, MoveDirectionEnum direction) throws InterruptedException {
                        JButton clickedBtn = null;
                        String btnName;
                        
                        if (direction == MoveDirectionEnum.DOWNWARDS)
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
        */
        Config.createStatement("select destinationFloor from ChooseFloorEvent")
                .setSubscriber(new Object() {
                    public void update(int destinationFloor) throws InterruptedException {
                        JButton clickedBtn = null;
                        String btnName = "Floor" + destinationFloor + "btn";
                        //Searching for the clicked button
                        int i = 1;
                        for (Component c : elevator.getGui().getElevatorControllerPanel().getComponents()) {
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
                            clickedBtn.setBackground(Color.YELLOW);
                            elevator.AddRequest(new Request(destinationFloor, MoveDirectionEnum.DOWNWARDS, clickedBtn));
                        }
                    }
                });


        Config.createStatement("select requestedFloor, direction from CallElevatorEvent")
                .setSubscriber(new Object() {
                    public void update(int floorNum, MoveDirectionEnum direction) throws InterruptedException {

                        JButton callBtn = null;
                        String btnName = "CallElevatorBtn";
                        btnName += floorNum;

                        for (Component c : elevator.getGui().getCallPanl().getComponents()) {
                            if (c instanceof JButton) {
                                if (c.getName().compareToIgnoreCase(btnName) == 0) {
                                    callBtn = (JButton) c;
                                }
                            }
                        }
                        if (elevator.getCurrentFloor() != floorNum) {
                            callBtn.setBackground(Color.YELLOW);
                            elevator.AddRequest(new CarRequest(floorNum, callBtn, direction));
                        }
                    }
                });

        Config.createStatement("select direction, isMoving, carPositionY, currentFloor from ElevatorStateReading")
                .setSubscriber(new Object() {
                    public void update(MoveDirectionEnum direction, boolean isMoving, int carPositionY, int currentFloor) throws InterruptedException {
                        System.out.println("in");
                        elevator.setDirection(direction);
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
