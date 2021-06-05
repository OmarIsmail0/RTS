package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.*;
import events.PressEmergencyStopEvent;

public class Config {
    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
    
    public static void registerEvents() {
        //engine.getEPAdministrator().getConfiguration().addEventType(CarCallEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(PressEmergencyStopEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(DoorSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(WeightSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ChooseFloorEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ElevatorStateReading.class);
        
        System.out.println("Events Successfully Registered.");
    }
    
    public static EPStatement createStatement(String s) {
        //System.out.print("emergecny statement sent");
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }
    
    public static void sendEvent(Object o) {
        engine.getEPRuntime().sendEvent(o);
    }
}
