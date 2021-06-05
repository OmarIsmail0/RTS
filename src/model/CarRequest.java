package model;

import event.CallElevatorEvent.MoveDirectionEnum;

import javax.swing.*;

public class CarRequest extends Request{


    public CarRequest(int requestedFloor, JButton clickedBtn, MoveDirectionEnum direction) {
        super(requestedFloor, direction,clickedBtn);

    }

}
