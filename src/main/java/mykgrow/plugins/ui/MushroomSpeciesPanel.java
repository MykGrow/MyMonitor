package mykgrow.plugins.ui;

import mykgrow.application.RandomDataGenerator;
import mykgrow.application.interfaces.SaveMushromPresetAsPresetInterface;
import mykgrow.domain.entities.MushroomSpecies;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MushroomSpeciesPanel extends JPanel {
    App app;
    SaveMushromPresetAsPresetInterface saveMushromPresetAsPresetService;
    public MushroomSpeciesPanel(App app, SaveMushromPresetAsPresetInterface saveMushromPresetAsPresetService) {
        this.app = app;
        this.saveMushromPresetAsPresetService = saveMushromPresetAsPresetService;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE); // Set background color of the panel

        // Create dummy GrowthPeriods
        List<MushroomSpecies> mushroomSpeciesList = RandomDataGenerator.generateRandomMushroomSpecies(5, 3);


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
        frame.getContentPane().add(new GrowingPresetDetailPanel(species, app, saveMushromPresetAsPresetService).getPanel()); // Add the PresetDetailScreen
        frame.revalidate(); // Revalidate the frame to reflect the changes
        frame.repaint(); // Repaint the frame
    }

    public static void main(String[] args) {
    }
}

