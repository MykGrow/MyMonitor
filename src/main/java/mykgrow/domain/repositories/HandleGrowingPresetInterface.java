package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.List;

public interface HandleGrowingPresetInterface {
    void saveGrowingPreset(GrowingPreset preset);

    List<GrowingPreset> loadAllGrowingPresets();
}
