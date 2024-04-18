package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.List;
import java.util.UUID;

public interface GrowingPresetRepositoryInterface {
    void savePreset(GrowingPreset preset);
    List<GrowingPreset> getGrowingPresets();


}
