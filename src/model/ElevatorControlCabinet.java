package model;

import view.ElevatorUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

public class ElevatorControlCabinet {

    private final ElevatorUI gui;
    private final SoundController sound;
    private final ElevatorCar elevator;
    private final Timer requestManager;
    private final ArrayList<ElevatorRequestController> Requests;
    private boolean emergencyTrigger;

    public ElevatorControlCabinet(ElevatorCar elevator) {
        this.elevator = elevator;
        requestManager = new Timer();
        gui = new ElevatorUI();
        Requests = new ArrayList<>();
        requestManager.schedule(new ElevatorRequestController(elevator, this), 0, 1000);
        sound = new SoundController();
    }

    public ElevatorCar getElevator() {
        return elevator;
    }
    
    public SoundController getSound() {
        return sound;
    }

    public ElevatorUI getGUI() {
        return gui;
    }

    public boolean isEmergencyTrigger() {
        return emergencyTrigger;
    }

    public void setEmergencyTrigger(boolean emergencyTrigger) {
        this.emergencyTrigger = emergencyTrigger;
    }

    public void AcceptRequest(ElevatorRequestController request) {
        boolean flagExist = false;
        for (ElevatorRequestController r : Requests) {
            if (r.getRequestedFloor() == request.getRequestedFloor()
                    || r.getRequestID() == request.getRequestID()
                    || request.getRequestedFloor() == elevator.getCurrentFloor()) {
                flagExist = true;
            }
        }
        if (!flagExist) {
            Requests.add(request);
        }

    }

    public ArrayList<ElevatorRequestController> getRequests() {
        return Requests;
    }

    public ElevatorRequestController getNextRequest() {
        Collections.sort(Requests, (a, b) -> Math.abs(elevator.getCurrentFloor() - a.getRequestedFloor()) < Math.abs(elevator.getCurrentFloor() - b.getRequestedFloor()) ? -1 : 1);
        if (Requests.isEmpty()) {
            return null;
        } else {
            return Requests.remove(0);
        }
    }

    public void MoveElevator(ElevatorRequestController r) {
        if (r.getRequestedFloor() != elevator.getCurrentFloor()) {
            elevator.getGui().getDoorBtn().setEnabled(false);
            elevator.getGui().getCloseDoorBtn().setEnabled(false);

            if (!elevator.getIsMoving()) {
                sound.playWaitingMusic();
            }

            Timer t = new Timer();
            t.schedule(new ElevatorMachineDrive(elevator, r), 500, 7);
        }
    }

    
    
}
