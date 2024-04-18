package mykgrow.plugins.ui;

import javax.swing.*;
import java.awt.*;

public class UiUtils {
    public static void fullWindowView(Component currentComponent, Component componentToAdd) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(currentComponent); // Get the parent JFrame
        frame.getContentPane().removeAll(); // Remove all components from the frame
        frame.getContentPane().add(componentToAdd); // Add the PresetDetailScreen
        frame.revalidate(); // Revalidate the frame to reflect the changes
        frame.repaint(); // Repaint the frame
    }

    public static void navigateHome(Component currentComponent, App app) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(currentComponent);
        if (frame != null) {
            frame.getContentPane().removeAll();
            app.initUI();
            frame.revalidate();
            frame.repaint();
        } else {
            System.err.println("Parent JFrame is null");
        }
    }
}
