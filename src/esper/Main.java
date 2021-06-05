package esper;

import model.CarRequest;
import model.Elevator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);
        // Register events
        Config.registerEvents();

        final Elevator elevator = new Elevator();

        Config.createStatement("select floorNum from CallCarEvent")
                .setSubscriber(new Object() {
                    public void update(int floorNum) throws InterruptedException {

                        JButton callBtn = null;
                        String btnName = "CallElevatorBtn";
                        btnName += floorNum;
                        System.out.println(btnName);

                        for (Component c : elevator.getGui().getjPanel1().getComponents()) {
                            System.out.println(c.getName());
                            if (c instanceof JButton) {
                                if (c.getName().compareToIgnoreCase(btnName) == 0) {
                                    callBtn = (JButton) c;
                                } 
                            }
                        }
                        if (elevator.getCurrentFloor() != floorNum) {
                            callBtn.setBackground(Color.YELLOW);
                            elevator.AddRequest(new CarRequest(floorNum, callBtn));
                        }
                    }
                });

    }
}
