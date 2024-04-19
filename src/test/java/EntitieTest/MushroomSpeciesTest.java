package EntitieTest;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MushroomSpeciesTest {
    MushroomSpecies mushroomSpecies;
    GrowingPreset growingPreset;
    public MushroomSpeciesTest() {
    }

    @BeforeEach
    public void setUp() {
        // create a growing preset with easy mock
        GrowthPeriod mockGrowthPeriod1 = EasyMock.createMock(GrowthPeriod.class);
        GrowthPeriod mockGrowthPeriod2 = EasyMock.createMock(GrowthPeriod.class);
        GrowthPeriod mockGrowthPeriod3 = EasyMock.createMock(GrowthPeriod.class);

        EasyMock.replay(mockGrowthPeriod1, mockGrowthPeriod2, mockGrowthPeriod3);


        List<GrowthPeriod> mockGrowthPeriods = Arrays.asList(
                mockGrowthPeriod1,
                mockGrowthPeriod2,
                mockGrowthPeriod3
        );

        growingPreset = new GrowingPreset("Test Preset", mockGrowthPeriods);
        mushroomSpecies = new MushroomSpecies("name", "description", growingPreset);
    }

    @Test
    @DisplayName("Test getName Method")
    public void testGetName() {
        MushroomSpecies mushroomSpecies = new MushroomSpecies("name", "description", new GrowingPreset("name", new ArrayList<GrowthPeriod>()));
        assertEquals("name", mushroomSpecies.getName());
    }

    @Test
    @DisplayName("Test getDescription Method")
    public void testGetDescription() {
        assertEquals("description", mushroomSpecies.getDescription());
    }

    @Test
    @DisplayName("Test getRecommendedConditions Method")
    public void testGetRecommendedConditions() {
        assertEquals(growingPreset, mushroomSpecies.getRecommendedConditions());
    }
}
