package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

public class ElevatorController {
    private final Elevator elevator;
    private final Timer requestManager;
    private final ArrayList<Request> Requests;
    private final SoundController audioController;
    
    
    public ElevatorController(Elevator elevator) {
        
        this.elevator = elevator;
        this.requestManager = new Timer();
        this.Requests = new ArrayList<>();
        this.requestManager.schedule(new RequestManager(elevator, this), 0, 1000);
        this.audioController = new SoundController();
    }
    
    public void ChangeDoorState(boolean doorState){
        if (elevator.getIsMoving() == false){
            this.elevator.getDoorCtrl().setElevator(doorState);
        }
    }
    
    public void AcceptRequest(Request request){
        boolean flagExist = false;
        for (Request r : Requests){
            if (r.getRequestedFloor() == request.getRequestedFloor() || r.getRequestID() == request.getRequestID() || request.getRequestedFloor() == elevator.getCurrentFloor()){
                flagExist = true;
            }
        }
        if (!flagExist)
            Requests.add(request);
        
    }

    public ArrayList<Request> getRequests() {
        return Requests;
    }

    public Request getNextRequest(){
        Collections.sort(Requests, (a, b) -> Math.abs(elevator.getCurrentFloor() - a.getRequestedFloor()) < Math.abs(elevator.getCurrentFloor() - b.getRequestedFloor()) ? -1 : 1);
        if (Requests.isEmpty())
            return null;
        else{
            return Requests.remove(0);
        }
    }
    
    public void MoveElevator(Request r){
        if (r.getRequestedFloor() != elevator.getCurrentFloor()){
            elevator.getGui().getDoorBtn().setEnabled(false);
            //elevator.getGui().getBtnCloseDoor().setEnabled(false);
            
            if (!elevator.getIsMoving())
                this.audioController.playWaitingMusic();
            
            Timer t = new Timer();
            t.schedule(new ElevatorTranslateThread(elevator, r), 500, 7);
        }
    }

    public SoundController getAudioController() {
        return audioController;
    }
}
