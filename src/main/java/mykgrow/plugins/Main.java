package mykgrow.plugins;

import mykgrow.application.RandomDataGenerator;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.plugins.database.DatabaseClient;

public class Main {
    public static void main(String[] args) {
        DatabaseClient mappingPOJO = new DatabaseClient("MykGrow", "Presets", "mongodb+srv://mykgrow:mykgrow@cluster0.ljmudqt.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
        RandomDataGenerator.generateRandomMushroomSpecies(10, 2).forEach(species -> {
            GrowingPreset preset = species.getRecommendedConditions();
            mappingPOJO.saveGrowingPreset(preset);
        });
    }
}