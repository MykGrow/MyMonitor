package mykgrow.domain.enums;

public enum Condition {
    TEMPERATURE("Temperature"),
    HUMIDITY("Humidity"),
    LIGHT_INTENSITY("Light Intensity"),
    AIR_FLOW("Air Flow");

    private final String displayName;

    Condition(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
