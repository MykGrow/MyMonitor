package mykgrow.domain.entities;

import java.util.List;
import java.util.UUID;

public class GrowingPreset {
    // uuid
    private UUID id;
    private String name;
    private List<GrowthPeriod> growthPeriods;

    public GrowingPreset(String name, List<GrowthPeriod> growthPeriods) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.growthPeriods = growthPeriods;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGrowthPeriods(List<GrowthPeriod> growthPeriods) {
        this.growthPeriods = growthPeriods;
    }
    public UUID getId() {
        return this.id;
    }
    public List<GrowthPeriod> getGrowthPeriods() {
        return this.growthPeriods;
    }
}
