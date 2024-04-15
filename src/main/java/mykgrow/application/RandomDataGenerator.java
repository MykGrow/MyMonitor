package mykgrow.application;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDataGenerator {
    private static final Random random = new Random();

    // Generates a random temperature between min and max
    public static double generateRandomTemperature(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    // Generates a random humidity between min and max
    public static double generateRandomHumidity(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    // Generates a random light intensity between min and max
    public static int generateRandomLightIntensity(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    // Generates a random airflow rate between min and max
    public static double generateRandomAirflow(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    // Generates a random time between startTime and endTime
    public static LocalTime generateRandomTime(LocalTime startTime, LocalTime endTime) {
        int startSeconds = startTime.toSecondOfDay();
        int endSeconds = endTime.toSecondOfDay();
        int randomSeconds = startSeconds + random.nextInt(endSeconds - startSeconds);
        return LocalTime.ofSecondOfDay(randomSeconds);
    }

    // Generates a random GrowthPeriod
    public static GrowthPeriod generateRandomGrowthPeriod() {
        String name = "Period";
        String description = "Description of " + name;
        int durationInDays = random.nextInt(10) + 1; // Random duration between 1 and 10 days

        TemperatureCondition temperatureCondition = new TemperatureCondition(
                generateRandomTemperature(15.0, 30.0), generateRandomTemperature(15.0, 30.0));
        HumidityCondition humidityCondition = new HumidityCondition(
                generateRandomHumidity(40.0, 80.0), generateRandomHumidity(40.0, 80.0));
        LightCondition lightCondition = new LightCondition(
                generateRandomLightIntensity(500, 2000), generateRandomTime(LocalTime.of(6, 0), LocalTime.of(18, 0)),
                generateRandomTime(LocalTime.of(6, 0), LocalTime.of(18, 0)));
        AirflowCondition airflowCondition = new AirflowCondition(generateRandomAirflow(0.1, 0.5));

        return new GrowthPeriod.GrowthPeriodBuilder(name, description, durationInDays)
                .withTemperatureCondition(temperatureCondition)
                .withHumidityCondition(humidityCondition)
                .withLightCondition(lightCondition)
                .withAirflowCondition(airflowCondition)
                .build();
    }

    // Generates a list of random GrowthPeriods
    public static List<GrowthPeriod> generateRandomGrowthPeriods(int numPeriods) {
        List<GrowthPeriod> growthPeriods = new ArrayList<>();
        for (int i = 0; i < numPeriods; i++) {
            growthPeriods.add(generateRandomGrowthPeriod());
        }
        return growthPeriods;
    }

    // Generates a list of random MushroomSpecies with random GrowthPeriods
    public static List<MushroomSpecies> generateRandomMushroomSpecies(int numSpecies, int numPeriodsPerSpecies) {
        List<MushroomSpecies> speciesList = new ArrayList<>();
        for (int i = 1; i <= numSpecies; i++) {
            List<GrowthPeriod> growthPeriods = generateRandomGrowthPeriods(numPeriodsPerSpecies);
            GrowingPreset preset = new GrowingPreset("Preset " + i, growthPeriods);
            MushroomSpecies species = new MushroomSpecies("Species " + i, "Description of Species " + i, preset);
            speciesList.add(species);
        }
        return speciesList;
    }
}
