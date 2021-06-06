package events;

public class MoveElevatorEvent {

    private final int destinationFloor;
    private final String type;

    public MoveElevatorEvent(int destinationFloor, String type) {
        this.destinationFloor = destinationFloor;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}