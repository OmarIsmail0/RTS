package events;

public class ElevatorStateReading {
    private final boolean isMoving;
    private final int currentFloor;
    private final int YAxisPoint;

    public ElevatorStateReading( boolean isMoving, int YAxisPoint, int currentFloor) {
        this.isMoving = isMoving;
        this.currentFloor = currentFloor;
        this.YAxisPoint = YAxisPoint;
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

    public int getYAxisPoint() {
        return YAxisPoint;
    }

    
    
}