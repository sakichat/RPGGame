package demo;

import javax.swing.*;

/**
 * Created by Penelope on 2017-04-11.
 */
public class TestDemo {
    public static void main(String[] args) {
        new TestDemo().run();
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(800, 600);
        frame.setVisible(true);

        JLabel label = new JLabel("Label");
        label.setSize(120, 40);
        label.setLocation(40, 40);
        frame.add(label);

        JButton button = new JButton("Button");
        button.setSize(160, 40);
        button.setLocation(220, 40);
        frame.add(button);

        frame.repaint();

        button.addActionListener(e -> {});
    }
}
