package mykgrow.plugins.ui.chart;

import mykgrow.plugins.ui.PanelHost;

import javax.swing.*;
import java.awt.*;

public class ChartsPanel implements PanelHost {

    private JPanel panel;
    public ChartsPanel() {
        this.panel = new JPanel();
        initUI();
    }

    private void initUI() {
        this.panel.setLayout(new GridLayout(2,2));
        DataChart temperatureChart = new DataChart("Temperature", DataChart.Colors.BABY_PINK.getColor());
        DataChart humidityChart = new DataChart("Humidity", DataChart.Colors.BABY_PINK.getColor());
        DataChart lightIntensityChart = new DataChart("Light Intensity", DataChart.Colors.BABY_PINK.getColor());
        DataChart airFlowChart = new DataChart("Airflow", DataChart.Colors.BABY_PINK.getColor());

        this.panel.add(temperatureChart.getPanel());
        this.panel.add(humidityChart.getPanel());
        this.panel.add(lightIntensityChart.getPanel());
        this.panel.add(airFlowChart.getPanel());
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
