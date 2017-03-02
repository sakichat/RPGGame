package demo.ui;

import ui.view.ImageView;

import javax.swing.*;

/**
 * Created by Penelope on 17/3/1.
 */

public class ImageViewDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(100, 100);
        frame.setVisible(true);

        ImageView imageView = new ImageView();
        imageView.setName("T1234.png");
        imageView.setLocation(0, 0);
        frame.add(imageView);

        frame.repaint();
    }
}
