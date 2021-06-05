package model;

import esper.Config;
import events.WeightSensorReading;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeightController extends Thread {

    private int weight;
    private Elevator elevator;

    public WeightController(Elevator elevator) {
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
        System.out.println("Here");
        try {
            this.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WeightController.class.getName()).log(Level.SEVERE, null, ex);
        }
        weight = Integer.parseInt(elevator.getGui().getWeightInput().getText());
        Config.sendEvent(new WeightSensorReading(weight));
    }
}
