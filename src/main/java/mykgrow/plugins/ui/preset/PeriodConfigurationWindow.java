package mykgrow.plugins.ui.preset;

import mykgrow.Exceptions.ConditionNotSetException;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;
import mykgrow.plugins.ui.ui_utils.UIComponents;
import mykgrow.plugins.ui.ui_utils.UIComponents.FontSizes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

public class PeriodConfigurationWindow extends JFrame implements GrowthPeriodEventEmitter {
    private JTextField nameField;
    private JTextField durationField;
    private JTextField lowerTempField;
    private JTextField targetTempField;
    private JTextField lowerHumidityField;
    private JTextField targetHumidityField;
    private JTextField lightIntensityField;
    private JTextField airFlowField;
    private JTextField lightStartComboBox;
    private JTextField lightEndComboBox;

    private boolean editMode = false;
    private Map<GrowthPeriodEvent, List<GrowthPeriodEventListener>> listeners;

    private GrowthPeriod growthPeriod = null;

    public PeriodConfigurationWindow() {
        setupUI();
        initializeComponents();
        setLocationRelativeTo(null);
        listeners = new HashMap<>();
        Arrays.stream(GrowthPeriodEvent.values()).forEach(event -> {
            listeners.put(event, new ArrayList<>());
        });
    }

    PeriodConfigurationWindow(GrowthPeriod growthPeriod){
        this();
        this.editMode = true;
        this.growthPeriod = growthPeriod;
        nameField.setText(growthPeriod.getName());
        durationField.setText(String.valueOf(growthPeriod.getDurationInDays()));
        try {
            lowerTempField.setText(String.valueOf(growthPeriod.getTemperatureCondition().getLowerThreshold()));
        } catch (ConditionNotSetException e) {
;            lowerTempField.setText("0");
        }
        try {
            targetTempField.setText(String.valueOf(growthPeriod.getTemperatureCondition().getUpperThreshold()));
        } catch (ConditionNotSetException e) {
            targetTempField.setText("0");
        }
        try {
            lowerHumidityField.setText(String.valueOf(growthPeriod.getHumidityCondition().getLowerThreshold()));
        } catch (ConditionNotSetException e) {
            lowerHumidityField.setText("0");
        }
        try {
            targetHumidityField.setText(String.valueOf(growthPeriod.getHumidityCondition().getUpperThreshold()));
        } catch (ConditionNotSetException e) {
            targetHumidityField.setText("0");
        }
        try {
            lightIntensityField.setText(String.valueOf(growthPeriod.getLightCondition().getLightLevel()));
        } catch (ConditionNotSetException e) {
            lightIntensityField.setText("0");
        }
        try {
            airFlowField.setText(String.valueOf(growthPeriod.getAirflowCondition().getAirExchangesPerHour()));
        } catch (ConditionNotSetException e) {
            airFlowField.setText("0");
        }
        try {
            lightStartComboBox.setText(growthPeriod.getLightCondition().getStartTime().toString());
        } catch (ConditionNotSetException e) {
            lightStartComboBox.setText("00:00");
        }
        try {
            lightEndComboBox.setText(growthPeriod.getLightCondition().getEndTime().toString());
        } catch (ConditionNotSetException e) {
            lightEndComboBox.setText("00:00");
        }
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

    private void setupUI() {
        setTitle("Period Configuration");
        setSize(400, 300);
        setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel titleLabel = UIComponents.createLabel("Custom Period", FontSizes.MEDIUM, SwingConstants.CENTER);

        JLabel nameLabel = UIComponents.createLabel("Name:", FontSizes.MEDIUM, SwingConstants.LEFT);
        nameField = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel durationLabel = UIComponents.createLabel("Duration in Days:", FontSizes.MEDIUM, SwingConstants.LEFT);
        durationField = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel lowerTempLabel = UIComponents.createLabel("Lower Temperature Threshold:", FontSizes.MEDIUM, SwingConstants.LEFT);
        lowerTempField = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel targetTempLabel = UIComponents.createLabel("Target Temperature:", FontSizes.MEDIUM, SwingConstants.LEFT);
        targetTempField = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel lowerHumidityLabel = UIComponents.createLabel("Lower Humidity Threshold:", FontSizes.MEDIUM, SwingConstants.LEFT);
        lowerHumidityField = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel targetHumidityLabel = UIComponents.createLabel("Target Humidity:", FontSizes.MEDIUM, SwingConstants.LEFT);
        targetHumidityField = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel lightIntensityLabel = UIComponents.createLabel("Light Intensity:", FontSizes.MEDIUM, SwingConstants.LEFT);
        lightIntensityField = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel lightStartLabel = UIComponents.createLabel("Light Start Time:", FontSizes.MEDIUM, SwingConstants.LEFT);
        lightStartComboBox = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel lightEndLabel = UIComponents.createLabel("Light End Time:", FontSizes.MEDIUM, SwingConstants.LEFT);
        lightEndComboBox = UIComponents.createTextField(10, FontSizes.SMALL);

        JLabel airFlowLabel = UIComponents.createLabel("Airflow (Full Air Exchanges per hour):", FontSizes.MEDIUM, SwingConstants.LEFT);
        airFlowField = UIComponents.createTextField(10, FontSizes.SMALL);

        JButton saveButton = UIComponents.createButton("Save", FontSizes.MEDIUM);

        UIComponents.addComponent(panel, nameLabel);
        UIComponents.addComponent(panel, nameField);
        UIComponents.addComponent(panel, durationLabel);
        UIComponents.addComponent(panel, durationField);
        UIComponents.addComponent(panel, lowerTempLabel);
        UIComponents.addComponent(panel, lowerTempField);
        UIComponents.addComponent(panel, targetTempLabel);
        UIComponents.addComponent(panel, targetTempField);
        UIComponents.addComponent(panel, lowerHumidityLabel);
        UIComponents.addComponent(panel, lowerHumidityField);
        UIComponents.addComponent(panel, targetHumidityLabel);
        UIComponents.addComponent(panel, targetHumidityField);
        UIComponents.addComponent(panel, lightIntensityLabel);
        UIComponents.addComponent(panel, lightIntensityField);
        UIComponents.addComponent(panel, lightStartLabel);
        UIComponents.addComponent(panel, lightStartComboBox);
        UIComponents.addComponent(panel, lightEndLabel);
        UIComponents.addComponent(panel, lightEndComboBox);
        UIComponents.addComponent(panel, airFlowLabel);
        UIComponents.addComponent(panel, airFlowField);
        UIComponents.addComponent(panel, saveButton);

        getContentPane().add(panel, BorderLayout.CENTER);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePeriod();
            }
        });
    }

    private void savePeriod() {
        try {
            String name = nameField.getText();
            int duration = Integer.parseInt(durationField.getText());
            double lowerTemp = Double.parseDouble(lowerTempField.getText());
            double upperTemp = Double.parseDouble(targetTempField.getText());
            double lowerHumidity = Double.parseDouble(lowerHumidityField.getText());
            double upperHumidity = Double.parseDouble(targetHumidityField.getText());
            int lightIntensity = Integer.parseInt(lightIntensityField.getText());
            LocalTime lightStartTime = LocalTime.parse(lightStartComboBox.getText());
            LocalTime lightEndTime = LocalTime.parse(lightEndComboBox.getText());
            double airFlow = Double.parseDouble(airFlowField.getText());

            if (!editMode) {
                GrowthPeriod growthPeriod = new GrowthPeriod.GrowthPeriodBuilder(name,"test", duration).
                        withAirflowCondition(new AirflowCondition(airFlow)).
                        withLightCondition(new LightCondition(lightIntensity, lightStartTime, lightEndTime)).
                        withHumidityCondition(new HumidityCondition(lowerHumidity, upperHumidity)).
                        withTemperatureCondition(new TemperatureCondition(lowerTemp, upperTemp)).build();
                notifyListeners(GrowthPeriodEvent.INSERT, growthPeriod);
                JOptionPane.showMessageDialog(this, "Period saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else {
                this.growthPeriod.setName(name);
                this.growthPeriod.setDurationInDays(duration);
                this.growthPeriod.setAirflowCondition(new AirflowCondition(airFlow));
                this.growthPeriod.setLightCondition(new LightCondition(lightIntensity, lightStartTime, lightEndTime));
                this.growthPeriod.setHumidityCondition(new HumidityCondition(lowerHumidity, upperHumidity));
                this.growthPeriod.setTemperatureCondition(new TemperatureCondition(lowerTemp, upperTemp));
                notifyListeners(GrowthPeriodEvent.UPDATE, null);
            }
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input values", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
