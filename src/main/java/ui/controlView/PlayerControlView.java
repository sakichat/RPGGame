package ui.controlView;

import logic.Player;
import ui.scene.MapEditingScene;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.1
 */
public class PlayerControlView extends ControlView {

    private JLabel playerNameLabel;

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        dataToView();
    }

    public PlayerControlView() {
        this.setSize(180, 560);
        initSubviews();
    }

    public void initSubviews() {

        JLabel label;

        label = new JLabel();
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);
        label.setText("Player");

        label = new JLabel();
        label.setSize(160, 40);
        label.setLocation(10, 60);
        add(label);
        playerNameLabel = label;

        JButton button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 110);
        add(button);
        button.setText("View Attributes");
        JButton viewAttributesButton = new JButton();
        viewAttributesButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 160);
        add(button);
        button.setText("View Backpack");
        JButton viewBackpackButton = new JButton();
        viewBackpackButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 210);
        add(button);
        button.setText("Remove");
        JButton removeButton = new JButton();
        removeButton = button;

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

    private void dataToView(){
        playerNameLabel.setText(player.getName());
    }


}