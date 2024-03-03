package mykgrow.domain.entities;
public class Setting {

    private final String parameter;
    private final double targetValue;

    public Setting(String parameter, double targetValue) {
        this.parameter = parameter;
        this.targetValue = targetValue;
    }

    public String getParameter() {
        return parameter;
    }

    public double getTargetValue() {
        return targetValue;
    }
}