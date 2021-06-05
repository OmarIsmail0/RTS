package event;

import event.CallElevatorEvent.MoveDirectionEnum;

public class ElevatorStateReading {
    private final boolean isMoving;
    private final MoveDirectionEnum direction;
    private final int currentFloor;
    private final int carPositionY;

    public ElevatorStateReading(MoveDirectionEnum direction, boolean isMoving, int carPositionY, int currentFloor) {
        this.isMoving = isMoving;
        this.direction = direction;
        this.currentFloor = currentFloor;
        this.carPositionY = carPositionY;
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

    public boolean isMoving() {
        return isMoving;
    }

    public int getCarPositionY() {
        return carPositionY;
    }
}
