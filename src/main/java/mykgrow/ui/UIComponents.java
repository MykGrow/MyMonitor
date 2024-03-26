package mykgrow.ui;

import javax.swing.*;
import java.awt.*;

public class UIComponents {
    public static JLabel createLabel(String text, int fontSize, int alignment) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(alignment);
        label.setFont(new Font("Arial", Font.PLAIN, fontSize));
        return label;
    }

    public static JButton createButton(String text, int fontSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, fontSize));
        return button;
    }

    public static void addComponent(Container container, Component component) {
        container.add(component);
    }
}
