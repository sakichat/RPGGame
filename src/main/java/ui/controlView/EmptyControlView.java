package ui.controlView;

import logic.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.2
 *
 * This class is for emptyControlView.
 */
public class EmptyControlView extends ControlView{

    /**
     * constructor of the View.
     */
    public EmptyControlView() {
        this.setSize(180,560);
        initSubviews();
    }

    /**
     * layout
     */
    public void initSubviews() {

        JLabel topicLabel = new JLabel();
        topicLabel.setSize(160, 40);
        topicLabel.setLocation(10, 10);
        add(topicLabel);

        JButton button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 60);
        add(button);
        button.setText("Wall");
        JButton wallButton = new JButton();
        wallButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 110);
        add(button);
        button.setText("Entrance");
        JButton entranceButton = new JButton();
        entranceButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 160);
        add(button);
        button.setText("Exit");
        JButton exitButton = new JButton();
        exitButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 210);
        add(button);
        button.setText("Chest");
        JButton chestButton = new JButton();
        chestButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 260);
        add(button);
        button.setText("Player");
        JButton playerButton = new JButton();
        playerButton = button;


        wallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEditingScene.build(new Obstacle());
            }
        });

        entranceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEditingScene.build(new Entrance());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEditingScene.build(new Exit());
            }
        });

        playerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEditingScene.addPlayer();
            }
        });

        chestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEditingScene.addChest();
            }
        });
    }

}
