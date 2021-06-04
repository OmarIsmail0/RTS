package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.DoorEvent;
import events.EmergencyStopEvent;

public class Config {
    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
    
    public static void registerEvents() {
        //engine.getEPAdministrator().getConfiguration().addEventType(CarCallEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(EmergencyStopEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(DoorEvent.class);
       
        
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
