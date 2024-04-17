package mykgrow.plugins.ui;

import mykgrow.application.SaveMushromPresetAsPresetService;
import mykgrow.application.interfaces.SaveMushromPresetAsPresetInterface;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrowingPresetDetailPanel extends JPanel {
    private MushroomSpecies species;
    private App app;

    private BorderedScrollablePanel borderPanel;

    private SaveMushromPresetAsPresetInterface saveMushromPresetAsPresetService;


    public GrowingPresetDetailPanel(MushroomSpecies species, App app, SaveMushromPresetAsPresetInterface saveMushromPresetAsPresetService) {
        this.species = species;
        this.app = app;
        this.saveMushromPresetAsPresetService = saveMushromPresetAsPresetService;

        createUI();
    }

    private void createUI() {
        this.borderPanel = new BorderedScrollablePanel(app, species.getName());

        JButton saveButton = createSaveButton();
        this.borderPanel.getButtonPanel().add(saveButton);
        fillContentPanel();
    }


    private JButton createSaveButton() {
        JButton saveButton = new JButton("Save as Preset");
        saveButton.addActionListener(e -> saveAsPreset());
        return saveButton;
    }

    private void fillContentPanel() {
        for (GrowthPeriod growthPeriod : species.getRecommendedConditions().getGrowthPeriods()) {
            this.borderPanel.getContentPanel().add(new GrowthPeriodPanel(growthPeriod));
        }
    }

    public JPanel getPanel() {
        return this.borderPanel;
    }

    private void saveAsPreset() {
        saveMushromPresetAsPresetService.saveMushromPresetAsPreset(species);
    }

}





