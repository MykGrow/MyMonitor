package mykgrow.plugins.ui;

import mykgrow.application.SaveMushromPresetAsPresetService;
import mykgrow.application.interfaces.SaveMushromPresetAsPresetInterface;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.entities.MushroomSpecies;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrowingPresetDetailPanel extends JPanel {
    private MushroomSpecies species;
    private App app;

    private SaveMushromPresetAsPresetInterface saveMushromPresetAsPresetService;


    public GrowingPresetDetailPanel(MushroomSpecies species, App app, SaveMushromPresetAsPresetInterface saveMushromPresetAsPresetService) {
        this.species = species;
        this.app = app;
        this.saveMushromPresetAsPresetService = saveMushromPresetAsPresetService;

        initializeComponents();
        createUI();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private void createUI() {
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = createContentPanel();
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton saveButton = createSaveButton();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(species.getName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JButton backButton = createBackButton();
        headerPanel.add(backButton, BorderLayout.EAST); // Add the button to the left side

        return headerPanel;
    }

    private JButton createBackButton() {
        JButton backButton = new JButton("Home");
        backButton.addActionListener(e -> navigateToHome());
        return backButton;
    }

    private JButton createSaveButton() {
        JButton saveButton = new JButton("Save as Preset");
        saveButton.addActionListener(e -> saveAsPreset());
        return saveButton;
    }

    private void navigateToHome() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.getContentPane().removeAll();
            app.paintAll();
            frame.revalidate();
            frame.repaint();
        } else {
            System.err.println("Parent JFrame is null");
        }
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel presetsPanel = new JPanel(new GridLayout(0, 1));
        for (GrowthPeriod growthPeriod : species.getRecommendedConditions().getGrowthPeriods()) {
            presetsPanel.add(new GrowthPeriodPanel(growthPeriod));
        }
        contentPanel.add(presetsPanel, BorderLayout.CENTER);
        return contentPanel;
    }

    private void saveAsPreset() {
        saveMushromPresetAsPresetService.saveMushromPresetAsPreset(species);
    }
}





