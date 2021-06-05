package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import event.CallElevatorEvent;
import event.*;
import events.DoorStateSensor;

public class Config {
    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

    public static void registerEvents() {
        //engine.getEPAdministrator().getConfiguration().addEventType(CarCallEvent.class);

        engine.getEPAdministrator().getConfiguration().addEventType(CallElevatorEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ChooseFloorEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ElevatorStateReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(EmergencyStopEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(LightSensorReading.class);
        System.out.println("Events Successfully Registered.");
    }

    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }

    public static void sendEvent(Object o) {
        engine.getEPRuntime().sendEvent(o);
    }
}
