package mykgrow.plugins.ui;

import javax.swing.*;
import java.awt.*;

public class ScrollablePanel{

    private final JPanel panel = new JPanel();
    private final JScrollPane scrollPane;
    ScrollablePanel(){
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(5);
        this.panel.setLayout(layout);
        this.scrollPane = new JScrollPane(this.panel);
    }

    public void add(Component component){
        this.panel.add(component);
    }

    public JScrollPane getPanel(){
        return this.scrollPane;
    }
}
