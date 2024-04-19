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

    public BorderedScrollablePanel(App app, String title) {
        this(app, title, Layout.GRID, true);
    }
    public BorderedScrollablePanel(App app, String title, Layout layout) {
        this(app, title, layout, true);
    }

    public BorderedScrollablePanel(App app, String title, Layout layout, boolean homeButton) {
        this.app = app;
        this.title = title;
        initializeComponents();
        createUI(layout, homeButton);
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());
        //setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
    private void createUI(Layout layout, boolean homeButton){
        JPanel headerPanel = createHeaderPanel(homeButton);
        add(headerPanel, BorderLayout.NORTH);

        this.contentPanel = createContentPanel(layout);
        JScrollPane scrollPane = new JScrollPane(this.contentPanel);
        add(scrollPane, BorderLayout.CENTER);

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(this.buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel(boolean homeButton){
        this.headerPanel = new JPanel(new BorderLayout());
        //this.headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(this.title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        this.headerPanel.add(titleLabel, BorderLayout.WEST);
        if (homeButton) {
            JButton backButton = createBackButton();
            this.headerPanel.add(backButton, BorderLayout.EAST); // Add the button to the left side
        }
        return this.headerPanel;
    }

    private JButton createBackButton() {
        JButton backButton = new JButton("Home");
        backButton.addActionListener(e -> navigateToHome());
        return backButton;
    }

    private void navigateToHome() {
        UiUtils.navigateHome(this,this.app);
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
