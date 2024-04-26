package mykgrow.plugins.ui.preset;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.plugins.ui.*;
import mykgrow.plugins.ui.ui_utils.UiUtils;
import mykgrow.plugins.ui.wrapper_panels.BorderedScrollablePanel;
import mykgrow.plugins.ui.wrapper_panels.BorderedScrollablePanelConsumer;

import javax.swing.*;

public class GrowingPresetDetailPanel implements BorderedScrollablePanelConsumer {
    private App app;
    private GrowingPreset preset;
    private BorderedScrollablePanel borderPanel;

    public GrowingPresetDetailPanel(GrowingPreset preset, App app) {
        this.app = app;
        this.preset = preset;
        createUI();
    }

    private void createUI() {
        this.borderPanel = new BorderedScrollablePanel(app, preset.getName(), BorderedScrollablePanel.Layout.GRID);
        fillContentPanel();
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        this.borderPanel.getButtonPanel().add(editButton);
        this.borderPanel.getButtonPanel().add(deleteButton);
        editButton.addActionListener(e -> {
            editPreset();
        });
        deleteButton.addActionListener(e -> {
            deletePreset();
        });
    }

    private void editPreset() {
        PresetConfigurationPanel presetConfigurationPanel = new PresetConfigurationPanel(app);
        UiUtils.fullWindowView(this.borderPanel,new PresetConfigurationPanel(app, preset).getPanel());
    }

    private void deletePreset() {
        GrowingPresetRepository.INSTANCE.deletePreset(preset);
        JOptionPane.showMessageDialog(this.borderPanel, "Preset deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        UiUtils.navigateHome(this.borderPanel, this.app);
    }

    private void fillContentPanel() {
        for (GrowthPeriod growthPeriod : preset.getGrowthPeriods()) {
            this.borderPanel.getContentPanel().add(new GrowthPeriodPanel(growthPeriod));
        }
    }

    public BorderedScrollablePanel getPanel() {
        return this.borderPanel;
    }

}




