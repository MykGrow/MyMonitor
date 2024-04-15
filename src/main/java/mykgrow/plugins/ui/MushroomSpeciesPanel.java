package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MushroomSpeciesPanel extends JPanel {

    public MushroomSpeciesPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE); // Set background color of the panel

        // Create dummy GrowthPeriods
        List<GrowthPeriod> growthPeriods1 = new ArrayList<>();
        growthPeriods1.add(new GrowthPeriod.GrowthPeriodBuilder("Period 1", "Description 1", 10)
                .withTemperatureCondition(new TemperatureCondition(20.0, 25.0))
                .withHumidityCondition(new HumidityCondition(50.0, 70.0))
                .withLightCondition(new LightCondition(100, LocalTime.of(9,0),LocalTime.of(18,0)))
                .withAirflowCondition(new AirflowCondition(0.3))
                .build());

        List<GrowthPeriod> growthPeriods2 = new ArrayList<>();
        growthPeriods2.add(new GrowthPeriod.GrowthPeriodBuilder("Period 1", "Description 1", 10)
                .withTemperatureCondition(new TemperatureCondition(20.0, 25.0))
                .withHumidityCondition(new HumidityCondition(43.0, 70.0))
                .withLightCondition(new LightCondition(100, LocalTime.of(10,0),LocalTime.of(14,0)))
                .withAirflowCondition(new AirflowCondition(0.3))
                .build());

        List<GrowthPeriod> growthPeriods3 = new ArrayList<>();
        growthPeriods3.add(new GrowthPeriod.GrowthPeriodBuilder("Period 1", "Description 1", 10)
                .withTemperatureCondition(new TemperatureCondition(20.0, 25.0))
                .withHumidityCondition(new HumidityCondition(51.0, 66.0))
                .withLightCondition(new LightCondition(100, LocalTime.of(11,0),LocalTime.of(12,0)))
                .withAirflowCondition(new AirflowCondition(0.3))
                .build());

// Create dummy GrowingPresets
        GrowingPreset preset1 = new GrowingPreset("Preset 1", growthPeriods1);
        GrowingPreset preset2 = new GrowingPreset("Preset 2", growthPeriods2);
        GrowingPreset preset3 = new GrowingPreset("Preset 3", growthPeriods3);

// Create dummy MushroomSpecies objects
        MushroomSpecies species1 = new MushroomSpecies("Species 1", "Description 1", preset1);
        MushroomSpecies species2 = new MushroomSpecies("Species 2", "Description 2", preset2);
        MushroomSpecies species3 = new MushroomSpecies("Species 3", "Description 3", preset3);

        List<MushroomSpecies> mushroomSpeciesList = List.of(species1, species2, species3);

        for (MushroomSpecies species : mushroomSpeciesList) {
            add(createMushroomSpeciesPanel(species));
            add(Box.createRigidArea(new Dimension(0, 10))); // Add space between mushroom species panels
        }

        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    private JPanel createMushroomSpeciesPanel(MushroomSpecies species) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add padding

        JLabel nameLabel = new JLabel(species.getName());
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel descriptionLabel = new JLabel(species.getDescription());
        descriptionLabel.setVerticalAlignment(SwingConstants.TOP);

        contentPanel.add(nameLabel);
        contentPanel.add(Box.createHorizontalStrut(10)); // Add some spacing between name and description
        contentPanel.add(descriptionLabel);

        panel.add(contentPanel, BorderLayout.WEST);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPresetInformation(species);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.LIGHT_GRAY); // Change background color on mouse hover
                contentPanel.setBackground(Color.LIGHT_GRAY); // Change background color of content panel
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.WHITE); // Reset background color on mouse exit
                contentPanel.setBackground(Color.WHITE); // Reset background color of content panel
            }
        });

        return panel;
    }



    private void showPresetInformation(MushroomSpecies species) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this); // Get the parent JFrame
        frame.getContentPane().removeAll(); // Remove all components from the frame
        frame.getContentPane().add(new GrowingPresetDetailScreen(species)); // Add the PresetDetailScreen
        frame.revalidate(); // Revalidate the frame to reflect the changes
        frame.repaint(); // Repaint the frame
    }

    public static void main(String[] args) {
    }
}

