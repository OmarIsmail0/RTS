
package events;

public class DoorEvent {

    private final boolean doorState;

    public DoorEvent(boolean doorState) {
        this.doorState = doorState;
    }

    public boolean isDoorstate() {
        return doorState;
    }

    
}