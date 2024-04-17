package mykgrow.plugins.ui;

import mykgrow.domain.entities.GrowthPeriod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderedScrollablePanel extends JPanel {

    public enum Layout {

        GRIDBAG(new GridBagLayout()),
        GRID(new GridLayout(0,1)),
        BOX();
        private LayoutManager layout;
        private Layout(LayoutManager layout){
            this.layout = layout;
        }
        private Layout(){
            this.layout = null;
        }

        public LayoutManager getLayout(){
            return this.layout;
        }
    }
    private App app;
    private String title;
    private JPanel headerPanel;
    private JPanel contentPanel;
    private JPanel buttonPanel;
    public BorderedScrollablePanel(App app, String title, Layout layout) {
        this.app = app;
        this.title = title;
        initializeComponents();
        createUI(layout);
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
    private void createUI(Layout layout) {
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        this.contentPanel = createContentPanel(layout);
        JScrollPane scrollPane = new JScrollPane(this.contentPanel);
        add(scrollPane, BorderLayout.CENTER);

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(this.buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        this.headerPanel = new JPanel(new BorderLayout());
        this.headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(this.title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        this.headerPanel.add(titleLabel, BorderLayout.WEST);

        JButton backButton = createBackButton();
        this.headerPanel.add(backButton, BorderLayout.EAST); // Add the button to the left side

        return this.headerPanel;
    }

    private JButton createBackButton() {
        JButton backButton = new JButton("Home");
        backButton.addActionListener(e -> navigateToHome());
        return backButton;
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

    private JPanel createContentPanel(Layout layout){
        if (layout == Layout.BOX) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            return panel;
        }
        return new JPanel(layout.getLayout());
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(JPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }
}
