package esper;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);
        // Register events
        Config.registerEvents();

        
        
    }
}
