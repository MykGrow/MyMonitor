package mykgrow.domain.valueObjects;

public class AirflowCondition {
    //Cubic feet per minute will be calculated based on box size
    private final double airExchangesPerHour;
    //Probably change int
    private int intervalInMinutes;

    public AirflowCondition(double airExchangesPerHour) {
        this.airExchangesPerHour = airExchangesPerHour;
        this.intervalInMinutes = calculateIntervalInMinutes();
    }

    private int calculateIntervalInMinutes() {
        return (int) (60 / airExchangesPerHour);
    }

    private int getIntervalInMinutes() {
        return intervalInMinutes;
    }

}
