package model;

import esper.Config;
import event.CallElevatorEvent;
import event.ElevatorStateReading;
import event.LightSensorReading;
import events.DoorStateSensor;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElevatorTranslateThread extends TimerTask {

    int[] FloorY = {548, 441, 320 };

    private final Elevator elevator;
    private final Request request;

    public ElevatorTranslateThread(Elevator elevator, Request request) {

        this.elevator = elevator;
        this.request = request;

        if (elevator.getCurrentFloor() == request.getRequestedFloor() || elevator.getIsMoving()) {
            try {
                this.cancel();
            } catch (Throwable ex) {
                Logger.getLogger(ElevatorTranslateThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Config.sendEvent(new LightSensorReading(LightsEnum.OFF));
        }
    }

    public int getCurrentFloor(int Y) {

        if (Y >= FloorY[0] - 1) {
            return 1;
        } else if (Y < FloorY[0] && Y >= FloorY[1]) {
            return 2;
        } else if (Y < FloorY[1] && Y >= FloorY[2]) {
            return 3;
        } else {
            return 0;
        }
    }

    @Override
    public void run() {
        int FloorIdx = request.getRequestedFloor() - 1;
        JPanel Elevator = elevator.getGui().getCarPnel();
        if (Math.abs(Elevator.getLocation().y - FloorY[FloorIdx]) > 0) {  // checks if the elevator isMoving
            if (Elevator.getLocation().y > FloorY[FloorIdx]) {
                Elevator.setLocation(Elevator.getLocation().x, Elevator.getLocation().y - 1);
                Config.sendEvent(new ElevatorStateReading(CallElevatorEvent.MoveDirectionEnum.UPWARDS, true, Elevator.getLocation().y, getCurrentFloor(Elevator.getLocation().y)));
            } else {
                Elevator.setLocation(Elevator.getLocation().x, Elevator.getLocation().y + 1);
                Config.sendEvent(new ElevatorStateReading(CallElevatorEvent.MoveDirectionEnum.DOWNWARDS, true, Elevator.getLocation().y, getCurrentFloor(Elevator.getLocation().y)));
            }
        } else {
            Config.sendEvent(new ElevatorStateReading(CallElevatorEvent.MoveDirectionEnum.NONE, false, Elevator.getLocation().y, getCurrentFloor(Elevator.getLocation().y)));
            Config.sendEvent(new LightSensorReading(LightsEnum.ON));
            request.getClickedBtn().setBackground(Color.WHITE);
            for (Component c : elevator.getGui().getCallPanl().getComponents()) {
                if (c instanceof JButton) {
                    if (((JButton) c).getName().compareToIgnoreCase(request.getClickedBtn().getName()) == 0) {
                        ((JButton) c).setBackground(Color.WHITE);
                    }
                }
            }
            for (Component c : elevator.getGui().getElevatorControllerPanel().getComponents()) {
                if (c instanceof JButton) {
                    try {
                        if (((JButton) c).getName().compareToIgnoreCase("Floor" + request.getRequestedFloor() + "btn") == 0) {
                            ((JButton) c).setBackground(Color.WHITE);
                            break;
                        }
                    } catch (Exception e) {

                    }

                }
            }
            this.cancel();
        }
    }
}
