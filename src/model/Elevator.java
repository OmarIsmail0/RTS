package model;

import view.ElevatorUI;

public class Elevator {

    private final ElevatorUI gui;
    private int currentFloor;
    private boolean isMoving;
    private final RequestElevator controller;

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

}
