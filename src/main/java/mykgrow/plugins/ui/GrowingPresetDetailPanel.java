package mykgrow.plugins.ui;

import mykgrow.application.SaveMushromPresetAsPresetService;
import mykgrow.application.interfaces.SaveMushromPresetAsPresetInterface;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;
import mykgrow.domain.repositories.GrowingPresetRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrowingPresetDetailPanel implements BorderedScrollablePanelConsumer{
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





