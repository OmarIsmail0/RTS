package event;

import event.CallElevatorEvent.MoveDirectionEnum;

public class ElevatorStateReading {
    private final boolean isMoving;
    private final MoveDirectionEnum direction;
    private final int currentFloor;

    public ElevatorStateReading(boolean isMoving, MoveDirectionEnum direction, int currentFloor) {
        this.isMoving = isMoving;
        this.direction = direction;
        this.currentFloor = currentFloor;
    }

    public boolean isIsMoving() {
        return isMoving;
    }

    public MoveDirectionEnum getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    
    
}
