package mykgrow.plugins.ui;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import mykgrow.application.SaveMushromPresetAsPresetService;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.repositories.GrowingPresetRepository;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.plugins.database.DatabaseClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JPanel navPanel;

    public App() {
        super("CardLayout Example");
        initUI();
    }

    public void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1199, 650);

        cardPanel = new JPanel(new CardLayout());
        this.cardLayout = (CardLayout) cardPanel.getLayout();

        fillRepository();
        DashboardPanel dashboard = new DashboardPanel();
        ChartsPanel charts = new ChartsPanel();
        GrowingPresetPanel presetPanel = new GrowingPresetPanel(this);
        MushroomSpeciesPanel mushroomSpeciesPanel = new MushroomSpeciesPanel(this);

        cardPanel.add(dashboard, "Dashboard");
        cardPanel.add(charts, "Charts");
        cardPanel.add(presetPanel, "Growing Presets");
        cardPanel.add(mushroomSpeciesPanel, "Mushroom Species");
      
        navPanel = createNavBar();
        add(navPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
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
                cardLayout.show(cardPanel, cardName);
            }
        });
        // Set preferred size to increase button width
        button.setPreferredSize(new Dimension(150, 40));
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
            //button.setForeground(Color.WHITE);
            //button.setBackground(Color.DARK_GRAY);
            button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Adjust left and right padding
            // Add glue components to make buttons span the entire width
            navPanel.add(Box.createHorizontalGlue());
            navPanel.add(button);
        }
        navPanel.add(Box.createHorizontalGlue());

        return navPanel;
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
                app.setVisible(true);
            }
        });
    }
}
