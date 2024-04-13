package mykgrow.domain.entities;

public class CurrentConditions {
    private double temperature;
    private double humidity;
    private double lightIntensity;
    private double airflow;

    public CurrentConditions(double temperature, double humidity, double lightIntensity, double airflow) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.lightIntensity = lightIntensity;
        this.airflow = airflow;
    }

    // Getters and setters
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(double lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public double getAirflow() {
        return airflow;
    }

    public void setAirflow(double airflow) {
        this.airflow = airflow;
    }
}
