package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.List;
import java.util.UUID;

public interface GrowingPresetRepositoryInterface {
    void savePreset(GrowingPreset preset);
    void updatePreset(UUID id, GrowingPreset preset);
    void deletePreset(GrowingPreset preset);
    GrowingPreset getPresetById(UUID id);
    List<GrowingPreset> getGrowingPresetsAsList();


}
