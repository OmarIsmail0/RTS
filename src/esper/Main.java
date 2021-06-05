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

        Logger.getRootLogger().setLevel(Level.OFF);
        Config.registerEvents();

        //final EmergencyStopController elevator = new EmergencyStopController();
        final Elevator elevator = new Elevator();

        Config.createStatement("select trigger_emergency from EmergencyStopEvent")
                .setSubscriber(new Object() {
                    public void update(boolean status) throws InterruptedException {

                        elevator.setEmergencyTrigger(status);
                        if (status) {
                            elevator.RunEmergency();
                        }
                    }
                });

        Config.createStatement("select doorstate from DoorEvent")
                .setSubscriber(new Object() {
                    public void update(boolean isOpen) throws InterruptedException {
                        elevator.getDoorCtrl().changeDoorStatus(isOpen);
                        // elev.getDoorController().setIsOpen(isopen);
                        if (isOpen == true) {
                            elevator.OpenDoor();
                        } else {
                            elevator.CloseDoor();
                        }
                    }
                });

        Config.createStatement("select destinationFloor, type from ChooseFloorEvent")
                .setSubscriber(new Object() {
                    public void update(int destinationFloor, String type) throws InterruptedException {
                        JButton clickedBtn = null;
                        String btnName = "";
                        JPanel panel;
                        if (type.equals("CallElevatorBtn")) {
                            btnName = type + destinationFloor;
                            panel = elevator.getGui().getCallPanl();
                        } else {
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
                            elevator.AddRequest(new Request(destinationFloor, clickedBtn));
                        }
                    }
                });

        Config.createStatement("select isMoving, carPositionY, currentFloor from ElevatorStateReading")
                .setSubscriber(new Object() {
                    public void update(boolean isMoving, int carPositionY, int currentFloor) throws InterruptedException {
                        elevator.setMoving(isMoving);
                        elevator.setElevatorPositionY(carPositionY);
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
                        if (weight <= 300 && weight > 50) {
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
