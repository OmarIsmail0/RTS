package model;

import java.util.TimerTask;

public class RequestManager extends TimerTask{
    private final Elevator elevator;
    private final ElevatorController controller;

    public RequestManager(Elevator elevator, ElevatorController controller) {
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
        
        Request r = controller.getNextRequest();
        controller.MoveElevator(r);
    }
}