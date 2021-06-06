/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.ElevatorUI;
import model.ElevatorCar;
import model.ElevatorRequestController;
import model.ElevatorControlCabinet;
/**
 *
 * @author Laptop Shop
 */
public class ElevatorControlCabinetTest {
    
    public ElevatorControlCabinetTest() {
    }
    /**
     * Test of getNextRequest method, of class ElevatorControlCabinet.
     */
    @Test
    public void testGetNextRequest() {
        System.out.println("getNextRequest");
        
        ElevatorCar elev = new ElevatorCar();
        ElevatorControlCabinet ecc = new ElevatorControlCabinet(elev);
        ElevatorRequestController expected = null;
        ElevatorRequestController actual = ecc.getNextRequest();
        assertEquals(expected, actual);
    }

   
    
}
