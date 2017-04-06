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

    /**
     * These parameters set play on this scene and create gameMapView and equipmentPanel.
     */
    private Play play;
    private GameMapView gameMapView;
    private EquipmentPanel equipmentPanel;

    /**
     * This is a setter for Play
     * @param play
     */
    public void setPlay(Play play) {
        this.play = play;

        titleLabel.setText(play.getName() + " - " + play.getCurrentMap().getName());
        gameMapView.setGameMap(play.getCurrentMap());

    }

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
     * These parameters are specific for view or buttons.
     */
    private View controlViewContainerView;
    private JButton upDirectionButton;
    private JButton downDirectionButton;
    private JButton leftDirectionButton;
    private JButton rightDirectionButton;
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
        controlViewContainerView.setLocation(820, 0);
        controlViewContainerView.setSize(180, 560);
        contentView.add(controlViewContainerView);

        JButton button;

        button = new JButton(new ImageIcon("data/images/up_button.png"));
        button.setLocation(700, 30);
        button.setSize(40, 40);
        upDirectionButton = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/left_button.png"));
        button.setLocation(650, 80);
        button.setSize(40, 40);
        leftDirectionButton = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/center_button.png"));
        button.setLocation(700, 80);
        button.setSize(40, 40);
        interactButton = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/right_button.png"));
        button.setLocation(750, 80);
        button.setSize(40, 40);
        rightDirectionButton = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/down_button.png"));
        button.setLocation(700, 130);
        button.setSize(40, 40);
        downDirectionButton = button;
        contentView.add(button);

        button = new JButton("Finish");
        button.setSize(140, 40);
        button.setLocation(650, 210);
        contentView.add(button);
        JButton finishButton = button;

        repaint();

        backButton.addActionListener(e -> PlayScene.this.navigationView.popTo(MainScene.class));

        saveButton.addActionListener(e -> {
            save();
            PlayScene.this.navigationView.popTo(MainScene.class);
        });

        upDirectionButton.addActionListener(e -> move(Point.DIRECTION_UP));

        downDirectionButton.addActionListener(e -> move(Point.DIRECTION_DOWN));

        leftDirectionButton.addActionListener(e -> move(Point.DIRECTION_LEFT));

        rightDirectionButton.addActionListener(e -> move(Point.DIRECTION_RIGHT));

        interactButton.addActionListener(e -> {
            Cell targetCell = play.getTarget();
            interactWith(targetCell);
        });

    }

    /**
     * This method can save a play to a file.
     */
    public void save() {
        PlayFileManager.save(play);
    }

    /**
     * This method sets move actions for buttons.
     * @param direction
     */
    public void move(Point direction) {
        play.setDirection(direction);
        play.move();

        gameMapView.refreshContent();
    }

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
            playingControlView.setPlayer(play.getPlayer());
            controlView = playingControlView;

        }

        controlView.setPlayScene(this);

        return controlView;
    }

    /**
     * Relative methods about view player
     */
    PlayerPanel playerPanel;
    InventoryPanel inventoryPanel;

    /**
     * This method creates view Attribute action.
     * @param player
     */
    public void viewAttribute(Player player) {
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
    public void viewInventory(Player player) {
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
    public void showChestViewInside(Chest chest) {
        equipmentPanel = new EquipmentPanel();
        equipmentPanel.setLocation(420, 10);
        equipmentPanel.setChest(chest);
        contentView.add(equipmentPanel);

        repaint();
    }

    /**
     * This method judges what action should be done according to targetCell.
     * @param targetCell
     */
    private void interactWith(Cell targetCell) {

        if (targetCell instanceof Player) {

            Player targetPlayer = (Player) targetCell;

            if (targetPlayer.isDead()) {
                interactWithDeadNPC(targetPlayer);

            } else {
                if (targetPlayer.getPlayerParty().equals(Player.PLAYER_PARTY_FRIENDLY)) {
                    interactWithFriendlyNPC(targetPlayer);

                } else if (targetPlayer.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE)) {
                    interactWithHostileNPC(targetPlayer);

                }
            }

        } else if (targetCell instanceof Chest) {
            Chest chest = (Chest) targetCell;
            interactWithChest(chest);

        } else if (targetCell instanceof Exit) {

            Exit exit = (Exit) targetCell;

            System.out.println(play.isObjective());
            exit.setImageName("exit_close.png");

            gameMapView.refreshContent();

            if (play.isObjective()) {
                interactWithExit(exit);

            }
        }
    }

    /**
     * This method is for interacting with dead NPC.
     * @param targetPlayer
     */
    private void interactWithDeadNPC(Player targetPlayer) {

        play.getPlayer().lootDeadNPC(targetPlayer);
        play.refreshPlayer();
        gameMapView.refreshContent();

    }

    /**
     * This method is for interacting with friendly NPC.
     * @param targetPlayer
     */
    private void interactWithFriendlyNPC(Player targetPlayer) {

        showInventoryPanelToExchange(play.getPlayer());

    }

    /**
     * This method is used to show the InventoryPanel when player exchange equipment with friendly NPC
     * This method should be called by the ActionListener of interactButton button.
     * @param player
     */
    private void showInventoryPanelToExchange(Player player) {

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

        play.getPlayer().dropInventories(equipment);
        Player targetPlayer = (Player) play.getTarget();
        Equipment exchangeEquipmentRandom = targetPlayer.randomExchange(equipment);
        play.getPlayer().pickUpEquipment(exchangeEquipmentRandom);

    }

    /**
     * This method is for interacting with hostile NPC.
     * @param targetPlayer
     */
    private void interactWithHostileNPC(Player targetPlayer) {

        play.getPlayer().attack(targetPlayer);
        gameMapView.refreshContent();

    }

    /**
     * This method is for interacting with chest.
     * @param chest
     */
    private void interactWithChest(Chest chest) {

        play.getPlayer().lootChest(chest);
        play.refreshChest();
        gameMapView.refreshContent();

    }

    /**
     * This method is for interact
     */
    private void interactWithExit(Exit exit) {

        int currentLevel = play.getPlayer().getLevel();
        play.getPlayer().setLevel(currentLevel + 1);


        if (play.isLastMap()) {
            FinishScene finishScene = new FinishScene();
            PlayScene.this.navigationView.push(finishScene);
        } else {
            play.moveToNextMap();
            gameMapView.setGameMap(play.getCurrentMap());

            gameMapView.refreshContent();
            gameMapView.refreshHighlight();
        }
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
