package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.List;

public interface GrowingPresetRepositoryInterface {
    void savePreset(GrowingPreset preset);

    List<GrowingPreset> getGrowingPresets();


}
