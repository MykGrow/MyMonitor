package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.*;

public enum GrowingPresetRepository implements GrowingPresetRepositoryInterface{

    INSTANCE;
    private Map<UUID, GrowingPreset> growingPresets;

    private GrowingPresetRepository() {
        this.growingPresets = new HashMap<>();
    }

    public void savePreset(GrowingPreset preset){
        if (preset != null) {
            growingPresets.put(preset.getId(), preset);
        } else {
            throw new IllegalArgumentException("Preset cannot be null");
        }
    }

    @Override
    public void updatePreset(UUID id, GrowingPreset preset) {
        getPresetById(id).setName(preset.getName());
        getPresetById(id).setGrowthPeriods(preset.getGrowthPeriods());
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

    public Map<UUID, GrowingPreset> getGrowingPresets() {
        return growingPresets;
    }
    public List<GrowingPreset> getGrowingPresetsAsList() {
        return new ArrayList<>(growingPresets.values());
    }

}
