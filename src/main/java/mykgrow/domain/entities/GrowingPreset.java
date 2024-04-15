package mykgrow.domain.entities;

import java.util.List;

public class GrowingPreset {
    private String name;
    private List<GrowthPeriod> growthPeriods;

    public GrowingPreset(String name, List<GrowthPeriod> growthPeriods) {
        this.name = name;
        this.growthPeriods = growthPeriods;
    }

    public String getName() {
        return this.name;
    }
    public List<GrowthPeriod> getGrowthPeriods() {
        return this.growthPeriods;
    }
}
