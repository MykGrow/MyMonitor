package mykgrow.domain.entities;

public class CurrentConditions {
    private Condition currentTemperature;
    private Condition currentHumidity;
    private Condition currentLightIntensity;
    private Condition currentAirflow;

    public CurrentConditions(double temperature, double humidity, double lightIntensity, double airflow) {
        this.currentTemperature = new Condition("Temperature", temperature, "°C");
        this.currentHumidity = new Condition("Humidity", humidity, "%");
        this.currentLightIntensity = new Condition("Light Intensity", lightIntensity, "lux");
        this.currentAirflow = new Condition("Airflow", airflow, "m/s");
    }

    // Getters and setters
    public Condition getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature.setValue(currentTemperature);
    }

    public Condition getCurrentHumidity() {
        return currentHumidity;
    }

    public void setCurrentHumidity(double currentHumidity) {
        this.currentHumidity.setValue(currentHumidity);
    }

    public Condition getCurrentLightIntensity() {
        return currentLightIntensity;
    }

    public void setCurrentLightIntensity(double currentLightIntensity) {
        this.currentLightIntensity.setValue(currentLightIntensity);
    }

    public Condition getCurrentAirflow() {
        return currentAirflow;
    }

    public void setCurrentAirflow(double currentAirflow) {
        this.currentAirflow.setValue(currentAirflow);
    }
}
