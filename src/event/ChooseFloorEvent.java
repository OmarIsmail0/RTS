package event;

public class ChooseFloorEvent {

    private final int destinationFloor;

    private final String type;

    public ChooseFloorEvent(int destinationFloor, String type) {
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
