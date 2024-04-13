package mykgrow.domain.repositories;

import mykgrow.domain.entities.GrowingPreset;

import java.util.ArrayList;
import java.util.List;

public class GrowingPresetRepository implements GrowingPresetRepositoryInterface{
    private List<GrowingPreset> growingPresets;

    public GrowingPresetRepository() {
        this.growingPresets = new ArrayList<>();
    }

    public void savePreset(GrowingPreset preset){
        if (preset != null) {
            growingPresets.add(preset);
        } else {
            throw new IllegalArgumentException("Preset cannot be null");
        }
    }

    public List<GrowingPreset> getGrowingPresets() {
        return growingPresets;
    }

}
