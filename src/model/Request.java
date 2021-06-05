package model;

import event.CallElevatorEvent.MoveDirectionEnum;
import javax.swing.JButton;

public class Request {
    private static int count = 0;
    private final MoveDirectionEnum direction;
    private final int requestID;
    private final int requestedFloor;
    private final JButton clickedBtn;

    public Request(int requestedFloor, MoveDirectionEnum direction, JButton clickedBtn) {
        count++;
        this.requestID = count;
        this.requestedFloor = requestedFloor;
        this.clickedBtn = clickedBtn;
        this.direction = direction;
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
