package mykgrow.plugins.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresetPanel extends JPanel {
    private DefaultListModel<Preset> listModel;
    private JList<Preset> itemList;
    private App app;

    public PresetPanel(App app) {
        this.app = app;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // Create a panel for column headers
        JPanel headerPanel = new JPanel(new GridLayout(1, 5)); // Adjust the number of columns as needed

        // Add headers for each column
        JLabel nameLabel = new JLabel("Name");
        JLabel temperatureLabel = new JLabel("Target Temperature");
        JLabel humidityLabel = new JLabel("Target Humidity");
        JLabel faeLabel = new JLabel("FAE Rate");
        JLabel noOfPeriodsLabel = new JLabel("Number of Periods");


        // Add headers to the header panel
        headerPanel.add(nameLabel);
        headerPanel.add(temperatureLabel);
        headerPanel.add(humidityLabel);
        headerPanel.add(faeLabel);
        headerPanel.add(noOfPeriodsLabel);

        // Add the header panel to the top of the PresetPanel
        add(headerPanel, BorderLayout.NORTH);

        // Create a default list model
        listModel = new DefaultListModel<>();

        // Create a JList with the default list model
        itemList = new JList<>(listModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setCellRenderer(new ItemCellRenderer());

        // Add a scroll pane to the JList
        JScrollPane scrollPane = new JScrollPane(itemList);
        add(scrollPane, BorderLayout.CENTER);

        // Button to add new items
        JButton addButton = new JButton("Add Preset");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPreset();
            }
        });

        // Panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addPreset() {
        BorderedScrollablePanel test = new BorderedScrollablePanel(app, "Test");
        test.getContentPanel().add(new BorderedScrollablePanel(app, "Test2"));
        test.getContentPanel().add(new BorderedScrollablePanel(app, "Test3"));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this); // Get the parent JFrame
        frame.getContentPane().removeAll(); // Remove all components from the frame
        frame.getContentPane().add(test); // Add the PresetDetailScreen
        frame.revalidate(); // Revalidate the frame to reflect the changes
        frame.repaint(); // Repaint the frame
        // Add the item to the list model
        //listModel.addElement(preset);
    }

    // Custom list cell renderer to display item details
    private static class ItemCellRenderer extends JPanel implements ListCellRenderer<Preset> {
        private JLabel nameLabel;
        private JLabel temperatureLabel;
        private JLabel humidityLabel;
        private JLabel faeLabel;
        private JLabel numberOfPeriodsLabel;

        public ItemCellRenderer() {
            setLayout(new GridLayout(1, 5));
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            nameLabel = new JLabel();
            temperatureLabel = new JLabel();
            humidityLabel = new JLabel();
            faeLabel = new JLabel();
            faeLabel = new JLabel();
            numberOfPeriodsLabel = new JLabel();

            add(nameLabel);
            add(temperatureLabel);
            add(humidityLabel);
            add(faeLabel);
            add(numberOfPeriodsLabel);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Preset> list, Preset value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            nameLabel.setText(value.getName());
            temperatureLabel.setText(value.getHumidity());
            humidityLabel.setText(value.getTemperature());
            faeLabel.setText(value.getFae());
            numberOfPeriodsLabel.setText(value.getNumberOfPeriods());

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setOpaque(true);
            return this;
        }
    }

    // Item class representing a list item with multiple attributes
    private static class Preset {
        private String name;
        private String humidity;
        private String temperature;
        private String fae;
        private String numberOfPeriods;

        public Preset(String name, String humidity, String temperature, String fae, String numberOfPeriods) {
            this.name = name;
            this.humidity = humidity;
            this.temperature = temperature;
            this.fae = fae;
            this.numberOfPeriods = numberOfPeriods;
        }

        public String getName() {
            return name;
        }

        public String getHumidity() {
            return humidity;
        }

        public String getTemperature() {
            return temperature;
        }

        public String getFae() {
            return fae;
        }

        public String getNumberOfPeriods() {
            return numberOfPeriods;
        }
    }
}
