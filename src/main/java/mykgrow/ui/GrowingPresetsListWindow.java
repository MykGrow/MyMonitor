package mykgrow.ui;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.GrowingPresetRepository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GrowingPresetsListWindow extends JFrame {
    private final GrowingPresetRepository presetRepository;

    public GrowingPresetsListWindow(GrowingPresetRepository presetRepository) {
        this.presetRepository = presetRepository;

        setTitle("Preset List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the preset list
        JPanel panel = new JPanel(new GridLayout(0, 1));

        // Retrieve all presets from the repository
        List<GrowingPreset> presets = presetRepository.getGrowingPresets();

        // Add each preset to the panel
        for (GrowingPreset preset : presets) {
            JLabel label = new JLabel(preset.getName());
            panel.add(label);
        }

        // Add the panel to the frame
        getContentPane().add(panel);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Create a mock implementation of the repository for demonstration purposes
        GrowingPresetRepository presetRepository = new GrowingPresetRepository();
        presetRepository.savePreset(new GrowingPreset("Preset 1"));
        presetRepository.savePreset(new GrowingPreset("Preset 2"));
        presetRepository.savePreset(new GrowingPreset("Preset 3"));
        presetRepository.savePreset(new GrowingPreset("Preset 4"));

        // Create and display the PresetListWindow
        SwingUtilities.invokeLater(() -> {
            GrowingPresetsListWindow window = new GrowingPresetsListWindow(presetRepository);
            window.setVisible(true);
        });
    }
}
