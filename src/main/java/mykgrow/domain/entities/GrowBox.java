package mykgrow.domain.entities;

import java.util.UUID;

import java.util.ArrayList;
import java.util.List;

public class GrowBox {
    private final UUID id;
    private final String name;
    private List<Actuator> actuators;
    private List<Sensor> sensors;

    public GrowBox(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        actuators = new ArrayList<>();
        sensors = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addActuator(Actuator actuator) {
        actuators.add(actuator);
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

}
