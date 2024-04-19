package EntitieTest;

import mykgrow.domain.entities.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConditionTest {
    private Condition condition;


    @BeforeEach
    public void setUp() {
        condition = new Condition("Temperature", 25.0, "°C");
    }

    @Test
    @DisplayName("Test Getter for Value")
    public void testGetValue() {
        assertEquals(25.0, condition.getValue(), 0.01);
    }

    @Test
    @DisplayName("Test Getter for Name")
    public void testGetName() {
        assertEquals("Temperature", condition.getName());
    }

    @Test
    @DisplayName("Test Setter for Value")
    public void testSetValue() {
        condition.setValue(30.0);
        assertEquals(30.0, condition.getValue(), 0.01);
    }

    @Test
    @DisplayName("Test toString Method")
    public void testToString() {
        assertEquals("Temperature: 25.0 °C", condition.toString());
    }
}
