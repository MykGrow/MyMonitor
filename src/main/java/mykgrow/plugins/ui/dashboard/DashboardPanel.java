package mykgrow.plugins.ui.dashboard;

import mykgrow.plugins.ui.PanelHost;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel implements PanelHost {
    private JLabel[] desiredConditionLabels;

    private JPanel panel;

    public DashboardPanel() {
        this.panel = new JPanel();
        initUI();
    }

    private void initUI(){
        this.panel.setLayout(new GridLayout(0, 2));

        JPanel desiredConditionsPanel = new DesiredConditionsPanel().getPanel();
        JPanel currentConditionsPanel = new CurrentConditionsPanel().getPanel();

        this.panel.add(desiredConditionsPanel);
        this.panel.add(currentConditionsPanel);

    }
    @Override
    public JPanel getPanel() {
        return this.panel;
    }
}
