package ui.scene;

import ui.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class MapCreationScene extends Scene {
    @Override
    protected void init() {
        super.init();

        titleName = "Create Map";
        backButton = true;
        saveButton = false;
    }

    protected void initSubviews() {
        JLabel nameLabel = new JLabel("Name", JLabel.RIGHT);
        nameLabel.setSize(120, 40);
        nameLabel.setLocation(20, 20);
        main.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setSize(160, 40);
        nameField.setLocation(150, 20);
        main.add(nameField);

        JLabel sizeLabel = new JLabel("Size", JLabel.RIGHT);
        sizeLabel.setSize(120, 40);
        sizeLabel.setLocation(20, 70);
        main.add(sizeLabel);

        JLabel sizeSet = new JLabel();
        sizeSet.setSize(200, 40);
        sizeSet.setLocation(150, 70);
        sizeSet.setText("4 x 4");
        main.add(sizeSet);

        JButton smallSize = new JButton();
        smallSize.setSize(100, 40);
        smallSize.setLocation(150, 120);
        main.add(smallSize);
        smallSize.setText("4 x 4");
        smallSize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sizeSet.setText(smallSize.getText());
                main.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

//        smallSize.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sizeSet.setText(smallSize.getText());
//            }
//        });

        JButton mediumSize = new JButton("8 x 8");
        mediumSize.setSize(100, 40);
        mediumSize.setLocation(260, 120);
        main.add(mediumSize);
        mediumSize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sizeSet.setText(mediumSize.getText());
                main.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

//        mediumSize.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sizeSet.setText(mediumSize.getText());
//            }
//        });

        JButton largeSize = new JButton("12 x 12");
        largeSize.setSize(100, 40);
        largeSize.setLocation(370, 120);
        main.add(largeSize);
        largeSize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sizeSet.setText(largeSize.getText());
                main.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

//        largeSize.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sizeSet.setText(largeSize.getText());
//            }
//        });

        JButton create = new JButton("Create");
        create.setSize(160, 40);
        create.setLocation(150, 190);
        main.add(create);

        repaint();

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapCreationScene.this.viewFlow.pop();
            }
        });
    }
}
