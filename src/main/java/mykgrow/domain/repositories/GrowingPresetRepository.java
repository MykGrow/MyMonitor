package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public enum GrowingPresetRepository implements GrowingPresetRepositoryInterface{
    INSTANCE;
    private List<GrowingPreset> growingPresets;
    private SaveGrowingPresetInterface saveGrowingPresetService;

    private GrowingPresetRepository() {
        growingPresets = new ArrayList<>();
    }
    public void initialize(SaveGrowingPresetInterface saveGrowingPresetService) {
        this.saveGrowingPresetService = saveGrowingPresetService;
    }

    @Override
    public void savePreset(GrowingPreset preset){
        if (preset != null) {
            //saveGrowingPresetService.saveGrowingPreset(preset);
            growingPresets.add(preset);
        } else {
            throw new IllegalArgumentException("Preset cannot be null");
        }
    }

    @Override
    public List<GrowingPreset> getGrowingPresets() {
        return growingPresets;
    }
}
