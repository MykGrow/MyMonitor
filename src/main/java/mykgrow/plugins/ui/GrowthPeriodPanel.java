package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowthPeriod;
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

        conditionsPanel.add(createConditionPanel("Description", growthPeriod.getDescription()));

        conditionsPanel.add(createConditionPanel("Airflow",
                "Air Exchanges per Hour", growthPeriod.getAirflowCondition().getAirExchangesPerHour(),
                "Interval", growthPeriod.getAirflowCondition().getIntervalInMinutes()));

        conditionsPanel.add(createConditionPanel("Light",
                "Light Level", growthPeriod.getLightCondition().getLightLevel(),
                "Start Time", formatTime(growthPeriod.getLightCondition().getStartTime()),
                "End Time", formatTime(growthPeriod.getLightCondition().getEndTime())));

        conditionsPanel.add(createConditionPanel("Humidity",
                "Lower Threshold", growthPeriod.getHumidityCondition().getLowerThreshold(),
                "Upper Threshold", growthPeriod.getHumidityCondition().getUpperThreshold()));

        conditionsPanel.add(createConditionPanel("Temperature",
                "Lower Threshold", growthPeriod.getTemperatureCondition().getLowerThreshold(),
                "Upper Threshold", growthPeriod.getTemperatureCondition().getUpperThreshold()));

        JScrollPane scrollPane = new JScrollPane(conditionsPanel);
        add(scrollPane, BorderLayout.CENTER);
    }


    private String formatTime(LocalTime time) {
        return String.format("%02d:%02d", time.getHour(), time.getMinute());
    }

    private JPanel createConditionPanel(String title, String label1, double value1, String label2, double value2) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel descriptionPanel = new JPanel(new GridLayout(0, 2));
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        addLabelValue(descriptionPanel, label1, String.valueOf(value1));
        addLabelValue(descriptionPanel, label2, String.valueOf(value2));

        panel.add(descriptionPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createConditionPanel(String title, String label1, double value1, String label2, String value2, String label3, String value3) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel descriptionPanel = new JPanel(new GridLayout(0, 2));
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        addLabelValue(descriptionPanel, label1, String.valueOf(value1));
        addLabelValue(descriptionPanel, label2, value2);
        addLabelValue(descriptionPanel, label3, value3);

        panel.add(descriptionPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createConditionPanel(String title, String value1){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel descriptionPanel = new JPanel(new GridLayout(0, 2));
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        addLabelValue(descriptionPanel, value1);

        panel.add(descriptionPanel, BorderLayout.CENTER);

        return panel;
    }

    private void addLabelValue(JPanel panel, String label, String value) {
        JLabel labelLabel = new JLabel(label + ": ");
        JLabel valueLabel = new JLabel(value);
        labelLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel.setForeground(Color.BLUE); // Highlight the numerical value
        panel.add(labelLabel);
        panel.add(valueLabel);
    }

    private void addLabelValue(JPanel panel, String value){
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(valueLabel);
    }
}

