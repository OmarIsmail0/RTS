package event;

import model.LightsEnum;

public class LightSensorReading {
    private final LightsEnum lights;

    public LightSensorReading(LightsEnum lights) {
        this.lights = lights;
    }

    public LightsEnum getLights() {
        return lights;
    }
    
}
