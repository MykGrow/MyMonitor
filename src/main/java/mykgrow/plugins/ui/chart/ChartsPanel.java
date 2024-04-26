package mykgrow.plugins.ui.chart;

import javax.swing.*;
import java.awt.*;

public class ChartsPanel extends JPanel {
    public ChartsPanel() {
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(2,2));
        DataChart temperatureChart = new DataChart("Temperature", DataChart.Colors.BABY_PINK.getColor());
        DataChart humidityChart = new DataChart("Humidity", DataChart.Colors.BABY_PINK.getColor());
        DataChart lightIntensityChart = new DataChart("Light Intensity", DataChart.Colors.BABY_PINK.getColor());
        DataChart airFlowChart = new DataChart("Airflow", DataChart.Colors.BABY_PINK.getColor());

        add(temperatureChart);
        add(humidityChart);
        add(lightIntensityChart);
        add(airFlowChart);
    }
}
