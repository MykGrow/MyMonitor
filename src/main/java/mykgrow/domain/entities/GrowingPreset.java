package mykgrow.domain.entities;

import mykgrow.domain.enums.Condition;

import java.util.HashMap;
import java.util.Map;

public class PresetGrowing {
    private String name;
    private Map<Condition, Double> conditions;

    public PresetGrowing(String name) {
        this.name = name;
        this.conditions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Condition, Double> getConditions() {
        return conditions;
    }

    public void setConditions(Map<Condition, Double> conditions) {
        this.conditions = conditions;
    }

    public void addCondition(Condition condition, double value) {
        conditions.put(condition, value);
    }

    public void removeCondition(Condition condition) {
        conditions.remove(condition);
    }

}
