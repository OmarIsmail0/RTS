package model;
import javax.swing.JButton;

public class ElevatorRequest {
  
    private static int count = 1;
    private final int requestID;
    private final int requestedFloor;
    private final JButton clickedBtn;

    public ElevatorRequest(int requestedFloor, JButton clickedBtn) {
        this.requestID = count;
        this.requestedFloor = requestedFloor;
        this.clickedBtn = clickedBtn;

        count++;
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
}
