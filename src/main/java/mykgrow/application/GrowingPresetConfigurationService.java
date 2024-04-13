package mykgrow.application;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.GrowingPresetRepository;

import java.util.List;

public class GrowingPresetConfigurationService implements GrowingPresetConfigurationInterface{

    GrowingPresetRepository growingPresetRepository;

    public GrowingPresetConfigurationService(GrowingPresetRepository growingPresetRepository) {
        this.growingPresetRepository = growingPresetRepository;
    }

    @Override
    public void saveGrowingPreset(GrowingPreset growingPreset) {
        growingPresetRepository.savePreset(growingPreset);
    }

}
