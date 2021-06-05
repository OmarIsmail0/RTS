package model;

import java.util.ArrayList;
import java.util.Timer;

public class RequestElevator {

    private final Elevator elevator;
    private final Timer requestManager;
    private final ArrayList<Request> Requests;
    private final SoundController audioController;

    public RequestElevator(Elevator elevator) {

        this.elevator = elevator;
        this.requestManager = new Timer();
        Requests = new ArrayList<>();
        this.audioController = new SoundController();

    }

    public void AcceptRequest(Request request){
        boolean flagExist = false;
        for (Request r : Requests){
            if (r.getRequestedFloor() == request.getRequestedFloor() || r.getRequestID() == request.getRequestID()
                    || request.getRequestedFloor() == elevator.getCurrentFloor()){
                flagExist = true;
            }
        }
        if (!flagExist)
            Requests.add(request);

    }

    public void MoveElevator(Request r){
        if (r.getRequestedFloor() != elevator.getCurrentFloor()){
            elevator.getGui().getDoorBtn().setEnabled(false);
            //elevator.getGUI().getBtnCloseDoor().setEnabled(false);

          /*  if (!elevator.getIsMoving())
                this.audioController.playDoaa();*/

            Timer t = new Timer();
            t.schedule(new ElevatorTranslateThread(elevator, r), 500, 7);
        }
    }

}
