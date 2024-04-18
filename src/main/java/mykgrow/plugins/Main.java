package mykgrow.plugins;

import mykgrow.application.RandomDataGenerator;
import mykgrow.domain.entities.GrowingPreset;

public class Main {
    public static void main(String[] args) {
        MorphiaConnection connection = new MorphiaConnection("mongodb+srv://<username>:<password>@cluster0.ljmudqt.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0", "MykGrow");
        PresetSaveService service = new PresetSaveService(connection.getDatastore());

        RandomDataGenerator.generateRandomMushroomSpecies(1, 2).forEach(species -> {
            GrowingPreset preset = species.getRecommendedConditions();
            service.savePreset(preset);
        });
    }
}