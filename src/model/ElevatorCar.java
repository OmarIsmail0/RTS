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
        this.gui = new ElevatorUI();
        this.gui.getEmergencyStopBtn().setEnabled(false);
        this.ctrl = new ElevatorControlCabinet(this);
        this.weightCtrl = new WeightController(this);
        this.doorCtrl = new DoorController(true, ctrl);
        this.currentFloor = 1;
        gui.setVisible(true);
    }

    public void AddRequest(Request request) {
        this.ctrl.AcceptRequest(request);
    }


    public void RunEmergency() {
        this.gui.getEmergencyStopBtn().setEnabled(false);
        this.gui.getElevatorPanel().setEnabled(false);
        this.gui.getCallPanl().setEnabled(false);
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
        gui.getLightPanel().setBackground(Color.RED);
        gui.getDoorStatus().setText("Closed");
        ctrl.getSound().playEmergencySound();

    }


    public void OpenDoor() {
        this.doorCtrl.changeDoorStatus(true);
    }

    public void CloseDoor() {
        this.doorCtrl.changeDoorStatus(false);
    }

    /*-------Setters & Getters-------*/
    public ElevatorUI getGui() {
        return gui;
    }

    public int getCurrentFloor() {
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
