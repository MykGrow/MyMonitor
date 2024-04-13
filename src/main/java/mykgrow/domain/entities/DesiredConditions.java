package mykgrow.domain.entities;

public class DesiredConditions {
    private double desiredTemperature;
    private double desiredHumidity;
    private double desiredLightIntensity;
    private double desiredAirflow;

    public DesiredConditions(double desiredTemperature, double desiredHumidity, double desiredLightIntensity, double desiredAirflow) {
        this.desiredTemperature = desiredTemperature;
        this.desiredHumidity = desiredHumidity;
        this.desiredLightIntensity = desiredLightIntensity;
        this.desiredAirflow = desiredAirflow;
    }

    // Getters and setters
    public double getDesiredTemperature() {
        return desiredTemperature;
    }

    public void setDesiredTemperature(double desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }

    public double getDesiredHumidity() {
        return desiredHumidity;
    }

    public void setDesiredHumidity(double desiredHumidity) {
        this.desiredHumidity = desiredHumidity;
    }

    public double getDesiredLightIntensity() {
        return desiredLightIntensity;
    }

    public void setDesiredLightIntensity(double desiredLightIntensity) {
        this.desiredLightIntensity = desiredLightIntensity;
    }

    public double getDesiredAirflow() {
        return desiredAirflow;
    }

    public void setDesiredAirflow(double desiredAirflow) {
        this.desiredAirflow = desiredAirflow;
    }
}
