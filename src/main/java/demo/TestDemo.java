package demo;

import javax.swing.*;

/**
 * Created by Penelope on 2017-04-11.
 */
public class TestDemo {

    private JLabel label;

    public static void main(String[] args) {
        new TestDemo().run();
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(800, 600);
        frame.setVisible(true);

        label = new JLabel("Label");
        label.setSize(120, 40);
        label.setLocation(40, 40);
        frame.add(label);

        JButton button = new JButton("Button");
        button.setSize(160, 40);
        button.setLocation(220, 40);
        frame.add(button);

        frame.repaint();

        button.addActionListener(e -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {

                    }
                    SwingUtilities.invokeLater(() -> s());
                }
            }).start();
        });
    }

    public void s(){
        label.setText("he");
    }
}
