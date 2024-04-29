package mykgrow.plugins.ui.species;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.plugins.ui.App;
import mykgrow.plugins.ui.wrapper_panels.BorderedScrollablePanel;
import mykgrow.plugins.ui.wrapper_panels.BorderedScrollablePanelConsumer;
import mykgrow.plugins.ui.preset.GrowthPeriodPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MushroomSpeciesDetailPanel implements BorderedScrollablePanelConsumer {

    private BorderedScrollablePanel borderPanel;
    private App app;
    private MushroomSpecies species;

    MushroomSpeciesDetailPanel(MushroomSpecies species, App app){
        this.app = app;
        this.species = species;
        createUI();
    }

    private void createUI(){
        this.borderPanel = new BorderedScrollablePanel(this.app, this.species.getName(), BorderedScrollablePanel.Layout.BOX);
        JButton savePresetButton = new JButton("Save Preset");
        this.borderPanel.getButtonPanel().add(savePresetButton);

        savePresetButton.addActionListener(e -> {
            savePreset();
        });

        fillContentPanel();
    }

    private void savePreset(){
        String name = JOptionPane.showInputDialog(this.borderPanel, "Preset name:");
        GrowingPreset preset = this.species.getRecommendedConditions();
        preset.setName(name);
        try{if(name.isEmpty()){
            JOptionPane.showMessageDialog(this.borderPanel.getPanel(), "Preset name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }}catch (NullPointerException e){return;}
        GrowingPresetRepository.INSTANCE.savePreset(preset);
        JOptionPane.showMessageDialog(this.borderPanel.getPanel(), "Preset saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void fillContentPanel(){
        JPanel speciesPanel = new JPanel(new GridBagLayout());
        this.borderPanel.getContentPanel().add(createSpeciesPanel());
        this.borderPanel.getContentPanel().add(createRecommendedPresetPanel().getPanel());
    }
    private JPanel createSpeciesPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        // Create components
        BufferedImage speciesPicture = null;
        try {
            speciesPicture = ImageIO.read(new File("src/main/java/mykgrow/resources/images/ostreatus.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel speciesPictureLabel = new JLabel(new ImageIcon( new ImageIcon(speciesPicture).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        JPanel descriptionPanel = new JPanel(new GridLayout(0, 1));
        JLabel nameLabel = new JLabel(this.species.getName());
        JLabel descriptionLabel = new JLabel(this.species.getDescription());
        descriptionPanel.add(nameLabel);
        descriptionPanel.add(descriptionLabel);

        // Add components to the panel with GridBagConstraints
        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.ipadx = 15; // Add padding
        gbcLeft.anchor = GridBagConstraints.NORTHWEST; // Align to the left
        panel.add(speciesPictureLabel, gbcLeft);

        GridBagConstraints gbcRight = new GridBagConstraints();
        gbcRight.gridx = 1;
        gbcRight.gridy = 0;
        gbcRight.weightx = 1; // Take up remaining space
        gbcRight.anchor = GridBagConstraints.NORTHWEST; // Align to the left
        gbcRight.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        panel.add(descriptionPanel, gbcRight);
        return panel;
    }
    private BorderedScrollablePanel createRecommendedPresetPanel(){
        BorderedScrollablePanel presetPanel = new BorderedScrollablePanel(this.app, "Recommended Preset", BorderedScrollablePanel.Layout.GRID, false);
        for (GrowthPeriod growthPeriod : species.getRecommendedConditions().getGrowthPeriods()){
            presetPanel.getContentPanel().add(new GrowthPeriodPanel(growthPeriod));
        }
        return presetPanel;
    }

    @Override
    public BorderedScrollablePanel getBorderedPanel() {
        return this.borderPanel;
    }
}
