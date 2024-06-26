package mykgrow.archived;

public class VentilationControlService {
    private final GrowBox growBox;
    private final FanActuator fan;
    private final TemperatureSensor temperatureSensor;

    public VentilationControlService(GrowBox growBox) {
        this.growBox = growBox;
        this.fan = (FanActuator) growBox.findActuatorByType(ActuatorType.FAN);
        this.temperatureSensor = (TemperatureSensor) growBox.findSensorByType(SensorType.TEMPERATURE);
    }

    public void regulateVentilation() {
        // Check if ventilation actuator and temperature sensor are available
        if (fan == null || temperatureSensor == null) {
            System.out.println("Ventilation actuator or temperature sensor not found!");
            return;
        }

        // Get current temperature reading
        double currentTemperature = temperatureSensor.getCurrentSensorValue();

        // Adjust ventilation based on temperature
        if (currentTemperature > 30.0) { // Example threshold, adjust as needed
            // If temperature is high, turn on ventilation
            fan.turnOn();
        } else {
            // If temperature is within acceptable range, turn off ventilation
            fan.turnOff();
        }
    }
}
