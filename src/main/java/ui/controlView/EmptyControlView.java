package ui.controlView;

import logic.map.Entrance;
import logic.map.Exit;
import logic.map.Obstacle;

import javax.swing.*;

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

        JLabel label = new JLabel();
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);

        JButton button;

        button = new JButton("Wall");
        button.setSize(160, 40);
        button.setLocation(10, 60);
        add(button);
        JButton wallButton = button;

        button = new JButton("Entance");
        button.setSize(160, 40);
        button.setLocation(10, 110);
        add(button);
        JButton entranceButton = button;

        button = new JButton("Exit");
        button.setSize(160, 40);
        button.setLocation(10, 160);
        add(button);
        JButton exitButton = button;

        button = new JButton("Chest");
        button.setSize(160, 40);
        button.setLocation(10, 210);
        add(button);
        JButton chestButton = button;

        button = new JButton("Player");
        button.setSize(160, 40);
        button.setLocation(10, 260);
        add(button);
        JButton playerButton = button;


        wallButton.addActionListener(e -> mapEditingScene.build(new Obstacle()));

        entranceButton.addActionListener(e -> mapEditingScene.build(new Entrance()));

        exitButton.addActionListener(e -> mapEditingScene.build(new Exit()));

        playerButton.addActionListener(e -> mapEditingScene.addPlayer());

        chestButton.addActionListener(e -> mapEditingScene.addChest());
    }

}
