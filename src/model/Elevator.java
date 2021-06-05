package model;

import view.ElevatorUI;

public class Elevator {
    private final ElevatorUI gui;
    private int currentFloor;

    public Elevator(ElevatorUI gui) {
        this.gui = gui;
        this.currentFloor = 1;
    }

    public Elevator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ElevatorUI getGui() {
        return gui;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    
    public void AddRequest(Request request){
        this.controller.AcceptRequest(request);
    }
}
