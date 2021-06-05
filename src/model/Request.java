package model;
import event.CallElevatorEvent.MoveDirectionEnum;
import javax.swing.JButton;

public class Request {
  
    private static int ID_COUNTER = 1;
    private final MoveDirectionEnum direction;
    private final int requestID;
    private final int requestedFloor;
    private final JButton clickedBtn;

    public Request(int requestedFloor, MoveDirectionEnum direction, JButton clickedBtn) {
        this.requestID = ID_COUNTER;
        this.requestedFloor = requestedFloor;
        this.direction = direction;
        this.clickedBtn = clickedBtn;

        ID_COUNTER++;
    }

    public int getRequestID() {
        return requestID;
    }

    public MoveDirectionEnum getDirection() {
        return direction;
    }
    
    public int getRequestedFloor() {
        return requestedFloor;
    }

    public JButton getClickedBtn() {
        return clickedBtn;
    }
}
