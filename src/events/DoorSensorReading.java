
package events;

public class DoorSensorReading {

    private final boolean doorState;

    public DoorSensorReading(boolean doorState) {
        this.doorState = doorState;
    }

    public boolean isDoorstate() {
        return doorState;
    }

    
}