package events;

public class PressEmergencyStopEvent {

    private final boolean trigger_emergency;

    public PressEmergencyStopEvent(boolean trigger_emergency) {
        this.trigger_emergency = trigger_emergency;
    }

    public boolean isTrigger_emergency() {
        return trigger_emergency;
    }

}
