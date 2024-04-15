package mykgrow.domain.entities;

public class MushroomSpecies {
    private final String name;
    private final String description;
    private final GrowingPreset recommendedPresets;

    public MushroomSpecies(String name, String description, GrowingPreset recommendedPresets) {
        this.name = name;
        this.description = description;
        this.recommendedPresets = recommendedPresets;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public GrowingPreset getRecommendedConditions() {
        return recommendedPresets;
    }
}
