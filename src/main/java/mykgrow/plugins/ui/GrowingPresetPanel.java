package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.GrowingPresetRepository;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GrowingPresetPanel extends JPanel {
    private List<GrowingPreset> growingPresets;

    private App app;
    public GrowingPresetPanel(App app) {
        this.app = app;
        initializeComponents();
        setupUI();
        displayGrowingPresets();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JButton addButton = new JButton("Add Preset");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPreset();
            }
        });
    }

    private void addPreset(){
        UiUtils.fullWindowView(this, new PresetConfigurationPanel(app).getPanel());
    }

    private void initializeComponents() {
        this.growingPresets = GrowingPresetRepository.INSTANCE.getGrowingPresetsAsList();
    }

    private void displayGrowingPresets() {
        ScrollablePanel contentPanel = new ScrollablePanel();
        for (GrowingPreset preset : growingPresets) {
            JPanel presetPanel = createPresetPanel(preset);
            contentPanel.add(presetPanel);
        }
        add(contentPanel.getPanel(), BorderLayout.CENTER);
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPresetInformation(preset);
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
    private void showPresetInformation(GrowingPreset preset){
        UiUtils.fullWindowView(this, new GrowingPresetDetailPanel(preset, app).getPanel());
    }

}
