package model;

import event.CallElevatorEvent;
import view.ElevatorUI;

public class Elevator {
    
    private final ElevatorUI gui;
    private int currentFloor;
    private boolean isMoving;
    private final RequestElevator controller;


    private int elevatorPositionY;
    private CallElevatorEvent.MoveDirectionEnum direction;

    public Elevator() {
        this.gui = new ElevatorUI();
        this.currentFloor = 1;
        gui.setVisible(true);
        this.controller = new RequestElevator(this);
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

    public void AddRequest(Request request){
        this.controller.AcceptRequest(request);
    }

    public boolean isMoving() {
        return isMoving;
    }

    public RequestElevator getController() {
        return controller;
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
}
