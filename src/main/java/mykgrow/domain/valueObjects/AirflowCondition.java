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

    public double getAirExchangesPerHour() {
        return airExchangesPerHour;
    }
    public int getIntervalInMinutes() {
        return intervalInMinutes;
    }

}
