package ui.scene;

import logic.BaseUpdate;
import logic.Play;
import logic.PlayRuntime;
import logic.equipment.Equipment;
import logic.map.*;
import logic.player.Player;
import persistence.MapFileManager;
import ui.controlView.*;
import ui.panel.*;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * This MapEditingScene class is for editing game map view which extends Scene class
 * And implements GameMapView.Delegate, PlayerDelegate, EquipmentDelegate
 * @author Siyu Chen
 * @version 0.2
 */
public class MapEditingScene extends Scene implements   Observer,
                                                        PlayerSelectorPanel.Delegate,
                                                        EquipmentSelectorPanel.Delegate {

    private GameMap gameMap;
    private GameMapView gameMapView;
    private JLabel validationMessageLabel;

    /**
     * getter
     * @return GameMap
     */
    public GameMap getGameMap() {
        return gameMap;
    }

    /**
     * setter
     * @param gameMap
     */
    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
        titleLabel.setText(gameMap.getName());
        gameMapView.setGameMap(gameMap);
    }

    public GameMapView getGameMapView() {
        return gameMapView;
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
     * This property is for the view contains ControlView
     */
    private View controlViewContainerView;

    /**
     * This method creates components on the main scene
     * And adds events on buttons
     */
    protected void initSubviews() {
        /**
         * Add a GameMapView on MapEditing Scene, and set delegate to this scene.
         */
        gameMapView = new GameMapView();
        gameMapView.setLocation(40, 40);
        contentView.add(gameMapView);

        JButton validateButton = new JButton("Validate");
        validateButton.setLocation(550, 40);
        validateButton.setSize(160, 40);
        contentView.add(validateButton);

        validationMessageLabel = new JLabel();
        validationMessageLabel.setLocation(40, 0);
        validationMessageLabel.setSize(320, 40);
        contentView.add(validationMessageLabel);

        controlViewContainerView = new View();
        controlViewContainerView.setLocation(820, 0);
        controlViewContainerView.setSize(180, 560);
        contentView.add(controlViewContainerView);

        repaint();

        backButton.addActionListener(e ->
            MapEditingScene.this.navigationView.popTo(EditorScene.class)
        );

        saveButton.setEnabled(false);

        saveButton.addActionListener(e -> {
            save();
            MapEditingScene.this.navigationView.popTo(EditorScene.class);
        });

        validateButton.addActionListener(e -> validateMap());
    }

    /**
     * This method validates whether the map is valid
     */
    private void validateMap(){
        String result = gameMap.validate();
        boolean success = result.equals(GameMap.VALIDATION_SUCCESS);
        saveButton.setEnabled(success);

        validationMessageLabel.setText(result);
    }

    /**
     * This method is to save a game map to a json file
     */
    private void save() {
        MapFileManager.save(gameMap);
    }



    /**
     * This method gets cell and its location
     * And then call generateControlView() method to add a correct controlView to controlViewContainerView
     */
    private void refreshControlView(){
        Point location = PlayRuntime.currentRuntime().getPlay().getTargetLocation();
        Cell cell = gameMap.getCell(location);
        View view = generateControlView(cell);
        controlViewContainerView.removeAll();
        controlViewContainerView.add(view);
    }

    /**
     * This method checks which control view should show in controlViewContainerView
     * @param cell
     * @return ControlView
     */
    private ControlView generateControlView(Cell cell){
        ControlView controlView = null;
        if (cell == null) {
            controlView = new EmptyControlView();

        } else if (cell instanceof Entrance){
            controlView = new EntranceControlView();

        } else if (cell instanceof Exit) {
            controlView = new ExitControlView();

        } else if (cell instanceof Obstacle) {
            controlView = new ObstacleControlView();

        } else if (cell instanceof Player) {
            Player player = (Player) cell;
            PlayerControlView playerControlView = new PlayerControlView();
            playerControlView.setPlayer(player);
            controlView = playerControlView;

        } else if (cell instanceof Chest) {
            Chest chest = (Chest) cell;
            ChestControlView chestControlView = new ChestControlView();
            chestControlView.setChest(chest);
            controlView = chestControlView;
        }

        controlView.setMapEditingScene(this);

        return controlView;
    }

    /**
     * This method gets a cell location from triggered events and refresh the Content View Layer
     * with add a new cell on that.
     * After that, it calls refreshControlView() method to reset controlViewContainerView.
     * @param cell
     */
    public void build(Cell cell) {
        Point location = PlayRuntime.currentRuntime().getPlay().getTargetLocation();
        gameMap.addCell(cell, location);
        refreshControlView();
    }

    /**
     * This method gets a cell location from triggered events and refresh the Content View Layer
     * with remove that cell on a layer view.
     * After that, it calls refreshControlView() method to reset controlViewContainerView.
     */
    public void destroy() {
        Point location = PlayRuntime.currentRuntime().getPlay().getTargetLocation();
        gameMap.removeCell(location);
        refreshControlView();
    }

    PlayerSelectorPanel playerSelectorPanel;

    /**
     * This method set playerSelectorPanel on the Scene when the event is triggered
     */
    public void addPlayer(){
        playerSelectorPanel = new PlayerSelectorPanel();
        playerSelectorPanel.setLocation(520, 50);
        playerSelectorPanel.setButtonText("Add");
        add(playerSelectorPanel);

        playerSelectorPanel.setDelegate(this);
    }

    /**
     * This method is to paint a currentPlayer on the specific cell view and remove the selector panel
     * @param playerSelectorPanel PlayerSelectorPanel
     * @param player              Player
     */
    @Override
    public void playerSelectorPerformAction(PlayerSelectorPanel playerSelectorPanel, Player player) {
        remove(playerSelectorPanel);
        build(player);
    }

    /**
     * Properties and methods about chest editing.
     */
    private EquipmentSelectorPanel equipmentSelectorPanel;
    private EquipmentPanel equipmentPanel;

    /**
     * This method set equipmentSelectorPanel on the Scene when the event is triggered
     */
    public void addChest(){
        Chest chest = new Chest();
        build(chest);
    }

    /**
     * The method is used to showChestViewInside.
     * @param chest
     */
    public void showChestViewInside(Chest chest) {

        equipmentSelectorPanel = new EquipmentSelectorPanel();
        equipmentSelectorPanel.setLocation(410, 20);
        equipmentSelectorPanel.setButtonText("Add");
        contentView.add(equipmentSelectorPanel);
        equipmentSelectorPanel.setDelegate(this);

        equipmentPanel = new EquipmentPanel();
        equipmentPanel.setLocation(410, 210);
        equipmentPanel.setButtonEnabled(true);
        equipmentPanel.setChest(chest);
        contentView.add(equipmentPanel);

        repaint();
    }

    /**
     * This method is to add equipment into a chest.
     * @param selectorPanel EquipmentSelectorPanel
     * @param equipment     Equipment
     */
    @Override
    public void equipmentSelectorPerformAction(EquipmentSelectorPanel selectorPanel, Equipment equipment) {

        Chest chest = equipmentPanel.getChest();
        chest.addEquipment(equipment);
    }

    /**
     * Properties and methods about currentPlayer setting.
     */
    private PlayerPanel playerPanel;

    /**
     * Method showAttributePanel
     * @param player
     */
    public void showAttributePanel(Player player){
        playerPanel = new PlayerPanel();
        playerPanel.setPlayer(player);
        playerPanel.setLocation(450, 10);
        contentView.add(playerPanel);
        repaint();
    }

    InventoryPanel inventoryPanel;
    /**
     * Method showInventoryPanel
     * @param player
     */
    public void showInventoryPanel(Player player){
        inventoryPanel = new InventoryPanel();
        inventoryPanel.setPlayer(player);
        inventoryPanel.setLocation(330, 10);
        contentView.add(inventoryPanel);

        repaint();
    }

    /**
     * The method is used to refresh MapView.
     */


    @Override
    public void update(Observable o, Object arg) {
        if (BaseUpdate.when(arg)
                .match(Play.Update.TARGET)
                .check()){
            refreshControlView();
        }
    }
}
