package demo.ui;


import ui.view.ImageView;

import javax.swing.*;

/**
 * Created by Penelope on 17/3/1.
 */

public class ImageViewDemo extends JFrame {
    public static void main(String[] args) {

        ImageViewDemo demo = new ImageViewDemo();
        demo.setSize(200, 200);
        demo.setVisible(true);


    }

    public ImageViewDemo() {
        setLayout(null);

        JLabel label = new JLabel();
        label.setText("hehe");
        label.setLocation(0, 50);
        label.setSize(100, 20);
        add(label);


        ImageView imageView = new ImageView();
        imageView.setName("T1234.png");
        imageView.setLocation(0, 0);
        imageView.setSize(40, 40);
        add(imageView);


        repaint();

    }
}
