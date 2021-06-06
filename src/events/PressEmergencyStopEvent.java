package events;

public class PressEmergencyStopEvent {

    private final boolean isEmergencyPressed;

    public PressEmergencyStopEvent(boolean isEmergencyPressed) {
        this.isEmergencyPressed = isEmergencyPressed;
    }

    public boolean isIsEmergencyPressed() {
        return isEmergencyPressed;
    }
}
