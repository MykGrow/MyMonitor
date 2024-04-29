package mykgrow.plugins.ui;

import com.formdev.flatlaf.*;
import mykgrow.application.SaveMushromPresetAsPresetService;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.plugins.database.DatabaseClient;
import mykgrow.plugins.ui.chart.ChartsPanel;
import mykgrow.plugins.ui.dashboard.DashboardPanel;
import mykgrow.plugins.ui.preset.GrowingPresetPanel;
import mykgrow.plugins.ui.species.MushroomSpeciesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App{
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JPanel navPanel;

    private JFrame frame;

    public App() {
        this.frame = new JFrame("MyMonitor");
        initUI();
    }

    public void initUI() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(1200, 650);

        cardPanel = new JPanel(new CardLayout());
        this.cardLayout = (CardLayout) cardPanel.getLayout();

        fillRepository();
        DashboardPanel dashboard = new DashboardPanel();
        ChartsPanel charts = new ChartsPanel();
        GrowingPresetPanel presetPanel = new GrowingPresetPanel(this);
        MushroomSpeciesPanel mushroomSpeciesPanel = new MushroomSpeciesPanel(this);

        cardPanel.add(dashboard.getPanel(), "Dashboard");
        cardPanel.add(charts.getPanel(), "Charts");
        cardPanel.add(presetPanel.getPanel(), "Growing Presets");
        cardPanel.add(mushroomSpeciesPanel.getPanel(), "Mushroom Species");
      
        navPanel = createNavBar();

        this.frame.add(navPanel, BorderLayout.NORTH);
        this.frame.add(cardPanel, BorderLayout.CENTER);

    }
  
  public void fillRepository(){
        List<GrowthPeriod> growthPeriods = new ArrayList<>();
        growthPeriods.add(new GrowthPeriod.GrowthPeriodBuilder("test", "test",10).
                withAirflowCondition(new AirflowCondition(1)).build());
  }


    private JButton createNavButton(String cardName) {
        JButton button = new JButton(cardName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(cardName);
            }
        });
        // Set preferred size to increase button width
        button.setPreferredSize(new Dimension(400, 60));
        return button;
    }

    private JPanel createNavBar() {
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.X_AXIS)); // Use BoxLayout with X_AXIS alignment
        //navPanel.setBackground(Color.DARK_GRAY); // Set background color

        // Create navigation buttons
        JButton dashboardButton = createNavButton("Dashboard");
        JButton chartsButton = createNavButton("Charts");
        JButton growingPresetButton = createNavButton("Growing Presets");
        JButton mushroomSpeciesButton = createNavButton("Mushroom Species");

        // Configure buttons
        for (JButton button : new JButton[]{dashboardButton, chartsButton, growingPresetButton, mushroomSpeciesButton}) {
            button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adjust left and right padding
            navPanel.add(Box.createHorizontalGlue());
            navPanel.add(button);
        }
        navPanel.add(Box.createHorizontalGlue());

        return navPanel;
    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                SaveMushromPresetAsPresetService saveMushromPresetAsPresetService = new SaveMushromPresetAsPresetService();
                DatabaseClient mappingPOJO = new DatabaseClient("MykGrow", "Presets", "mongodb+srv://mykgrow:mykgrow@cluster0.ljmudqt.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
                GrowingPresetRepository.INSTANCE.initialize(mappingPOJO);
                App app = new App();
                app.getFrame().setVisible(true);
            }
        });
    }
}
