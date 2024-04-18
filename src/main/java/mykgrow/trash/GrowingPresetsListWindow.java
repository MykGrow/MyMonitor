package mykgrow.trash;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;
import mykgrow.domain.valueObjects.AirflowCondition;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GrowingPresetsListWindow extends JFrame {
    private final GrowingPresetRepositoryInterface presetRepository;

    public GrowingPresetsListWindow(GrowingPresetRepositoryInterface presetRepository) {
        this.presetRepository = presetRepository;

        setTitle("Preset List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the preset list
        JPanel panel = new JPanel(new GridLayout(2, 1));

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

        GrowthPeriod growthPeriod1 = new GrowthPeriod.GrowthPeriodBuilder("Growth Period 1", "First growth period", 10)
                .withAirflowCondition(new AirflowCondition(1)).build();
        GrowthPeriod growthPeriod2 = new GrowthPeriod.GrowthPeriodBuilder("Growth Period 2", "Second growth period", 20)
                .withAirflowCondition(new AirflowCondition(2)).build();
        GrowingPreset preset1 = new GrowingPreset("Preset 1", List.of(growthPeriod1, growthPeriod2));
        GrowingPreset preset2 = new GrowingPreset("Preset 2", List.of(growthPeriod1, growthPeriod2));

        GrowingPresetRepository.INSTANCE.savePreset(preset1);
        GrowingPresetRepository.INSTANCE.savePreset(preset2);
        // Create a mock implementation of the repository for demonstration purposes
        // Create and display the PresetListWindow
        SwingUtilities.invokeLater(() -> {
            GrowingPresetsListWindow window = new GrowingPresetsListWindow(GrowingPresetRepository.INSTANCE);
            window.setVisible(true);
        });
    }
}
