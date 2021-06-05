package model;

import java.util.TimerTask;

public class PanelControl extends TimerTask{
    private final ElevatorCar elevator;
    private final ElevatorControlCabinet controller;

    public PanelControl(ElevatorCar elevator, ElevatorControlCabinet controller) {
        this.elevator = elevator;
        this.controller = controller;
    }
    
    @Override
    public void run() {
        if (elevator.isEmergencyTrigger())
        {
            this.cancel();
            return;
        }
        
        if (controller.getRequests().isEmpty())
            return;
        
        if (elevator.getIsMoving())
            return;
        
        ElevatorRequest r = controller.getNextRequest();
        controller.MoveElevator(r);
    }
}