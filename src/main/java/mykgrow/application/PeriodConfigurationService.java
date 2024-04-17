package mykgrow.application;

import mykgrow.application.interfaces.PeriodConfigurationInterface;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;

public class PeriodConfigurationService implements PeriodConfigurationInterface {

    GrowingPresetRepositoryInterface growingPresetRepository;

    public PeriodConfigurationService(GrowingPresetRepository growingPresetRepository) {
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
