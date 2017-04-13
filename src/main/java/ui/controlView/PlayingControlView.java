package ui.controlView;

import logic.player.Player;
import ui.scene.PlayScene;

import javax.swing.*;

/**
 * @author Kai QI
 * @version 0.3
 * This class is for PlayingControlView.
 *
 */

public class PlayingControlView extends ControlView {

    /**
     * Declaration of the properties, and getter & setter
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

    private PlayScene playScene;

    /**
     * Getter for playScene.
     * @return
     */
    public PlayScene getPlayScene() {
        return playScene;
    }

    /**
     * Setter for playScene.
     * @param playScene
     */
    public void setPlayScene(PlayScene playScene) {
        this.playScene = playScene;
    }

    /**
     * constructor of the View.
     */
    public PlayingControlView() {
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

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);
        playerPartyLabel = label;

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(10, 60);
        add(label);
        playerNameLabel = label;

        button = new JButton("View Attribute");
        button.setSize(160, 40);
        button.setLocation(10, 110);
        add(button);
        JButton viewAttributesButton = button;

        button = new JButton("View Inventory");
        button.setSize(160, 40);
        button.setLocation(10, 160);
        add(button);
        JButton viewInventoryButton = button;

        viewAttributesButton.addActionListener(e -> playScene.showAttributesInspector(player));

        viewInventoryButton.addActionListener(e -> playScene.showInventoryInspector(player));
    }

    /**
     * data to view method
     */
    private void dataToView(){
        playerNameLabel.setText(player.getName());
        playerPartyLabel.setText(player.getPlayerParty());
    }

}
