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
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("C:\\Users\\Maciej\\Desktop\\MykGrow\\MyMonitor\\src\\main\\java\\mykgrow\\resources\\images\\ostreatus.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel picLabel = new JLabel(new ImageIcon( new ImageIcon(myPicture).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        JPanel descriptionPanel = new JPanel(new GridLayout(0, 1));
        JLabel nameLabel = new JLabel(this.species.getName());
        JLabel descriptionLabel = new JLabel(this.species.getDescription());
        descriptionPanel.add(nameLabel);
        descriptionPanel.add(descriptionLabel);

        // Add components to the panel with GridBagConstraints
        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.weightx = 0.25; // 25% width
        gbcLeft.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        panel.add(picLabel, gbcLeft);

        GridBagConstraints gbcRight = new GridBagConstraints();
        gbcRight.gridx = 1;
        gbcRight.gridy = 0;
        gbcRight.weightx = 0.75; // 75% width
        gbcRight.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        panel.add(descriptionPanel, gbcRight);
        return panel;
    }
    private BorderedScrollablePanel createRecommendedPresetPanel(){
        BorderedScrollablePanel presetPanel = new BorderedScrollablePanel(this.app, "Recommended Preset", BorderedScrollablePanel.Layout.GRID);
        for (GrowthPeriod growthPeriod : species.getRecommendedConditions().getGrowthPeriods()){
            presetPanel.getContentPanel().add(new GrowthPeriodPanel(growthPeriod));
        }


        return presetPanel;
    }

    @Override
    public JPanel getPanel() {
        return this.borderPanel;
    }
}
