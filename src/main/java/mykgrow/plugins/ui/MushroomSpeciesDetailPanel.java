package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MushroomSpeciesDetailPanel implements BorderedScrollablePanelConsumer{

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
        fillContentPanel();
    }

    private void fillContentPanel(){
        JPanel speciesPanel = new JPanel(new GridBagLayout());
        this.borderPanel.getContentPanel().add(createSpeciesPanel());
        this.borderPanel.getContentPanel().add(createRecommendedPresetPanel());
    }

    private JPanel createSpeciesPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        // Create components
        BufferedImage speciesPicture = null;
        try {
            speciesPicture = ImageIO.read(new File("src/main/resources/images/mush.jpg"));
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
    public BorderedScrollablePanel getPanel() {
        return this.borderPanel;
    }
}
