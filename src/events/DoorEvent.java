
package events;
/*
public class DoorEvent {
    private final boolean isOpen;

    public DoorEvent(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean isDoorstate() {
        return isOpen;
    }
}
*/

public class DoorEvent {

    private final boolean doorState;

    public DoorEvent(boolean doorState) {
        this.doorState = doorState;
    }

    public boolean isDoorstate() {
        return doorState;
    }

    
}