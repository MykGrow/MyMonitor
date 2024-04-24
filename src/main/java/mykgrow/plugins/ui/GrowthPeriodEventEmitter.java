package mykgrow.plugins.ui;

public interface GrowthPeriodEventEmitter {
    void addListener(GrowthPeriodEventListener listener);

    void removeListener(GrowthPeriodEventListener listener);

    void notifyListeners(GrowthPeriodEvent event, Object o);
}
