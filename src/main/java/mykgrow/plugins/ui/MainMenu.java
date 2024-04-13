package mykgrow.plugins.ui;
import mykgrow.application.GrowingPresetConfigurationInterface;
import mykgrow.application.GrowingPresetConfigurationService;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.repositories.GrowingPresetRepositoryInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private final GrowingPresetRepositoryInterface presetRepository;
    private final GrowingPresetConfigurationInterface presetConfigurationService;

    public MainMenu(GrowingPresetConfigurationInterface presetConfigurationService) {
        this.presetRepository = presetConfigurationService.getGrowingPresetRepository();
        this.presetConfigurationService = presetConfigurationService;

        setTitle("Main Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        JButton createButton = UIComponents.createButton("Create New Pattern", 14);
        JButton showAllButton = UIComponents.createButton("Show All Patterns", 14);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPatternConfigurationWindow();
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPatternListWindow();
            }
        });

        panel.add(createButton);
        panel.add(showAllButton);
        add(panel);
    }

    private void openPatternConfigurationWindow() {
        GrowingPresetConfigurationWindow configurationWindow = new GrowingPresetConfigurationWindow(presetConfigurationService);
        configurationWindow.setVisible(true);
    }

    private void openPatternListWindow() {
        GrowingPresetsListWindow listWindow = new GrowingPresetsListWindow(presetRepository);
        listWindow.setVisible(true);
    }

    public static void main(String[] args) {
        GrowingPresetRepository patternRepository = new GrowingPresetRepository();
        GrowingPresetConfigurationService configurationService = new GrowingPresetConfigurationService(patternRepository);
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu(configurationService);
            mainMenu.setVisible(true);
        });
    }
}
