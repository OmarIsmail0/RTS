package event;

public class EmergencyStopEvent {
    private final boolean setOffAlarm;

    public EmergencyStopEvent(boolean setOffAlarm) {
        this.setOffAlarm = setOffAlarm;
    }

    public boolean isSetOffAlarm() {
        return setOffAlarm;
    }

}
