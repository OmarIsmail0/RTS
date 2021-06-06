package model;
import java.util.TimerTask;
import javax.swing.JButton;

public class ElevatorRequestController extends TimerTask{
  
    private static int count = 1;
    private final int requestID;
    private final int requestedFloor;
    private final JButton clickedBtn;
    private final ElevatorCar elevator;
    private final ElevatorControlCabinet controller;

    public ElevatorRequestController(int requestedFloor, JButton clickedBtn, 
            ElevatorCar elevator, ElevatorControlCabinet controller) {
        requestID = count;
        this.requestedFloor = requestedFloor;
        this.clickedBtn = clickedBtn;
        this.elevator = elevator;
        this.controller = controller;

        count++;
    }

    public ElevatorRequestController(ElevatorCar elevator, ElevatorControlCabinet controller) {
        requestID = getRequestID();
        this.requestedFloor = getRequestedFloor();
        this.clickedBtn = getClickedBtn();
        this.elevator = elevator;
        this.controller = controller;
    }
    
    public int getRequestID() {
        return requestID;
    }

    
    public int getRequestedFloor() {
        return requestedFloor;
    }

    public JButton getClickedBtn() {
        return clickedBtn;
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
        
        ElevatorRequestController r = controller.getNextRequest();
        controller.MoveElevator(r);
    }
}
