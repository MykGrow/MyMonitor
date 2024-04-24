package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowthPeriod;

public interface GrowthPeriodEventListener {
    void update(GrowthPeriodEvent event, Object o);
}
