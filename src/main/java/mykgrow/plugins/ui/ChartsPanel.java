package mykgrow.plugins.ui;

import javax.swing.*;
import java.awt.*;

public class ChartsPanel extends JPanel {
    public ChartsPanel() {
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(2,2));
        DataChart temperatureChart = new DataChart("Temperature");
        DataChart humidityChart = new DataChart("Humidity");
        DataChart lightIntensityChart = new DataChart("Light Intensity");
        DataChart airFlowChart = new DataChart("Airflow");



        add(temperatureChart);
        add(humidityChart);
        add(lightIntensityChart);
        add(airFlowChart);
    }
}
