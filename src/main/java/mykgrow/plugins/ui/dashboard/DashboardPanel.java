package mykgrow.plugins.ui.dashboard;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private JLabel[] desiredConditionLabels;

    public DashboardPanel() {
        initUI();
    }

    private void initUI(){
        setLayout(new GridLayout(0, 2));

        JPanel desiredConditionsPanel = new DesiredConditionsPanel();
        JPanel currentConditionsPanel = new CurrentConditionsPanel();

        add(desiredConditionsPanel);
        add(currentConditionsPanel);

    }
}
