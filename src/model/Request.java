package model;
import javax.swing.JButton;

public class Request {
  
    private static int ID_COUNTER = 1;
    private final int requestID;
    private final int requestedFloor;
    private final JButton clickedBtn;

    public Request(int requestedFloor, JButton clickedBtn) {
        this.requestID = ID_COUNTER;
        this.requestedFloor = requestedFloor;
        this.clickedBtn = clickedBtn;

        ID_COUNTER++;
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
