package events;

public class CallCarEvent {

    private final int floorNum;

    public CallCarEvent(int floorNum) {
        this.floorNum = floorNum;
    }
    public int getFloorNum() {
        return floorNum;
    }
}
