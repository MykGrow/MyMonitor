package mykgrow.application.interfaces;

import mykgrow.domain.entities.MushroomSpecies;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;

public interface SaveMushromPresetAsPresetInterface {
    void saveMushromPresetAsPreset(MushroomSpecies species);

    GrowingPresetRepositoryInterface getGrowingPresetRepository();
}
