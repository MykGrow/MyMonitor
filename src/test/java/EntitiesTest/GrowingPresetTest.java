package EntitiesTest;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import org.easymock.EasyMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrowingPresetTest {
    public GrowingPresetTest() {
    }

    @Test
    @DisplayName("Test getName Method")
    public void testGetName() {
        GrowingPreset growingPreset = new GrowingPreset("name", new ArrayList<GrowthPeriod>());
        assertEquals("name", growingPreset.getName());
    }

    @Test
    @DisplayName("Test setName Method")
    public void testSetName() {
        GrowingPreset growingPreset = new GrowingPreset("name", new ArrayList<GrowthPeriod>());
        growingPreset.setName("newName");
        assertEquals("newName", growingPreset.getName());
    }

    @Test
    @DisplayName("Test getGrowthPeriods Method")
    public void testGetGrowthPeriods() {
        GrowthPeriod mockGrowthPeriod1 = EasyMock.createMock(GrowthPeriod.class);
        GrowthPeriod mockGrowthPeriod2 = EasyMock.createMock(GrowthPeriod.class);
        GrowthPeriod mockGrowthPeriod3 = EasyMock.createMock(GrowthPeriod.class);

        EasyMock.replay(mockGrowthPeriod1, mockGrowthPeriod2, mockGrowthPeriod3);


        List<GrowthPeriod> mockGrowthPeriods = Arrays.asList(
                mockGrowthPeriod1,
                mockGrowthPeriod2,
                mockGrowthPeriod3
        );

        GrowingPreset growingPreset = new GrowingPreset("Test Preset", mockGrowthPeriods);
        assertEquals(mockGrowthPeriods, growingPreset.getGrowthPeriods());

        EasyMock.verify(mockGrowthPeriod1, mockGrowthPeriod2, mockGrowthPeriod3);
    }

}
