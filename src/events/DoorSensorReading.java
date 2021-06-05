
package events;

public class DoorSensorReading {

    private final boolean doorOpen;

    public DoorSensorReading(boolean doorOpen) {
        this.doorOpen = doorOpen;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    

    
}