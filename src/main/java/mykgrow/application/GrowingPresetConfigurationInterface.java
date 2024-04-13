package mykgrow.application;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;

public interface GrowingPresetConfigurationInterface {
    void saveGrowingPreset(GrowingPreset growingPreset);
    GrowingPresetRepositoryInterface getGrowingPresetRepository();
}
