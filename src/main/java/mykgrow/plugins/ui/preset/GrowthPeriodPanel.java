package mykgrow.plugins.ui.preset;

import mykgrow.exceptions.ConditionNotSetException;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.plugins.ui.PanelHost;

import javax.swing.*;
import java.awt.*;

import java.time.LocalTime;
import java.util.*;
import java.util.List;

public class GrowthPeriodPanel implements GrowthPeriodEventEmitter, PanelHost {
    private GrowthPeriod growthPeriod;
    private JPanel headerPanel;
    private boolean editMode = false;

    private JPanel panel;

    private Map<GrowthPeriodEvent, List<GrowthPeriodEventListener>> listeners;

    public GrowthPeriodPanel(GrowthPeriod growthPeriod) {
        this.panel = new JPanel();
        this.growthPeriod = growthPeriod;
        this.headerPanel = new JPanel(new BorderLayout());
        this.listeners = new HashMap<>();
        Arrays.stream(GrowthPeriodEvent.values()).forEach(event -> {
            this.listeners.put(event, new ArrayList<>());
        });
        //this.headerPanel.setBackground(Color.WHITE);
        this.panel.setLayout(new BorderLayout());
        //setBackground(Color.WHITE);
        this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel(growthPeriod.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(nameLabel, BorderLayout.WEST);
        this.panel.add(headerPanel, BorderLayout.NORTH);

        JPanel conditionsPanel = new JPanel();
        conditionsPanel.setLayout(new GridLayout(0, 1));

        conditionsPanel.add(createConditionPanel("Description", growthPeriod.getDescription()));
        try {
            conditionsPanel.add(createConditionPanel("Airflow",
                    "Air Exchanges per Hour", growthPeriod.getAirflowCondition().getAirExchangesPerHour(),
                    "Interval", growthPeriod.getAirflowCondition().getIntervalInMinutes()));
        }catch (ConditionNotSetException e) {
            conditionsPanel.add(createConditionPanel("Airflow",
                    "Air Exchanges per Hour", 0,
                    "Interval", 0));
        }
        try {
            conditionsPanel.add(createConditionPanel("Light",
                    "Light Level", growthPeriod.getLightCondition().getLightLevel(),
                    "Start Time", formatTime(growthPeriod.getLightCondition().getStartTime()),
                    "End Time", formatTime(growthPeriod.getLightCondition().getEndTime())));
        } catch (ConditionNotSetException e) {
            conditionsPanel.add(createConditionPanel("Light",
                    "Light Level", 0,
                    "Start Time", "00:00",
                    "End Time", "00:00"));
        }
        try {
            conditionsPanel.add(createConditionPanel("Humidity",
                    "Lower Threshold", growthPeriod.getHumidityCondition().getLowerThreshold(),
                    "Upper Threshold", growthPeriod.getHumidityCondition().getUpperThreshold()));
        } catch (ConditionNotSetException e) {
            conditionsPanel.add(createConditionPanel("Humidity",
                    "Lower Threshold", 0,
                    "Upper Threshold", 0));
        }
        try {
            conditionsPanel.add(createConditionPanel("Temperature",
                    "Lower Threshold", growthPeriod.getTemperatureCondition().getLowerThreshold(),
                    "Upper Threshold", growthPeriod.getTemperatureCondition().getUpperThreshold()));
        } catch (ConditionNotSetException e) {
            conditionsPanel.add(createConditionPanel("Temperature",
                    "Lower Threshold", 0,
                    "Upper Threshold", 0));
        }
        JScrollPane scrollPane = new JScrollPane(conditionsPanel);
        this.panel.add(scrollPane, BorderLayout.CENTER);
    }

    public GrowthPeriodPanel(GrowthPeriod growthPeriod, boolean editMode, PresetConfigurationPanel presetConfigurationPanel){
        this(growthPeriod);
        this.editMode = editMode;
        if (editMode) {
            JPanel buttonPanel = new JPanel(new BorderLayout());
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");
            editButton.addActionListener(e -> {
                PeriodConfigurationWindow popup = new PeriodConfigurationWindow(growthPeriod);
                popup.addListener(GrowthPeriodEvent.UPDATE, presetConfigurationPanel);
                popup.getFrame().setVisible(true);
            });
            deleteButton.addActionListener(e -> {
                deleteGrowthPeriod();
            });
            buttonPanel.add(deleteButton, BorderLayout.EAST);
            buttonPanel.add(editButton, BorderLayout.WEST);
            this.headerPanel.add(buttonPanel, BorderLayout.EAST);
        }
    }
    private void deleteGrowthPeriod() {
        notifyListeners(GrowthPeriodEvent.DELETE, this.growthPeriod);
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
        //valueLabel.setForeground(Color.BLUE); // Highlight the numerical value
        panel.add(labelLabel);
        panel.add(valueLabel);
    }

    private void addLabelValue(JPanel panel, String value){
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(valueLabel);
    }

    @Override
    public void addListener(GrowthPeriodEvent event, GrowthPeriodEventListener listener){
        this.listeners.get(event).add(listener);
    }

    @Override
    public void removeListener(GrowthPeriodEvent event, GrowthPeriodEventListener listener) {
        this.listeners.get(event).remove(listener);
    }

    @Override
    public void notifyListeners(GrowthPeriodEvent event, Object o) {
        listeners.get(event).forEach(listener->{
            listener.update(event,o);
        });
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }
}

