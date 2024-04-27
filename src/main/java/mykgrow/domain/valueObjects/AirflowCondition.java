package mykgrow.domain.valueObjects;

import org.bson.codecs.pojo.annotations.BsonProperty;


public class AirflowCondition {
    //Cubic feet per minute will be calculated based on box size
    @BsonProperty("AirExchangesPerHour")
    private double airExchangesPerHour;
    //Probably change int
    @BsonProperty("IntervalInMinutes")
    private int intervalInMinutes;

    public AirflowCondition(double airExchangesPerHour) {
        this.airExchangesPerHour = airExchangesPerHour;
        this.intervalInMinutes = calculateIntervalInMinutes();
    }
    public AirflowCondition() {
        this.airExchangesPerHour = 0;
        this.intervalInMinutes = 0;
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

    public void setAirExchangesPerHour(double airExchangesPerHour) {
        this.airExchangesPerHour = airExchangesPerHour;
        this.intervalInMinutes = calculateIntervalInMinutes();
    }


}
