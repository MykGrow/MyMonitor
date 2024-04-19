package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;
import org.bson.types.ObjectId;

import java.util.*;
public enum GrowingPresetRepository implements GrowingPresetRepositoryInterface{
    INSTANCE;
    private Map<ObjectId, GrowingPreset> growingPresets;
    private SaveGrowingPresetInterface saveGrowingPresetService;

    private GrowingPresetRepository() {
        growingPresets = new HashMap<>();
    }
    public void initialize(SaveGrowingPresetInterface saveGrowingPresetService) {
        this.saveGrowingPresetService = saveGrowingPresetService;

    }

    @Override
    public void savePreset(GrowingPreset preset){
        if (preset != null) {
            saveGrowingPresetService.saveGrowingPreset(preset);
            growingPresets.put(preset.getId(), preset);
        } else {
            throw new IllegalArgumentException("Preset cannot be null");
        }
    }

    @Override
    public void updatePreset(UUID id, GrowingPreset preset) {
        getPresetById(id).setName(preset.getName());
        //getPresetById(id).setGrowthPeriods(preset.getGrowthPeriods());
    }

    @Override
    public void deletePreset(GrowingPreset preset) {
        growingPresets.remove(preset.getId());
        System.out.println("Preset deleted");
    }

    @Override
    public GrowingPreset getPresetById(UUID id) {
        return growingPresets.get(id);
    }

    @Override
    public Map<ObjectId, GrowingPreset> getGrowingPresets() {
        return growingPresets;
    }
    public List<GrowingPreset> getGrowingPresetsAsList() {
        return new ArrayList<>(growingPresets.values());
    }

}
