package ui.controlView;

import ui.scene.MapEditingScene;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.1
 */
public class EmptyControlView extends ControlView{

    public EmptyControlView() {
        this.setSize(180,560);
        initSubviews();
    }

    public void initSubviews() {

        JLabel topicLabel = new JLabel();
        topicLabel.setSize(160, 40);
        topicLabel.setLocation(10, 10);
        add(topicLabel);

        JButton jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 60);
        add(jButton);
        jButton.setText("Wall");
        JButton wallButton = new JButton();
        wallButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 110);
        add(jButton);
        jButton.setText("Entrance");
        JButton entranceButton = new JButton();
        entranceButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 160);
        add(jButton);
        jButton.setText("Exit");
        JButton exitButton = new JButton();
        exitButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 210);
        add(jButton);
        jButton.setText("Chest");
        JButton chestButton = new JButton();
        chestButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 260);
        add(jButton);
        jButton.setText("Player");
        JButton playerButton = new JButton();
        playerButton = jButton;

        wallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        entranceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        chestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        chestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
