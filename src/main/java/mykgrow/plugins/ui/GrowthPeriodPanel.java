package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;

import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class GrowthPeriodPanel extends JPanel {
    private GrowthPeriod growthPeriod;

    public GrowthPeriodPanel(GrowthPeriod growthPeriod) {
        this.growthPeriod = growthPeriod;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel(growthPeriod.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(nameLabel, BorderLayout.NORTH);

        JPanel conditionsPanel = new JPanel();
        conditionsPanel.setLayout(new GridLayout(0, 1));
        conditionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        conditionsPanel.add(createConditionPanel("Airflow", "Air Exchanges per Hour: " + growthPeriod.getAirflowCondition().getAirExchangesPerHour() +
                " (Interval: " + growthPeriod.getAirflowCondition().getIntervalInMinutes() + " minutes)"));

        conditionsPanel.add(createConditionPanel("Light", "Light Level: " + growthPeriod.getLightCondition().getLightLevel() +
                " (Start Time: " + growthPeriod.getLightCondition().getStartTime() +
                ", End Time: " + growthPeriod.getLightCondition().getEndTime() + ")"));

        conditionsPanel.add(createConditionPanel("Humidity", "Lower Threshold: " + growthPeriod.getHumidityCondition().getLowerThreshold() +
                ", Upper Threshold: " + growthPeriod.getHumidityCondition().getUpperThreshold()));

        conditionsPanel.add(createConditionPanel("Temperature", "Lower Threshold: " + growthPeriod.getTemperatureCondition().getLowerThreshold() +
                ", Upper Threshold: " + growthPeriod.getTemperatureCondition().getUpperThreshold()));

        JScrollPane scrollPane = new JScrollPane(conditionsPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createConditionPanel(String title, String description) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Increased font size
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea descriptionArea = new JTextArea(description);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Increased font size
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        panel.add(descriptionArea, BorderLayout.CENTER);

        return panel;
    }

}

