package mykgrow.application;

import mykgrow.application.interfaces.GrowingPresetConfigurationInterface;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;

public class GrowingPresetConfigurationService implements GrowingPresetConfigurationInterface {

    GrowingPresetRepositoryInterface growingPresetRepository;

    public GrowingPresetConfigurationService(GrowingPresetRepository growingPresetRepository) {
        this.growingPresetRepository = growingPresetRepository;
    }

    @Override
    public void saveGrowingPreset(GrowingPreset growingPreset) {
        growingPresetRepository.savePreset(growingPreset);
    }

    @Override
    public GrowingPresetRepositoryInterface getGrowingPresetRepository() {
        return growingPresetRepository;
    }

}
