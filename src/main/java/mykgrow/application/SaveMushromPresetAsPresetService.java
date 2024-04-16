package mykgrow.application;

import mykgrow.application.interfaces.SaveMushromPresetAsPresetInterface;
import mykgrow.domain.entities.MushroomSpecies;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;

public class SaveMushromPresetAsPresetService implements SaveMushromPresetAsPresetInterface {

    private GrowingPresetRepositoryInterface growingPresetRepository;

    public SaveMushromPresetAsPresetService(GrowingPresetRepositoryInterface growingPresetRepository) {
        this.growingPresetRepository = growingPresetRepository;
    }


    @Override
    public void saveMushromPresetAsPreset(MushroomSpecies species) {
        growingPresetRepository.savePreset(species.getRecommendedConditions());
        System.out.println("Mushroom preset saved as preset");
    }
}
