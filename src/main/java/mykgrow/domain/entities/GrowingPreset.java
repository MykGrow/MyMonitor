package mykgrow.domain.entities;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;

public class GrowingPreset {
    // uuid
    private ObjectId id;
    @BsonProperty("name")
    private String name;
    @BsonProperty("growthPeriods")
    private List<GrowthPeriod> growthPeriods;

    public GrowingPreset(String name, List<GrowthPeriod> growthPeriods) {
        this.name = name;
        this.growthPeriods = growthPeriods;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
<<<<<<< HEAD
    public ObjectId getId() {
=======
    public void setGrowthPeriods(List<GrowthPeriod> growthPeriods) {
        this.growthPeriods = growthPeriods;
    }
    public UUID getId() {
>>>>>>> main
        return this.id;
    }
    public List<GrowthPeriod> getGrowthPeriods() {
        return this.growthPeriods;
    }
}
