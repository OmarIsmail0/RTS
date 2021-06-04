package events;

public class EmergencyStopEvent {

    private final boolean trigger_emergency;

    public EmergencyStopEvent(boolean trigger_emergency) {
        this.trigger_emergency = trigger_emergency;
    }

    public boolean isTrigger_emergency() {
        return trigger_emergency;
    }

}
