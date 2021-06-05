package events;

public class WeightSensorReading {
    private final int weight;

    public WeightSensorReading(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
