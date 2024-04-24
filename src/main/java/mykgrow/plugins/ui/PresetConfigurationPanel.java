package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.repositories.GrowingPresetRepository;
import org.bson.types.ObjectId;
import mykgrow.plugins.ui.UIComponents.FontSizes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresetConfigurationPanel implements BorderedScrollablePanelConsumer, GrowthPeriodEventListener {

    private BorderedScrollablePanel borderPanel;
    private BorderedScrollablePanel periodPanel;
    private JTextField nameField;
    private App app;
    private boolean editMode = false;

    private ObjectId id = null;

    private List<GrowthPeriod> growthPeriods = new ArrayList<GrowthPeriod>();

    PresetConfigurationPanel(App app){
        this.app = app;
        this.borderPanel = new BorderedScrollablePanel(app, "Preset Configuration", BorderedScrollablePanel.Layout.BOX);
        this.periodPanel = new BorderedScrollablePanel(app, "Growth Periods", BorderedScrollablePanel.Layout.GRID, false);
        fillContentPanel();
    }

    PresetConfigurationPanel(App app, GrowingPreset preset){
        this(app);
        this.growthPeriods = new ArrayList<>(preset.getGrowthPeriods());
        this.nameField.setText(preset.getName());
        this.editMode = true;
        this.id = preset.getId();
        updatePeriods();
    }

    private void fillContentPanel(){
        JPanel detailPanel = new JPanel(new GridLayout(0,2));

        JLabel nameLabel = new JLabel("Name:");
        this.nameField = UIComponents.createTextField(10, FontSizes.SMALL);

        detailPanel.add(nameLabel);
        detailPanel.add(this.nameField);

        JButton addGrowthPeriodButton = UIComponents.createButton("Add Growth Period", FontSizes.SMALL);
        JButton saveButton = UIComponents.createButton("Save", FontSizes.SMALL);

        addGrowthPeriodButton.addActionListener(e -> {
            addGrowthPeriod();
        });
        saveButton.addActionListener(e -> {
            savePreset();
        });

        this.borderPanel.getContentPanel().add(detailPanel);
        this.borderPanel.getContentPanel().add(this.periodPanel);
        this.borderPanel.getButtonPanel().add(addGrowthPeriodButton);
        this.borderPanel.getButtonPanel().add(saveButton);
    }

    private void savePreset(){
        GrowingPreset preset = new GrowingPreset(this.nameField.getText(), this.growthPeriods);
        this.growthPeriods = new ArrayList<>(this.growthPeriods);
        if(!editMode) {
            GrowingPresetRepository.INSTANCE.savePreset(preset);
            JOptionPane.showMessageDialog(this.borderPanel, "Preset saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else{
            GrowingPresetRepository.INSTANCE.updatePreset(this.id, preset);
            JOptionPane.showMessageDialog(this.borderPanel, "Preset updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        UiUtils.navigateHome(this.borderPanel, this.app);
    }
    private void addGrowthPeriod(){
        PeriodConfigurationWindow popup = new PeriodConfigurationWindow();
        popup.addListener(GrowthPeriodEvent.INSERT, this);
        popup.setVisible(true);
    }

    private void updatePeriods(){
        this.periodPanel.getContentPanel().removeAll();
        for (GrowthPeriod period : this.growthPeriods) {
            GrowthPeriodPanel growthPeriodPanel = new GrowthPeriodPanel(period, true, this);
            growthPeriodPanel.addListener(GrowthPeriodEvent.DELETE, this);
            this.periodPanel.getContentPanel().add(growthPeriodPanel);
        }
        this.periodPanel.getContentPanel().revalidate();
        this.periodPanel.getContentPanel().repaint();
    }
    @Override
    public BorderedScrollablePanel getPanel() {
        return this.borderPanel;
    }

    private void growthPeriodAdded(GrowthPeriod growthPeriod) {
        this.growthPeriods.add(growthPeriod);
        updatePeriods();
    }

    private void growthPeriodUpdated() {
        updatePeriods();
    }

    private void growthPeriodDeleted(GrowthPeriod growthPeriod) {
        this.growthPeriods.remove(growthPeriod);
        updatePeriods();
    }

    @Override
    public void update(GrowthPeriodEvent event, Object o) {
        switch (event){
            case UPDATE:
                growthPeriodUpdated();
                break;
            case INSERT:
                growthPeriodAdded((GrowthPeriod) o);
                break;
            default:
                growthPeriodDeleted((GrowthPeriod) o);
        }
    }
}
