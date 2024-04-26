//package mykgrow.trash;
//
//import mykgrow.plugins.ui.ui_utils.UIComponents;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class GrowBoxDashboard extends JFrame {
//    private final Actuator lightActuator;
//    private final Actuator fanActuator;
//
//    private final JButton lightButton;
//    private final JButton fanButton;
//
//    private final JLabel lightStatusLabel;
//    private final JLabel fanStatusLabel;
//
//    public GrowBoxDashboard(Light lightActuator, FanActuator fanActuator) {
//        this.lightActuator = lightActuator;
//        this.fanActuator = fanActuator;
//
//        setTitle("GrowBox Dashboard");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new GridLayout(3, 3));
//
//        // Initialize components
//        JLabel temperatureLabel = UIComponents.createLabel("Temperature: -- °C", 16, SwingConstants.CENTER);
//        JLabel humidityLabel = UIComponents.createLabel("Humidity: -- %", 16, SwingConstants.CENTER);
//
//        lightButton = UIComponents.createButton("Toggle Light", 14);
//        fanButton = UIComponents.createButton("Toggle Fan", 14);
//
//        lightStatusLabel = UIComponents.createLabel("Light: OFF", 14, SwingConstants.CENTER);
//        fanStatusLabel = UIComponents.createLabel("Fan: OFF", 14, SwingConstants.CENTER);
//
//        lightButton.setMargin(new Insets(10, 20, 10, 20));
//        fanButton.setMargin(new Insets(10, 20, 10, 20));
//
//        UIComponents.addComponent(this, temperatureLabel);
//        UIComponents.addComponent(this, humidityLabel);
//        UIComponents.addComponent(this, new JLabel());
//        UIComponents.addComponent(this, lightButton);
//        UIComponents.addComponent(this, fanButton);
//        UIComponents.addComponent(this, new JLabel());
//        UIComponents.addComponent(this, lightStatusLabel);
//        UIComponents.addComponent(this, fanStatusLabel);
//
//        // Setup event handlers
//        lightButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                toggleActuator(lightActuator, lightStatusLabel);
//            }
//        });
//
//        fanButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                toggleActuator(fanActuator, fanStatusLabel);
//            }
//        });
//
//        // Set initial state
//        updateActuatorStatusLabel(lightActuator, lightStatusLabel);
//        updateActuatorStatusLabel(fanActuator, fanStatusLabel);
//
//        // Center the window on the screen
//        setLocationRelativeTo(null);
//    }
//
//    private void toggleActuator(Actuator actuator, JLabel statusLabel) {
//        actuator.toggleState();
//        updateActuatorStatusLabel(actuator, statusLabel);
//        // This is where you would implement the logic to control the actuators
//        // For now, let's just print a message
//        System.out.println(actuator.getName() + " toggled");
//    }
//
//    private void updateActuatorStatusLabel(Actuator actuator, JLabel statusLabel) {
//        statusLabel.setText(actuator.getName() + ": " + (actuator.getState() == ActuatorStatus.ON ? "ON" : "OFF"));
//    }
//
//    public static void main(String[] args) {
//        Light lightActuator = new Light("Light", ActuatorStatus.OFF);
//        FanActuator fanActuator = new FanActuator("Fan", ActuatorStatus.OFF);
//
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                GrowBoxDashboard dashboard = new GrowBoxDashboard(lightActuator, fanActuator);
//                dashboard.setVisible(true);
//            }
//        });
//    }
//}
//
