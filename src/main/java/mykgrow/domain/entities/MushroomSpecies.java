package mykgrow.domain.entities;

public class MushroomSpecies {
    private final String name;
    private final String description;
    private final RecommendedConditions recommendedConditions;

    public MushroomSpecies(String name, String description, RecommendedConditions recommendedConditions) {
        this.name = name;
        this.description = description;
        this.recommendedConditions = recommendedConditions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public RecommendedConditions getRecommendedConditions() {
        return recommendedConditions;
    }
}
