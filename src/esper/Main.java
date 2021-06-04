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

                        for (int i = 0; i < elevator.getGui().getjPanel1().getComponents().length; i++){
                            if(elevator.getGui().getjPanel1().getComponent(i).equals(btnName)){
                                System.out.println("print 0.5");
                                callBtn = (JButton) elevator.getGui().getjPanel1().getComponent(i);
                            }
                        }
                        for (Component c : elevator.getGui().getjPanel1().getComponents()) {
                            System.out.println(c.getName());
                            if (c instanceof JButton) {
                                System.out.println(c.getName());
                                if (c.getName().compareToIgnoreCase(btnName) == 0) {
                                    System.out.println("print 0.5");
                                    callBtn = (JButton) c;
                                } else {
                                    System.out.println(":(");
                                    System.out.println(c.getName());
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
