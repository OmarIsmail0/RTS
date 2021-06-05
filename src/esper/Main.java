package esper;

import event.CallElevatorEvent.MoveDirectionEnum;
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
        ElevatorTranslateThread elv = new ElevatorTranslateThread(elevator,new Request(1, new JButton() ) );
        System.out.println(elevator.getGui().getCarPnel().getLocation().y);

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

        Config.createStatement("select direction, isMoving, carPositionY, currentFloor from ElevatorStateReading")
                .setSubscriber(new Object() {
                    public void update(MoveDirectionEnum direction, boolean isMoving, int carPositionY, int currentFloor) throws InterruptedException {
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
