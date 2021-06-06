package model;

import view.ElevatorUI;

import javax.swing.*;
import java.awt.*;

public class ElevatorCar {
    
    private final ElevatorUI gui;
    private final DoorController doorCtrl;
    private final ElevatorControlCabinet ctrl;
    private final WeightController weightCtrl;
    private int currentFloor;
    private boolean isMoving;
    private boolean emergencyTrigger;
    private int elevatorPositionY;


    public ElevatorCar() {
        gui = new ElevatorUI();
        gui.setVisible(true);
        gui.getEmergencyStopBtn().setEnabled(false);
        ctrl = new ElevatorControlCabinet(this);
        weightCtrl = new WeightController(this);
        doorCtrl = new DoorController(true, ctrl);
        currentFloor = 1;
    }

    public void CreateRequest(int destFloor, JButton btn) {
        ElevatorRequestController request = new ElevatorRequestController(destFloor, btn, this, ctrl);
        this.ctrl.AcceptRequest(request);
    }

    public void StartAlarm() {
        SoundController.getWaitingMusic().close();
        for (Component c : this.getGui().getElevatorPanel().getComponents()) {
            if (c instanceof JButton) {
                c.setEnabled(false);
                c.setBackground(java.awt.Color.RED);
            }
        }
        for (Component c : this.getGui().getCallPanl().getComponents()) {
            if (c instanceof JButton) {
                c.setEnabled(false);
                c.setBackground(java.awt.Color.RED);
            }
        }
        ctrl.getSound().playEmergencySound();
        this.isMoving = false;
        manageDoor("Close");
    }
    
    public void manageDoor(String type){
        if(type.equals("Open"))
            doorCtrl.changeDoorStatus(true);
        else
            doorCtrl.changeDoorStatus(false);
    }

    /*-------Setters & Getters-------*/
    public ElevatorUI getGui() {
        return gui;
    }

    public int getCurrentFloorIndex() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean getIsMoving() {
        return isMoving;
    }

    public ElevatorControlCabinet getCtrl() {
        return ctrl;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public boolean isEmergencyTrigger() {
        return emergencyTrigger;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public int getElevatorPositionY() {
        return elevatorPositionY;
    }

    public void setElevatorPositionY(int elevatorPositionY) {
        this.elevatorPositionY = elevatorPositionY;
    }

    public DoorController getDoorCtrl() {
        return doorCtrl;
    }

    public void setEmergencyTrigger(boolean emergencyTrigger) {
        this.emergencyTrigger = emergencyTrigger;
    }

    public WeightController getWeightCtrl() {
        return weightCtrl;
    }

    
    
}
