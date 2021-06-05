package event;

public class ChooseFloorEvent {
    private final int destinationFloor;

    public ChooseFloorEvent(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
    
}
