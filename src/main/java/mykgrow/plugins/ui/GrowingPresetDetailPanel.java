package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;

import javax.swing.*;
import java.awt.*;

public class GrowingPresetDetailPanel extends JPanel {
    private MushroomSpecies species;

    public GrowingPresetDetailPanel(MushroomSpecies species) {
        this.species = species;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel(species.getName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel presetsPanel = new JPanel(new GridLayout(0, 1));
        for (GrowthPeriod growthPeriod : species.getRecommendedConditions().getGrowthPeriods()) {
            presetsPanel.add(new GrowthPeriodPanel(growthPeriod));
        }

        contentPanel.add(presetsPanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane, BorderLayout.CENTER);
    }
}



