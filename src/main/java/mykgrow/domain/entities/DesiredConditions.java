package mykgrow.domain.entities;

public class DesiredConditions {
    private Condition desiredTemperature;
    private Condition desiredHumidity;
    private Condition desiredLightIntensity;
    private Condition desiredAirflow;

    public DesiredConditions(double desiredTemperature, double desiredHumidity, double desiredLightIntensity, double desiredAirflow) {
        this.desiredTemperature = new Condition("Temperature", desiredTemperature, "°C");
        this.desiredHumidity = new Condition("Humidity", desiredHumidity, "%");
        this.desiredLightIntensity = new Condition("Light Intensity", desiredLightIntensity, "lux");
        this.desiredAirflow = new Condition("Airflow", desiredAirflow, "m/s");
    }

    // Getters and setters
    public Condition getDesiredTemperature() {
        return desiredTemperature;
    }

    public void setDesiredTemperature(double desiredTemperature) {
        this.desiredTemperature.setValue(desiredTemperature);
    }

    public Condition getDesiredHumidity() {
        return desiredHumidity;
    }

    public void setDesiredHumidity(double desiredHumidity) {
        this.desiredHumidity.setValue(desiredHumidity);
    }

    public Condition  getDesiredLightIntensity() {
        return desiredLightIntensity;
    }

    public void setDesiredLightIntensity(double desiredLightIntensity) {
        this.desiredLightIntensity.setValue(desiredLightIntensity);
    }

    public Condition getDesiredAirflow() {
        return desiredAirflow;
    }

    public void setDesiredAirflow(double desiredAirflow) {
        this.desiredAirflow.setValue(desiredAirflow);
    }
}
