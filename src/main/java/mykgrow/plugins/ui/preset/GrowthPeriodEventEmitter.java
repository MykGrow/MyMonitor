package mykgrow.plugins.ui.preset;

public interface GrowthPeriodEventEmitter {
    void addListener(GrowthPeriodEvent event, GrowthPeriodEventListener listener);
    void removeListener(GrowthPeriodEvent event, GrowthPeriodEventListener listener);
    void notifyListeners(GrowthPeriodEvent event, Object o);
}
