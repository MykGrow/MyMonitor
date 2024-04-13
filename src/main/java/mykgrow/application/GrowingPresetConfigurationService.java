package mykgrow.application;

import mykgrow.domain.entities.GrowingPreset;

public class GrowingPresetConfigurationService implements GrowingPresetConfigurationInterface{
    @Override
    public void saveGrowingPreset(GrowingPreset growingPreset) {
        System.out.println("Saving growing preset..." + growingPreset.getName());
        // print the conditions and values
        growingPreset.getConditions().forEach((condition, value) -> {
            System.out.println(condition + ": " + value);
        });
    }
}
