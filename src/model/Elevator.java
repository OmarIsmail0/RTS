package model;

import event.CallElevatorEvent;
import view.ElevatorUI;

public class Elevator {
    
    private final ElevatorUI gui;
    private final DoorController doorCtrl;
    private final ElevatorController ctrl;
    private int currentFloor;
    private boolean isMoving;
    private boolean emergencyTrigger;


    private int elevatorPositionY;
    
    private CallElevatorEvent.MoveDirectionEnum direction;

    public Elevator() {
        this.gui = new ElevatorUI();
        this.doorCtrl = new DoorController(true,this);
        this.ctrl = new ElevatorController(this);
        this.currentFloor = 1;
        gui.setVisible(true);
    }
    
    public void AddRequest(Request request){
        this.ctrl.AcceptRequest(request);
    }

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

    public ElevatorController getCtrl() {
        return ctrl;
    }

    

    public boolean isMoving() {
        return isMoving;
    }

    public boolean isEmergencyTrigger() {
        return emergencyTrigger;
    }

    public CallElevatorEvent.MoveDirectionEnum getDirection() {
        return direction;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void setDirection(CallElevatorEvent.MoveDirectionEnum direction) {
        this.direction = direction;
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
}
