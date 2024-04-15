package mykgrow.domain.entities;

import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;

import java.time.LocalTime;

public class RecommendedConditions {
    private TemperatureCondition recommendedTemperature;
    private HumidityCondition recommendedHumidity;
    private LightCondition recommendedLightIntensity;
    private AirflowCondition recommendedAirflow;

    public RecommendedConditions(double lowerTemperatureThreshold, double upperTemperatureThreshold, double airExchangePerHour, double lowerHumidityThreshold, double upperHumidityThreshold, int lightLevel, LocalTime startTime, LocalTime endTime) {
        this.recommendedTemperature = new TemperatureCondition(lowerTemperatureThreshold, upperTemperatureThreshold);
        this.recommendedHumidity = new HumidityCondition(lowerHumidityThreshold, upperHumidityThreshold);
        this.recommendedLightIntensity = new LightCondition(lightLevel, startTime, endTime);
        this.recommendedAirflow = new AirflowCondition(airExchangePerHour);
    }

    public TemperatureCondition getRecommendedTemperature() {
        return recommendedTemperature;
    }

    public void setRecommendedTemperature(TemperatureCondition recommendedTemperature) {
        this.recommendedTemperature = recommendedTemperature;
    }

    public HumidityCondition getRecommendedHumidity() {
        return recommendedHumidity;
    }

    public void setRecommendedHumidity(HumidityCondition recommendedHumidity) {
        this.recommendedHumidity = recommendedHumidity;
    }

    public LightCondition getRecommendedLightIntensity() {
        return recommendedLightIntensity;
    }

    public void setRecommendedLightIntensity(LightCondition recommendedLightIntensity) {
        this.recommendedLightIntensity = recommendedLightIntensity;
    }

    public AirflowCondition getRecommendedAirflow() {
        return recommendedAirflow;
    }

    public void setRecommendedAirflow(AirflowCondition recommendedAirflow) {
        this.recommendedAirflow = recommendedAirflow;
    }
}
