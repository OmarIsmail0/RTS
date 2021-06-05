package esper;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.ElevatorCar;
import model.ElevatorRequest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args) {

        Logger.getRootLogger().setLevel(Level.OFF);
        Config.registerEvents();

        final ElevatorCar elevator = new ElevatorCar();
        
        Config.createStatement("select isEmergencyPressed from PressEmergencyStopEvent")
                .setSubscriber(new Object() {
                    public void update(boolean isEmergencyPressed) throws InterruptedException {
                        elevator.setEmergencyTrigger(isEmergencyPressed);
                        if (isEmergencyPressed) {
                            elevator.StartAlarm();
                        }
                    }
                });

        Config.createStatement("select doorOpen from DoorSensorReading")
                .setSubscriber(new Object() {
                    public void update(boolean doorOpen) throws InterruptedException {
                        elevator.getDoorCtrl().changeDoorStatus(doorOpen);
                        if (doorOpen == true) {
                            elevator.manageDoor("Open");
                            elevator.getCtrl().getSound().playOpenDoorSound();
                        } else {
                            elevator.manageDoor("Closed");
                        }
                    }
                });

        Config.createStatement("select destinationFloor, type from ChooseFloorEvent")
                .setSubscriber(new Object() {
                    public void update(int destinationFloor, String type) throws InterruptedException {
                        JButton clickedBtn = null;
                        String str = "";
                        JPanel panel;
                        if (type.equals("CallElevatorBtn")) {
                            str = type + destinationFloor;
                            panel = elevator.getGui().getCallPanl();
                        } else {
                            str = type + destinationFloor + "btn";
                            panel = elevator.getGui().getElevatorControllerPanel();
                        }

                        for (Component c : panel.getComponents()) {
                            try {
                                if (c instanceof JButton) {
                                    if (str.equals(c.getName())) {
                                        clickedBtn = (JButton) c; //Converting Component to JButton
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Button Not Found!");
                            }
                        }

                        if (elevator.getCurrentFloor() != destinationFloor) {
                            clickedBtn.setBackground(Color.GREEN);
                            elevator.CreateRequest(destinationFloor, clickedBtn);
                        }
                        else{
                            
                        }
                    }
                });

        Config.createStatement("select isMoving, YAxisPoint, currentFloor from ElevatorStateReading")
                .setSubscriber(new Object() {
                    public void update(boolean isMoving, int YAxisPoint, int currentFloor) throws InterruptedException {
                        elevator.setMoving(isMoving);
                        elevator.setElevatorPositionY(YAxisPoint);
                        elevator.setCurrentFloor(currentFloor);
                        if (!isMoving) {
                            elevator.getGui().getDoorBtn().setEnabled(true);
                        }

                    }
                });

        Config.createStatement("select weight from WeightSensorReading")
                .setSubscriber(new Object() {
                    public void update(int weight) throws InterruptedException {
                        System.out.println(weight);
                        if (weight <= 300 && weight > 30) {
                            elevator.getGui().getCallElevatorBtn1().setEnabled(true);
                            elevator.getGui().getCallElevatorBtn2().setEnabled(true);
                            elevator.getGui().getCallElevatorBtn3().setEnabled(true);
                            elevator.getGui().getFloor1btn().setEnabled(true);
                            elevator.getGui().getFloor2btn().setEnabled(true);
                            elevator.getGui().getFloor3btn().setEnabled(true);
                        } else {
                            elevator.getGui().getCallElevatorBtn1().setEnabled(false);
                            elevator.getGui().getCallElevatorBtn2().setEnabled(false);
                            elevator.getGui().getCallElevatorBtn3().setEnabled(false);
                            elevator.getGui().getFloor1btn().setEnabled(false);
                            elevator.getGui().getFloor2btn().setEnabled(false);
                            elevator.getGui().getFloor3btn().setEnabled(false);
                            elevator.getGui().getEmergencyStopBtn().setEnabled(false);
                        }
                    }
                });

    }
}
