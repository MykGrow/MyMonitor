package mykgrow.plugins.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresetPanel extends JPanel {
    private DefaultListModel<Item> listModel;
    private JList<Item> itemList;

    public PresetPanel() {
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
        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        // Panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addItem() {
        // Prompt user for item details (you can use dialogs or text fields)
        String name = JOptionPane.showInputDialog(this, "Enter Name:");
        String attr1 = JOptionPane.showInputDialog(this, "Enter Attribute 1:");
        String attr2 = JOptionPane.showInputDialog(this, "Enter Attribute 2:");
        String attr3 = JOptionPane.showInputDialog(this, "Enter Attribute 3:");
        String attr4 = JOptionPane.showInputDialog(this, "Enter Attribute 4:");

        // Create a new item
        Item item = new Item(name, attr1, attr2, attr3, attr4);

        // Add the item to the list model
        listModel.addElement(item);
    }

    // Custom list cell renderer to display item details
    private static class ItemCellRenderer extends JPanel implements ListCellRenderer<Item> {
        private JLabel nameLabel;
        private JLabel attr1Label;
        private JLabel attr2Label;
        private JLabel attr3Label;
        private JLabel attr4Label;

        public ItemCellRenderer() {
            setLayout(new GridLayout(1, 5));
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            nameLabel = new JLabel();
            attr1Label = new JLabel();
            attr2Label = new JLabel();
            attr3Label = new JLabel();
            attr3Label = new JLabel();
            attr4Label = new JLabel();

            add(nameLabel);
            add(attr1Label);
            add(attr2Label);
            add(attr3Label);
            add(attr4Label);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            nameLabel.setText(value.getName());
            attr1Label.setText(value.getAttr1());
            attr2Label.setText(value.getAttr2());
            attr3Label.setText(value.getAttr3());
            attr4Label.setText(value.getAttr4());

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
    private static class Item {
        private String name;
        private String attr1;
        private String attr2;
        private String attr3;
        private String attr4;

        public Item(String name, String attr1, String attr2, String attr3, String attr4) {
            this.name = name;
            this.attr1 = attr1;
            this.attr2 = attr2;
            this.attr3 = attr3;
            this.attr4 = attr4;
        }

        public String getName() {
            return name;
        }

        public String getAttr1() {
            return attr1;
        }

        public String getAttr2() {
            return attr2;
        }

        public String getAttr3() {
            return attr3;
        }

        public String getAttr4() {
            return attr4;
        }
    }
}
