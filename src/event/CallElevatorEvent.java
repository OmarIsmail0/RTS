package event;

import model.MoveDirection;

public class CallElevatorEvent {
    private final int requestedFloor;
    private final MoveDirection direction;

    public CallElevatorEvent(int requestedFloor, MoveDirection direction) {
        this.requestedFloor = requestedFloor;
        this.direction = direction;
    }

    public int getRequestedFloor() {
        return requestedFloor;
    }

    public MoveDirection getDirection() {
        return direction;
    }
    
}
