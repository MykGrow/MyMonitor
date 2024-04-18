package mykgrow.plugins.ui;

import mykgrow.application.PeriodConfigurationService;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.repositories.GrowingPresetRepository;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresetConfigurationPanel implements BorderedScrollablePanelConsumer, GrowthPeriodListener{

    private BorderedScrollablePanel borderPanel;
    private BorderedScrollablePanel periodPanel;
    private JTextField nameField;
    private App app;

    private List<GrowthPeriod> growthPeriods = new ArrayList<GrowthPeriod>();

    PresetConfigurationPanel(App app){
        this.app = app;
        this.borderPanel = new BorderedScrollablePanel(app, "Preset Configuration", BorderedScrollablePanel.Layout.BOX);
        this.periodPanel = new BorderedScrollablePanel(app, "Growth Periods", BorderedScrollablePanel.Layout.GRID, false);
        fillContentPanel();
    }

    private void fillContentPanel(){
        JPanel detailPanel = new JPanel(new GridLayout(0,2));

        JLabel nameLabel = new JLabel("Name:");
        this.nameField = UIComponents.createTextField(10, 12);

        detailPanel.add(nameLabel);
        detailPanel.add(this.nameField);

        JButton addGrowthPeriodButton = UIComponents.createButton("Add Growth Period", 12);
        JButton saveButton = UIComponents.createButton("Save", 12);

        addGrowthPeriodButton.addActionListener(e -> {
            addGrowthPeriod();
        });
        saveButton.addActionListener(e -> {
            savePreset();
        });

        this.borderPanel.getContentPanel().add(Box.createVerticalGlue());
        this.borderPanel.getContentPanel().add(detailPanel);
        this.borderPanel.getContentPanel().add(Box.createVerticalGlue());
        this.borderPanel.getContentPanel().add(this.periodPanel);
        this.borderPanel.getButtonPanel().add(addGrowthPeriodButton);
        this.borderPanel.getButtonPanel().add(saveButton);
    }

    private void savePreset(){
        GrowingPreset preset = new GrowingPreset(this.nameField.getText(), this.growthPeriods);
        GrowingPresetRepository.INSTANCE.savePreset(preset);
        JOptionPane.showMessageDialog(this.borderPanel, "Preset saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        UiUtils.navigateHome(this.borderPanel, this.app);
    }
    private void addGrowthPeriod(){
        PeriodConfigurationWindow popup = new PeriodConfigurationWindow();
        popup.addListener(this);
        popup.setVisible(true);
    }

    private void updatePeriods(){
        this.periodPanel.getContentPanel().removeAll();
        for (GrowthPeriod period : this.growthPeriods) {
            this.periodPanel.getContentPanel().add(new GrowthPeriodPanel(period));
        }
        this.periodPanel.getContentPanel().revalidate();
        this.periodPanel.getContentPanel().repaint();
    }
    @Override
    public BorderedScrollablePanel getPanel() {
        return this.borderPanel;
    }

    @Override
    public void growthPeriodAdded(GrowthPeriod growthPeriod) {
        this.growthPeriods.add(growthPeriod);
        updatePeriods();
    }
}
