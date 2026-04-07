package ru.academits.chesnakov.temperature.view;

import ru.academits.chesnakov.temperature.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class DesktopView implements View {
    private Controller controller;

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температуры");

            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel enterTemperature = new JLabel("Введите температуру:");
            panel.add(enterTemperature);

            JTextField celsiusTemperatureField = new JTextField();
            celsiusTemperatureField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            panel.add(celsiusTemperatureField);

            JButton convertButton = new JButton("Конвертировать");

            convertButton.addActionListener(e -> {
                controller.convert();
            });

            convertButton.addActionListener(e -> {
                Toolkit.getDefaultToolkit().beep();
            });

            panel.add(convertButton);

            JLabel resultLabel = new JLabel();
            panel.add(resultLabel);

            frame.add(panel);

            Image img = Toolkit.getDefaultToolkit().getImage("icon.png");

            frame.setIconImage(img);

            frame.setVisible(true);
        });
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
