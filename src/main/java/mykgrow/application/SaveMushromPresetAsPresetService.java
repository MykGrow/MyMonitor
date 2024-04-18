package mykgrow.application;

import mykgrow.application.interfaces.SaveMushromPresetAsPresetInterface;
import mykgrow.domain.entities.MushroomSpecies;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;
import mykgrow.plugins.database.DatabaseClient;

public class SaveMushromPresetAsPresetService implements SaveMushromPresetAsPresetInterface {


    public SaveMushromPresetAsPresetService() {
    }


    @Override
    public void saveMushromPresetAsPreset(MushroomSpecies species) {
        GrowingPresetRepository.INSTANCE.savePreset(species.getRecommendedConditions());
        System.out.println("Mushroom preset saved as preset");
    }
}
