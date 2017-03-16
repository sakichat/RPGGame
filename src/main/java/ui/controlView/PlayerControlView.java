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

    private JLabel playerNameLabel;
    private JLabel playerPartyLabel;

    /**
     * layout
     */
    public void initSubviews() {

        JLabel label;

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);
        label.setText("Player");

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(10, 60);
        add(label);
        playerNameLabel = label;

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(10, 110);
        add(label);
        playerPartyLabel = label;

        JButton button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 160);
        add(button);
        button.setText("Become Friendly");
        JButton becomeFriendlyButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 210);
        add(button);
        button.setText("Become Hostile");
        JButton becomeHostileButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 260);
        add(button);
        button.setText("View Attribute");
        JButton viewAttributesButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 310);
        add(button);
        button.setText("View Inventory");
        JButton viewInventoryButton = button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 360);
        add(button);
        button.setText("Remove");
        JButton removeButton = button;

        becomeFriendlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setPlayerParty(Player.PLAYER_PARTY_FRIENDLY);
                dataToView();
                mapEditingScene.playerPanel.dataToView();

                player.setImageName(
                        player.playerImageName(
                                player.getPlayerType(),
                                player.getPlayerParty())
                );
            }
        });

        becomeHostileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setPlayerParty(Player.PLAYER_PARTY_HOSTILE);
                dataToView();
                mapEditingScene.playerPanel.dataToView();

                player.setImageName(
                        player.playerImageName(
                                player.getPlayerType(),
                                player.getPlayerParty())
                );
            }
        });

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

        viewInventoryButton.addActionListener(new ActionListener() {
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
        playerPartyLabel.setText(player.getPlayerParty());
    }


}