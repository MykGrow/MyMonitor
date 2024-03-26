package mykgrow.domain.entities;

import mykgrow.domain.enums.ActuatorType;
import mykgrow.domain.enums.SensorType;

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

    public HumiditySensor getHumiditySensor() {
        for (Sensor sensor : sensors) {
            if (sensor instanceof HumiditySensor) {
                return (HumiditySensor) sensor;
            }
        }
        return null;
    }

    public Sensor findSensorByType(SensorType type) {
        for (Sensor sensor : sensors) {
            if (sensor.getType() == type) {
                return sensor;
            }
        }
        return null; // Sensor of specified type not found
    }

    public Actuator findActuatorByType(ActuatorType type) {
        for (Actuator actuator : actuators) {
            if (actuator.getType() == type) {
                return actuator;
            }
        }
        return null; // Actuator of specified type not found
    }

}
