package events;

import event.CallElevatorEvent.MoveDirectionEnum;

public class CallCarEvent {

    private final int floorNum;
    private final MoveDirectionEnum direction;

    public CallCarEvent(int floorNum, MoveDirectionEnum direction) {
        this.floorNum = floorNum;
        this.direction = direction;
    }
    public int getFloorNum() {
        return floorNum;
    }
}
