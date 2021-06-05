package events;

public class ElevatorStateReading {
    private final boolean isMoving;
    private final int currentFloor;
    private final int carPositionY;

    public ElevatorStateReading( boolean isMoving, int carPositionY, int currentFloor) {
        this.isMoving = isMoving;
        
        this.currentFloor = currentFloor;
        this.carPositionY = carPositionY;
    }

    public boolean isIsMoving() {
        return isMoving;
    }


    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public int getCarPositionY() {
        return carPositionY;
    }
    
}