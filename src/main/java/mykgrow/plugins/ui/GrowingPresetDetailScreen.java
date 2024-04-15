package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;

import javax.swing.*;
import java.awt.*;

public class GrowingPresetDetailScreen extends JPanel {
    private MushroomSpecies species;

    public GrowingPresetDetailScreen(MushroomSpecies species) {
        this.species = species;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel(species.getName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        JTextArea descriptionArea = new JTextArea(species.getDescription());
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setPreferredSize(new Dimension(0, 80)); // Adjust the height as needed
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        add(descriptionScrollPane, BorderLayout.CENTER);

        GrowingPreset recommendedPreset = species.getRecommendedConditions();
        JPanel contentPanel = new JPanel(new GridLayout(0, 1));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        for (GrowthPeriod growthPeriod : recommendedPreset.getGrowthPeriods()) {
            GrowthPeriodPanel conditionsPanel = new GrowthPeriodPanel(growthPeriod);
            contentPanel.add(conditionsPanel);
        }

        JScrollPane contentScrollPane = new JScrollPane(contentPanel);
        add(contentScrollPane, BorderLayout.SOUTH);
    }
}




