package model;

public class DoorController {
    private boolean isOpen;
    private Elevator elevator;

    public DoorController(boolean isOpen, Elevator elevator) {
        this.isOpen = isOpen;
        this.elevator = elevator;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setElevator(boolean isOpen) {
        setIsOpen(isOpen);
        if(this.isOpen == false){
            elevator.getGui().getDoorStatusField().setText("CLOSED");
        }
        else{
            elevator.getGui().getDoorStatusField().setText("OPEN");
            elevator.getCtrl().getAudioController().playDoorSound();
        }
    }

    
    
    
}
