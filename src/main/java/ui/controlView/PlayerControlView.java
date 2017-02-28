package ui.controlView;

import game.Player;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Penelope on 17/2/28.
 */
public class PlayerControlView extends View {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerControlView() {
        this.setSize(180, 560);
        initSubviews();
    }

    public void initSubviews() {

        JLabel jLabel;

        jLabel = new JLabel();
        jLabel.setSize(160, 40);
        jLabel.setLocation(10, 10);
        add(jLabel);
        jLabel.setText(MainControlView.PLAYER);
        JLabel topicLabel = new JLabel();
        topicLabel = jLabel;

        jLabel = new JLabel();
        jLabel.setSize(160, 40);
        jLabel.setLocation(10, 60);
        add(jLabel);
        jLabel.setText(player.getName());
        JLabel playerNameLabel = new JLabel();
        playerNameLabel = jLabel;

        JButton jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 110);
        add(jButton);
        jButton.setText("View Attributes");
        JButton viewAttributesButton = new JButton();
        viewAttributesButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 160);
        add(jButton);
        jButton.setText("View Backpack");
        JButton viewBackpackButton = new JButton();
        viewBackpackButton = jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 210);
        add(jButton);
        jButton.setText(MainControlView.REMOVE);
        JButton removeButton = new JButton();
        removeButton = jButton;

        viewAttributesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        viewBackpackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}