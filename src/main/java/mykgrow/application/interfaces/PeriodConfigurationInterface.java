package mykgrow.application.interfaces;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;

public interface PeriodConfigurationInterface {
    void saveGrowingPreset(GrowingPreset growingPreset);
    GrowingPresetRepositoryInterface getGrowingPresetRepository();
}
