package model;

import esper.Config;
import events.DoorStateSensor;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElevatorTranslateThread extends TimerTask {
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
            Config.sendEvent(new DoorStateSensor(false));
        }
    }

    @Override
    public void run() {

    }
}
