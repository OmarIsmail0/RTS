package esper;

import model.ElevatorController;
import event.CallElevatorEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import jdk.nashorn.internal.objects.NativeDebug;
import model.Elevator;
import model.MoveDirectionEnum;
import model.Request;

import model.CarRequest;
import model.Elevator;

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
        

        Config.createStatement("select floorNum from CallCarEvent")
                .setSubscriber(new Object() {
                    public void update(int floorNum) throws InterruptedException {

                        JButton callBtn = null;
                        String btnName = "CallElevatorBtn";
                        btnName += floorNum;
                        System.out.println(btnName);

                        for (Component c : elevator.getGui().getjPanel1().getComponents()) {
                            System.out.println(c.getName());
                            if (c instanceof JButton) {
                                if (c.getName().compareToIgnoreCase(btnName) == 0) {
                                    callBtn = (JButton) c;
                                } 
                            }
                        }
                        if (elevator.getCurrentFloor() != floorNum) {
                            callBtn.setBackground(Color.YELLOW);
                            elevator.AddRequest(new CarRequest(floorNum, callBtn));
                        }
                    }
                });
    }
}
