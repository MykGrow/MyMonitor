package mykgrow.domain.entities;

public class GrowingPreset {

    private String name;
    private Condition presetTemperature;
    private Condition presetHumidity;
    private Condition presetLightIntensity;
    private Condition presetAirflow;

    public GrowingPreset(String name, double temperature, double humidity, double lightIntensity, double airflow) {
        this.presetTemperature = new Condition("Temperature", temperature, "°C");
        this.presetHumidity = new Condition("Humidity", humidity, "%");
        this.presetLightIntensity = new Condition("Light Intensity", lightIntensity, "lux");
        this.presetAirflow = new Condition("Airflow", airflow, "m/s");
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Condition getPresetTemperature() {
        return presetTemperature;
    }

    public void setPresetTemperature(double presetTemperature) {
        this.presetTemperature.setValue(presetTemperature);
    }

    public Condition getPresetHumidity() {
        return presetHumidity;
    }

    public void setPresetHumidity(double presetHumidity) {
        this.presetHumidity.setValue(presetHumidity);
    }

    public Condition getPresetLightIntensity() {
        return presetLightIntensity;
    }

    public void setPresetLightIntensity(double presetLightIntensity) {
        this.presetLightIntensity.setValue(presetLightIntensity);
    }

    public Condition getPresetAirflow() {
        return presetAirflow;
    }

    public void setPresetAirflow(double presetAirflow) {
        this.presetAirflow.setValue(presetAirflow);
    }
}
