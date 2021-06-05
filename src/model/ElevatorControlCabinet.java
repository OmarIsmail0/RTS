package model;

import view.ElevatorUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;


/**
 *
 * @author Laptop Shop
 */
public class ElevatorControlCabinet {
    // The Elevator GUI
    private final ElevatorUI gui;
    //private final DoorController doorc;
    private final SoundController sound;
    
    private final ElevatorCar elevator;
    private final Timer requestManager;
    private final ArrayList<Request> Requests;
    // Elevator Components
    
    // Elevators StatusW
    private boolean emergencyTrigger;
    //private boolean isOpen;
    
 
    public ElevatorControlCabinet(ElevatorCar elevator) {
        this.elevator = elevator;
        this.requestManager = new Timer();
        this.gui = new ElevatorUI();
        this.Requests = new ArrayList<>();
        this.requestManager.schedule(new RequestManager(elevator, this), 0, 1000);
        this.sound = new SoundController();
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
    
    
    public void ChangeDoorState(boolean doorState){
        if (elevator.getIsMoving() == false){
            this.elevator.getDoorCtrl().changeDoorStatus(doorState);
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
              sound.playWaitingMusic();
         
            Timer t = new Timer();
            t.schedule(new ElevatorMachineDrive(elevator, r), 500, 7);
        }
    }
    
}

