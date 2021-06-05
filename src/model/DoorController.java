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

    public void setElevator() {
        if(this.isOpen == false){
            
        }
    }

    
    
    
}
