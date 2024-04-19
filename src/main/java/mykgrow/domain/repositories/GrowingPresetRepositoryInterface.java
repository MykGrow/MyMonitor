package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface GrowingPresetRepositoryInterface {
    void savePreset(GrowingPreset preset);
    void updatePreset(ObjectId id, GrowingPreset preset);
    void deletePreset(GrowingPreset preset);
    GrowingPreset getPresetById(ObjectId id);
    List<GrowingPreset> getGrowingPresetsAsList();
    Map<ObjectId, GrowingPreset> getGrowingPresets();


}
