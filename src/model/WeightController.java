package model;

import esper.Config;
import events.WeightSensorReading;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeightController extends Thread {

    private int weight;
    private ElevatorCar elevator;

    public WeightController(ElevatorCar elevator) {
        this.weight = 0;
        this.elevator = elevator;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void run() {
        while (true){

            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WeightController.class.getName()).log(Level.SEVERE, null, ex);
            }
            weight = Integer.parseInt(elevator.getGui().getWeightInput().getText());
            Config.sendEvent(new WeightSensorReading(weight));
        }

    }
}
