package ui.controlView;

import logic.player.Player;

import javax.swing.*;

/**
 * @author Kai QI
 * @version 0.2
 *
 * This class is for PlayerControlView.
 */
public class PlayerControlView extends ControlView {

    /**
     * Declaration of the property, and getter & setter
     */

    private Player player;

    /**
     * This method is the currentPlayer getter.
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * This method is the currentPlayer setter.
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
        JButton button;

        label = new JLabel("Player", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);

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

        button = new JButton("Become Friendly");
        button.setSize(160, 40);
        button.setLocation(10, 160);
        add(button);
        JButton becomeFriendlyButton = button;

        button = new JButton("Become Hostile");
        button.setSize(160, 40);
        button.setLocation(10, 210);
        add(button);
        JButton becomeHostileButton = button;

        button = new JButton("View Attribute");
        button.setSize(160, 40);
        button.setLocation(10, 260);
        add(button);
        JButton viewAttributesButton = button;

        button = new JButton("View Inventory");
        button.setSize(160, 40);
        button.setLocation(10, 310);
        add(button);
        JButton viewInventoryButton = button;

        button = new JButton("Remove");
        button.setSize(160, 40);
        button.setLocation(10, 360);
        add(button);
        JButton removeButton = button;

        becomeFriendlyButton.addActionListener(e -> {
            player.setPlayerParty(Player.PLAYER_PARTY_FRIENDLY);
            dataToView();
            mapEditingScene.refreshMapView();
        });

        becomeHostileButton.addActionListener(e -> {
            player.setPlayerParty(Player.PLAYER_PARTY_HOSTILE);
            dataToView();
            mapEditingScene.refreshMapView();
        });

        viewAttributesButton.addActionListener(e -> mapEditingScene.showAttributePanel(player));

        viewInventoryButton.addActionListener(e -> mapEditingScene.showInventoryPanel(player));

        removeButton.addActionListener(e -> mapEditingScene.destroy());
    }

    /**
     * data to view method
     */
    private void dataToView(){
        playerNameLabel.setText(player.getName());
        playerPartyLabel.setText(player.getPlayerParty());
    }


}