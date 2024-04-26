package mykgrow.plugins.ui;

import javax.swing.*;
import java.awt.*;

public class UIComponents {

    public enum FontSizes {
        SMALL(12),
        MEDIUM(14),
        LARGE(16),
        XLARGE(18);

        private final int size;

        FontSizes(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }
    public static JLabel createLabel(String text, FontSizes fontSize, int alignment) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(alignment);
        label.setFont(new Font("Roboto", Font.PLAIN, fontSize.getSize()));
        return label;
    }


    public static JTextField createTextField(int columns, FontSizes fontSize) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Arial", Font.PLAIN, fontSize.getSize()));
        return textField;
    }

    public static JButton createButton(String text, FontSizes fontSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, fontSize.getSize()));
        return button;
    }

    public static void addComponent(Container container, Component component) {
        container.add(component);
    }
}
