package ui.controlView;

import ui.view.View;

import javax.swing.*;

/**
 * Created by Penelope on 17/2/28.
 */
public class MainControlView extends View{

    public final static String WALL = "Wall";
    public final static String ENTRANCE = "Entrance";
    public final static String EXIT = "Exit";
    public final static String CHEST = "Chest";
    public final static String PLAYER = "Player";


    public MainControlView() {
        this.setSize(180,560);
        initSubviews();
    }

    public void initSubviews() {

        JLabel topicLable = new JLabel();
        topicLable.setSize(160, 40);
        topicLable.setLocation(10, 10);
        add(topicLable);

        JButton jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 60);
        add(jButton);
        jButton.setText(WALL);
        JButton wallButton = new JButton();
        wallButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 110);
        add(jButton);
        jButton.setText(ENTRANCE);
        JButton entranceButton = new JButton();
        entranceButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 160);
        add(jButton);
        jButton.setText(EXIT);
        JButton exitButton = new JButton();
        exitButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 210);
        add(jButton);
        jButton.setText(CHEST);
        JButton chestButton = new JButton();
        chestButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 260);
        add(jButton);
        jButton.setText(PLAYER);
        JButton playerButton = new JButton();
        playerButton = jButton;

    }
}
