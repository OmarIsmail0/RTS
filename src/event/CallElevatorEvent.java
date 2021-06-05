package event;



public class CallElevatorEvent {
    public enum MoveDirectionEnum { UPWARDS, DOWNWARDS, NONE };
    
    private final int requestedFloor;
    private final MoveDirectionEnum direction;

    public CallElevatorEvent(int requestedFloor, MoveDirectionEnum direction) {
        this.requestedFloor = requestedFloor;
        this.direction = direction;
    }

    public int getRequestedFloor() {
        return requestedFloor;
    }

    public MoveDirectionEnum getDirection() {
        return direction;
    }
    
}
