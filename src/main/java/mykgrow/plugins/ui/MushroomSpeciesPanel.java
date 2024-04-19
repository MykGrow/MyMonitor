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
    public MushroomSpeciesPanel(App app) {
        this.app = app;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setBackground(Color.WHITE); // Set background color of the panel
        ScrollablePanel scrollablePanel = new ScrollablePanel();

        // Create dummy GrowthPeriods
        List<MushroomSpecies> mushroomSpeciesList = RandomDataGenerator.generateRandomMushroomSpecies(5, 6);


        for (MushroomSpecies species : mushroomSpeciesList) {
            scrollablePanel.add(createMushroomSpeciesPanel(species));
            //scrollablePanel.add(Box.createRigidArea(new Dimension(0, 1))); // Add space between mushroom species panels
        }

        add(scrollablePanel.getPanel());
    }

    private JPanel createMushroomSpeciesPanel(MushroomSpecies species) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //contentPanel.setBackground(Color.WHITE);
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
                showSpeciesInformation(species);
            }
        });
        return panel;
    }

    private void showSpeciesInformation(MushroomSpecies species) {
        UiUtils.fullWindowView(this, new MushroomSpeciesDetailPanel(species, app).getPanel());
    }

    public static void main(String[] args) {
    }
}

