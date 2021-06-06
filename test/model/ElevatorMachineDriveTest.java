package model;

import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import model.ElevatorCar;
import model.ElevatorRequestController;
import model.ElevatorControlCabinet;

public class ElevatorMachineDriveTest {
    /**
     * Test of getFloorIndex method, of class ElevatorMachineDrive.
     */
    @Test
    public void testGetFloorIndex() {
        try {
            Logger.getRootLogger().setLevel(Level.OFF);
            int Y = 438;
            ElevatorCar elev = new ElevatorCar();
            JPanel Elevator = elev.getGui().getCarPnel();
            Elevator.setLocation(Elevator.getLocation().x, 438);
            ElevatorControlCabinet ecc = new ElevatorControlCabinet(elev);
            ElevatorRequestController req = new ElevatorRequestController(elev, ecc);

            ElevatorMachineDrive instance = new ElevatorMachineDrive(elev, req);
            int expected = 1;
            int actual = instance.getFloorIndex(Y);
            
            assertEquals(expected, actual);
            System.out.println("expected result is: " + expected);
            System.out.println("actual result is: " + actual);
        } catch (Exception e) {
            fail("floor cannot be gotten");
        }
    }

}
