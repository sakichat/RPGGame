package ui.scene;

import logic.*;
import logic.equipment.Equipment;
import logic.map.*;
import logic.player.Player;
import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyHuman;
import logic.turn.TurnThread;
import persistence.PlayFileManager;
import ui.controlView.*;
import ui.panel.*;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * This is a PlayScene for currentPlayer to play on created maps.
 * @author Siyu Chen
 * @version 0.3
 */
public class PlayScene extends Scene implements Observer, InventoryPanel.Delegate {

    //  =======================================================================
    //  Section - Context
    //  =======================================================================

    private Play play;
    private JButton startButton;
    private JButton skipButton;
    private JButton selectButton;

    /**
     * This is a setter for Play
     * @param play
     */
    public void setPlay(Play play) {
        this.play = play;


    }

    public void refreshMap(){
        titleLabel.setText(play.getName() + " - " + play.currentMap().getName());
        gameMapView.setGameMap(play.currentMap());
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

        controlViewContainerView = new View();
        controlViewContainerView.setLocation(820, 0);
        controlViewContainerView.setSize(180, 560);
        contentView.add(controlViewContainerView);

        JButton button;

        button = new JButton("Start");
        button.setLocation(600, 40);
        button.setSize(160, 40);
        contentView.add(button);
        startButton = button;

        button = new JButton("Select");
        button.setLocation(600, 160);
        button.setSize(160, 40);
        contentView.add(button);
        selectButton = button;

        button = new JButton("Next");
        button.setLocation(600, 100);
        button.setSize(160, 40);
        contentView.add(button);
        skipButton = button;

        repaint();


        backButton.addActionListener(e -> PlayScene.this.navigationView.popTo(MainScene.class));

        saveButton.addActionListener(e -> {
            PlayFileManager.save(play);
            PlayScene.this.navigationView.popTo(MainScene.class);
        });

        startButton.addActionListener(e -> PlayRuntime.currentRuntime().begin());

        skipButton.addActionListener(e -> {
            PlayRuntime.currentRuntime().getPlay().setTargetLocationEnabled(false);
            TurnThread.backToRun();
        });

        selectButton.addActionListener(e -> {
            switch (TurnThread.getUserResponse()){
                case MOVE:      tryMove();      break;
                case ATTACK:    tryAttack();    break;
                case INTERACT:  tryInteract();  break;
            }
        });
    }


    //  =======================================================================
    //  Section - Views
    //  =======================================================================

    /**
     * The property of gameMapView
     */
    private GameMapView gameMapView;

    /**
     * The method of setEnableControls
     * @param enableControls boolean
     */
    public void setEnableControls(boolean enableControls) {
        if (enableControls) {
            backButton.setEnabled(true);
            saveButton.setEnabled(true);
            startButton.setEnabled(true);
            if (play.currentPlayer().getStrategy() instanceof TurnStrategyHuman) {
                skipButton.setText("Skip " + TurnThread.getUserResponse().toString());
                skipButton.setEnabled(true);
                selectButton.setEnabled(true);
            } else {
                skipButton.setText("Next");
                skipButton.setEnabled(true);
            }

        } else {
            backButton.setEnabled(false);
            saveButton.setEnabled(false);
            startButton.setEnabled(false);
            skipButton.setEnabled(false);
            selectButton.setEnabled(false);
            
        }
    }

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
        Point location = PlayRuntime.currentRuntime().getPlay().getTargetLocation();
        if (location != null) {
            GameMap gameMap = PlayRuntime.currentRuntime().getMap();
            Cell cell = gameMap.getCell(location);
            View view = generateControlView(cell);

            controlViewContainerView.removeAll();
            controlViewContainerView.add(view);

            controlViewContainerView.repaint();
        }

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

    /**
     * The method of getGameMapView
     * @return GameMapView
     */
    public GameMapView getGameMapView() {
        return gameMapView;
    }


    /**
     * Relative methods about view currentPlayer
     */
    PlayerPanel playerPanel;
    InventoryPanel inventoryPanel;

    //  =======================================================================
    //  Section - Events
    //  =======================================================================


    /**
     * The mothod of update, observer.
     * @param o Observable
     * @param arg Object
     */
    @Override
    public void update(Observable o, Object arg) {
        if (BaseUpdate.when(arg)
                .match(Play.Update.TARGET)
                .check()){
            SwingUtilities.invokeLater(this::refreshControlView);
        }
    }

    /**
     * The method of tryMove
     */
    private void tryMove(){
        Point targetLocation = play.getTargetLocation();
        Player mainPlayer = play.getMainPlayer();
        GameMapGraph graph = play.currentMap().getGraph();

        List<Point> rangePoints = graph.pointsInRange(mainPlayer.getLocation(), mainPlayer.getRangeForMove());
        if (rangePoints.contains(targetLocation)) {
            TurnThread.backToRun();
        }

    }

    /**
     * The method of tryAttack
     */
    private void tryAttack(){
        Point targetLocation = play.getTargetLocation();
        Player mainPlayer = play.getMainPlayer();

        List<Point> points = mainPlayer.getStrategy().attackTargetsInNear();
        if (points.contains(targetLocation)) {
            TurnThread.backToRun();
        }

    }

    /**
     * The method of tryInteract
     */
    private void tryInteract(){
        Point targetLocation = play.getTargetLocation();
        Player mainPlayer = play.getMainPlayer();

        List<Point> points = mainPlayer.getStrategy().interactTargetsInNear();
        if (points.contains(targetLocation)) {
            TurnThread.backToRun();
        }
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
        if (player.getPlayerParty().equals(Player.PLAYER_PARTY_MAIN)) {
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
     * This method is used to show the InventoryPanel when currentPlayer exchange equipment with friendly NPC
     * This method should be called by the ActionListener of interactButton button.
     * @param player
     */
    public void showInventoryInspectorForExchange(Player player) {

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

        TurnThread.backToRun();
    }


    /**
     * The implemented method of the delegate interface.
     * @param inventoryPanel
     */
    @Override
    public void inventoryEnhancedPerformAction(InventoryPanel inventoryPanel) {
        if (playerPanel != null) {
            playerPanel.dataToView();
        }
    }
}
