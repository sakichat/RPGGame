package ui.controlView;

import logic.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.1
 *
 * This class is for PlayerControlView.
 */
public class PlayerControlView extends ControlView {

    /**
     * Declaration of the property, and getter & setter
     */
    private JLabel playerNameLabel;

    private Player player;

    /**
     * This method is the player getter.
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * This method is the player setter.
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
        dataToView();
    }

    /**
     * constructor of the View.
     */
    public PlayerControlView() {
        this.setSize(180, 560);
        initSubviews();
    }

    /**
     * layout
     */
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
        button.setText("Attributes");
        JButton viewAttributesButton = new JButton();
        viewAttributesButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 160);
        add(button);
        button.setText("Backpack");
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
            private boolean opened;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opened) {
                    mapEditingScene.hideAttributePanel();
                } else {
                    mapEditingScene.showAttributePanel(player);
                }

                opened = !opened;
            }
        });

        viewBackpackButton.addActionListener(new ActionListener() {
            private boolean opened;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opened) {
                    mapEditingScene.hideInventoryPanel();
                } else {
                    mapEditingScene.showInventoryPanel(player);
                }

                opened = !opened;
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEditingScene.destroy();
            }
        });
    }

    /**
     * data to view method
     */
    private void dataToView(){
        playerNameLabel.setText(player.getName());
    }


}