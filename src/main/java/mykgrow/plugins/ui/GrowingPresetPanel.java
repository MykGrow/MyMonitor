package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GrowingPresetPanel extends JPanel {
    private GrowingPresetRepositoryInterface growingPresetRepository;
    private List<GrowingPreset> growingPresets;

    public GrowingPresetPanel(GrowingPresetRepositoryInterface growingPresetRepository) {
        initializeComponents(growingPresetRepository);
        setupUI();
        displayGrowingPresets();
    }

    private void setupUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
    }

    private void initializeComponents(GrowingPresetRepositoryInterface growingPresetRepository) {
        this.growingPresetRepository = growingPresetRepository;
        this.growingPresets = growingPresetRepository.getGrowingPresets();
    }

    private void displayGrowingPresets() {
        for (GrowingPreset preset : growingPresets) {
            JPanel presetPanel = createPresetPanel(preset);
            add(presetPanel);
        }
    }

    private JPanel createPresetPanel(GrowingPreset preset) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel nameLabel = new JLabel("Name: " + preset.getName());

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.add(nameLabel, BorderLayout.NORTH);
        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }
}
