package mykgrow.domain.entities;

public class RecommendedConditions {
    private Condition recommendedTemperature;
    private Condition recommendedHumidity;
    private Condition recommendedLightIntensity;
    private Condition recommendedAirflow;

    public RecommendedConditions(double desiredTemperature, double desiredHumidity, double desiredLightIntensity, double desiredAirflow) {
        this.recommendedTemperature = new Condition("Temperature", desiredTemperature, "°C");
        this.recommendedHumidity = new Condition("Humidity", desiredHumidity, "%");
        this.recommendedLightIntensity = new Condition("Light Intensity", desiredLightIntensity, "lux");
        this.recommendedAirflow = new Condition("Airflow", desiredAirflow, "m/s");
    }

    // Getters and setters
    public Condition getRecommendedTemperature() {
        return recommendedTemperature;
    }

    public void setRecommendedTemperature(double recommendedTemperature) {
        this.recommendedTemperature.setValue(recommendedTemperature);
    }

    public Condition getRecommendedHumidity() {
        return recommendedHumidity;
    }

    public void setRecommendedHumidity(double recommendedHumidity) {
        this.recommendedHumidity.setValue(recommendedHumidity);
    }

    public Condition getRecommendedLightIntensity() {
        return recommendedLightIntensity;
    }

    public void setRecommendedLightIntensity(double recommendedLightIntensity) {
        this.recommendedLightIntensity.setValue(recommendedLightIntensity);
    }

    public Condition getRecommendedAirflow() {
        return recommendedAirflow;
    }

    public void setRecommendedAirflow(double recommendedAirflow) {
        this.recommendedAirflow.setValue(recommendedAirflow);
    }
}
