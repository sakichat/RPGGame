package ui.scene;

import logic.Play;
import logic.Player;
import logic.Point;
import ui.panel.InventoryPanel;
import ui.panel.MapDelegate;
import ui.panel.PlayerPanel;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a PlayScene for player to play on created maps.
 * @author Siyu Chen
 * @version 0.2
 */
public class PlayScene extends Scene implements GameMapView.Delegate{

    /**
     * These parameters set play on this scene and create gameMapView.
     */
    private Play play;
    private GameMapView gameMapView;

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;

        titleLabel.setText(play.getCurrentMap().getName());
        gameMapView.setGameMap(play.getCurrentMap());
    }

    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    private View controlViewContainerView;
    private JButton upDirection;
    private JButton downDirection;
    private JButton leftDirection;
    private JButton rightDirection;
    private JButton interactButton;

    /**
     * This method creates components on this scene
     * And adds events on buttons
     */
    protected void initSubviews() {
        gameMapView = new GameMapView();
        gameMapView.setLocation(40, 40);
        contentView.add(gameMapView);
        gameMapView.setDelegate(this);

        controlViewContainerView = new View();
        controlViewContainerView.setLocation(820, 40);
        controlViewContainerView.setSize(180, 560);
        add(controlViewContainerView);

        JButton button;

        button = new JButton(new ImageIcon("data/images/up_button.png"));
        button.setLocation(700, 30);
        button.setSize(40, 40);
        upDirection = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/left_button.png"));
        button.setLocation(650, 80);
        button.setSize(40, 40);
        leftDirection = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/center_button.png"));
        button.setLocation(700, 80);
        button.setSize(40, 40);
        interactButton = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/right_button.png"));
        button.setLocation(750, 80);
        button.setSize(40, 40);
        rightDirection = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/down_button.png"));
        button.setLocation(700, 130);
        button.setSize(40, 40);
        downDirection = button;
        contentView.add(button);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayScene.this.navigationView.popTo(MainScene.class);
            }
        });
    }

    /**
     * Relative methods about view player
     */

    PlayerPanel playerPanel;
    InventoryPanel inventoryPanel;

    public void viewAttribute(Player player) {
        playerPanel = new PlayerPanel();
        playerPanel.setPlayer(player);
        playerPanel.setLocation(450, 10);
        contentView.add(playerPanel);

        repaint();
    }

    public void viewInventory(Player player) {
        inventoryPanel = new InventoryPanel();
        inventoryPanel.setPlayer(player);
        if (player.getPlayerType() == Player.PLAYER_PARTY_PLAYER) {
            inventoryPanel.setButtonEnabled(true);
            inventoryPanel.setButtonText("Drop");
        }
        inventoryPanel.setLocation(330, 10);
        contentView.add(inventoryPanel);

        repaint();
    }

    /**
     * This method is used to show the InventoryPanel when player exchange equipment with friendly NPC
     * This method should be called by the ActionListener of interactButton button.
     * @param player
     */
    private void showInventoryToExchange(Player player) {
        inventoryPanel = new InventoryPanel();
        inventoryPanel.setPlayer(player);
        inventoryPanel.setButtonEnabled(true);
        inventoryPanel.setButtonText("Exchange");
        inventoryPanel.setLocation(330, 10);
        contentView.add(inventoryPanel);

        repaint();
    }

    @Override
    public void gameMapViewSelect(GameMapView gameMapView, Point location) {

    }
}
