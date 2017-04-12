package ui.scene;

import logic.*;
import logic.equipment.Equipment;
import logic.map.*;
import logic.player.Player;
import persistence.PlayFileManager;
import ui.controlView.*;
import ui.panel.*;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;

/**
 * This is a PlayScene for player to play on created maps.
 * @author Siyu Chen
 * @version 0.2
 */
public class PlayScene extends Scene implements GameMapView.Delegate, InventoryPanel.Delegate {

    //  =======================================================================
    //  Section - Context
    //  =======================================================================

    private Play play;

    /**
     * This is a setter for Play
     * @param play
     */
    public void setPlay(Play play) {
        this.play = play;

        titleLabel.setText(play.getName() + " - " + play.getCurrentMap().getName());
        gameMapView.setGameMap(play.getCurrentMap());

    }

    //  =======================================================================
    //  Section - Life Cycle
    //  =======================================================================


    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        backButtonEnabled = true;
        saveButtonEnabled = true;
    }


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
        controlViewContainerView.setLocation(820, 0);
        controlViewContainerView.setSize(180, 560);
        contentView.add(controlViewContainerView);

        JButton button;

        button = new JButton("Skip");
        button.setLocation(600, 40);
        button.setSize(160, 40);
        contentView.add(button);
        JButton skipButton = button;

        button = new JButton("Select");
        button.setLocation(600, 100);
        button.setSize(160, 40);
        contentView.add(button);
        JButton selectButton = button;

        repaint();

        backButton.addActionListener(e -> PlayScene.this.navigationView.popTo(MainScene.class));

        saveButton.addActionListener(e -> {
            PlayFileManager.save(play);
            PlayScene.this.navigationView.popTo(MainScene.class);
        });

        skipButton.addActionListener(e -> {});

        selectButton.addActionListener(e -> {});

//        interactButton.addActionListener(e -> {
//            Cell targetCell = play.getTarget();
//            interactWith(targetCell);
//        });

    }


    //  =======================================================================
    //  Section - Views
    //  =======================================================================

    private GameMapView gameMapView;

    /**
     * These parameters are specific for view or buttons.
     */
    private View controlViewContainerView;

    private EquipmentPanel equipmentPanel;

    /**
     * This method gets cell and its location
     * And then call generateControlView() method to add a correct controlView to controlViewContainerView
     */
    private void refreshControlView(){
        Point location = gameMapView.getSelectedLocation();
        GameMap gameMap = gameMapView.getGameMap();
        Cell cell = gameMap.getCell(location);
        View view = generateControlView(cell);

        controlViewContainerView.removeAll();
        controlViewContainerView.add(view);

        controlViewContainerView.repaint();

    }


    /**
     * This method generates what should be shown on controlViewContainerView.
     * @param cell
     * @return controlView
     */
    private ControlView generateControlView(Cell cell) {
        ControlView controlView = null;

        if (cell instanceof Chest) {
            ChestViewControlView chestViewControlView = new ChestViewControlView();
            chestViewControlView.setChest((Chest) cell);
            controlView = chestViewControlView;

        } else if (cell instanceof Player) {
            PlayingControlView playingControlView = new PlayingControlView();
            playingControlView.setPlayer((Player)cell);
            controlView = playingControlView;

        } else {
            PlayingControlView playingControlView = new PlayingControlView();
            playingControlView.setPlayer(play.getMainPlayer());
            controlView = playingControlView;

        }

        controlView.setPlayScene(this);

        return controlView;
    }

    public GameMapView getGameMapView() {
        return gameMapView;
    }


    /**
     * Relative methods about view player
     */
    PlayerPanel playerPanel;
    InventoryPanel inventoryPanel;

    //  =======================================================================
    //  Section - Events
    //  =======================================================================

    /**
     * This method implements MapDelegation and refresh controlViewContainerView.
     * @param gameMapView
     * @param location
     */
    @Override
    public void gameMapViewSelectPerformAction(GameMapView gameMapView, Point location) {
        refreshControlView();
    }

    /**
     * This method creates view Attribute action.
     * @param player
     */
    public void showAttributesInspector(Player player) {
        playerPanel = new PlayerPanel();
        playerPanel.setPlayer(player);
        playerPanel.setLocation(450, 10);
        contentView.add(playerPanel);

        repaint();
    }

    /**
     * This method creates view Inventory action.
     * @param player
     */
    public void showInventoryInspector(Player player) {
        inventoryPanel = new InventoryPanel();
        inventoryPanel.setPlayer(player);
        if (player.getPlayerParty().equals(Player.PLAYER_PARTY_PLAYER)) {
            inventoryPanel.setButtonEnabled(true);
            inventoryPanel.setButtonText("Drop");
            inventoryPanel.dataToView();
        }
        inventoryPanel.setLocation(330, 10);
        inventoryPanel.setDelegate(this);
        contentView.add(inventoryPanel);

        repaint();
    }

    /**
     * The method is used to showChestViewInside.
     * @param chest
     */
    public void showChestInspector(Chest chest) {
        equipmentPanel = new EquipmentPanel();
        equipmentPanel.setLocation(420, 10);
        equipmentPanel.setChest(chest);
        contentView.add(equipmentPanel);

        repaint();
    }


    /**
     * This method is used to show the InventoryPanel when player exchange equipment with friendly NPC
     * This method should be called by the ActionListener of interactButton button.
     * @param player
     */
    private void showInventoryInspectorForExchang(Player player) {

        inventoryPanel = new InventoryPanel();
        inventoryPanel.setLocation(330, 10);
        inventoryPanel.setPlayer(player);
        inventoryPanel.setButtonEnabled(true);
        inventoryPanel.setButtonText("Swap");
        inventoryPanel.dataToView();
        contentView.add(inventoryPanel);
        inventoryPanel.setDelegate(this);

        repaint();
    }

    /**
     * This method is for equipment delegate.
     * @param inventoryPanel
     * @param equipment
     */
    @Override
    public void inventoryExchangePerformAction(InventoryPanel inventoryPanel, Equipment equipment) {

        play.getMainPlayer().dropInventories(equipment);
        Player targetPlayer = (Player) play.getTarget();
        Equipment exchangeEquipmentRandom = targetPlayer.randomExchange(equipment);
        play.getMainPlayer().pickUpEquipment(exchangeEquipmentRandom);

    }


    /**
     * The implemented method of the delegate interface.
     * @param inventoryPanel
     */
    @Override
    public void inventoryEnhancedPerformAction(InventoryPanel inventoryPanel) {
        playerPanel.dataToView();
    }
}
