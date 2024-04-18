package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public enum GrowingPresetRepository implements GrowingPresetRepositoryInterface{

    INSTANCE;
    private List<GrowingPreset> growingPresets;

    private GrowingPresetRepository() {
        this.growingPresets = new ArrayList<>();
    }

    public void savePreset(GrowingPreset preset){
        if (preset != null) {
            growingPresets.add(preset);
        } else {
            throw new IllegalArgumentException("Preset cannot be null");
        }
    }

    @Override
    public void updatePreset(GrowingPreset preset) {
        System.out.println("Preset updated");
    }

    @Override
    public void deletePreset(GrowingPreset preset) {
        System.out.println("Preset deleted");
    }

    @Override
    public GrowingPreset getPresetById(UUID id) {
        return null;
    }

    public List<GrowingPreset> getGrowingPresets() {
        return growingPresets;
    }

}
