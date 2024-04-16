package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.List;

public interface GrowingPresetRepositoryInterface {
    void savePreset(GrowingPreset preset);
    void updatePreset(GrowingPreset preset);
    void deletePreset(GrowingPreset preset);
    GrowingPreset getPresetById(int id);
    List<GrowingPreset> getGrowingPresets();


}
