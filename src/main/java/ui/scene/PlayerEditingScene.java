package ui.scene;

import logic.equipment.Equipment;
import logic.player.Player;
import persistence.PlayerFileManager;
import ui.panel.*;

import javax.swing.*;

/**
 * This is a class for players to create or edit the details of their characters.
 * It concludes four different functions of creating or editing details of the currentPlayer.
 *
 * @author Kai QI
 * @version 0.3
 */
public class PlayerEditingScene extends Scene implements EquipmentSelectorPanel.Delegate, InventoryPanel.Delegate{

    /**
     * Declaration of the property currentPlayer and getter & setter
     */
    private Player player;

    /**
     * getter
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * setter
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
        playerPanel.setPlayer(player);
        playerPanel.dataToView();
        inventoryPanel.setPlayer(player);
        inventoryPanel.setButtonEnabled(true);
        inventoryPanel.setButtonText("Drop");
        inventoryPanel.dataToView();
    }


    private PlayerPanel playerPanel;
    private EquipmentSelectorPanel equipmentSelectorPanel;
    private InventoryPanel inventoryPanel;

    private JTextField levelField;
    private JButton setButton;
    private JButton bullyButton;
    private JButton nimbleButton;
    private JButton tankButton;

    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        title = "Edit Player";
        backButtonEnabled = true;
        saveButtonEnabled = true;
    }

    /**
     * This method creates components on the main scene
     * And adds events on buttons
     */
    protected void initSubviews() {

        JButton button;

        JLabel levelLabel = new JLabel("Level", JLabel.RIGHT);
        levelLabel.setSize(120, 40);
        levelLabel.setLocation(10, 10);
        contentView.add(levelLabel);

        levelField = new JTextField();
        levelField.setSize(160,40);
        levelField.setLocation(140, 10);
        contentView.add(levelField);

        button = new JButton("Set");
        button.setSize(100, 40);
        button.setLocation(300, 10);
        contentView.add(button);
        setButton = button;

        button = new JButton(Player.PLAYER_TYPE_BULLY);
        button.setSize(100, 40);
        button.setLocation(140, 60);
        contentView.add(button);
        bullyButton = button;

        button = new JButton(Player.PLAYER_TYPE_NIMBLE);
        button.setSize(100, 40);
        button.setLocation(250, 60);
        contentView.add(button);
        nimbleButton = button;

        button = new JButton(Player.PLAYER_TYPE_TANK);
        button.setSize(100, 40);
        button.setLocation(360, 60);
        contentView.add(button);
        tankButton = button;

        /*
         * Player Panel
         */
        playerPanel = new PlayerPanel();
        playerPanel.setLocation(140, 110);
        contentView.add(playerPanel);

        /*
         * Equipment Selector Panel
         */
        equipmentSelectorPanel = new EquipmentSelectorPanel();
        equipmentSelectorPanel.setLocation(110, 380);
        equipmentSelectorPanel.setButtonText("Add");
        contentView.add(equipmentSelectorPanel);

        equipmentSelectorPanel.setDelegate(this);

        /*
         * Inventory Panel
         */
        inventoryPanel = new InventoryPanel();
        inventoryPanel.setLocation(510, 10);
        inventoryPanel.setDelegate(this);
        contentView.add(inventoryPanel);

        repaint();

        backButton.addActionListener(e ->
            PlayerEditingScene.this.navigationView.popTo(EditorScene.class)
        );

        saveButton.addActionListener(e -> save());

        setButton.addActionListener(e -> {
            int level = Integer.valueOf(levelField.getText());
            if (level > 0 && level <= 20) {
                player.setLevel(level);
            }
            playerPanel.dataToView();
        });

        bullyButton.addActionListener(e -> {
            player.setPlayerType(Player.PLAYER_TYPE_BULLY);
            player.generateTotalHp();
            player.generateAbilities(Player.PLAYER_TYPE_BULLY);
            playerPanel.dataToView();
        });

        nimbleButton.addActionListener(e -> {
            player.setPlayerType(Player.PLAYER_TYPE_NIMBLE);
            player.generateTotalHp();
            player.generateAbilities(Player.PLAYER_TYPE_NIMBLE);
            playerPanel.dataToView();
        });

        tankButton.addActionListener(e -> {
            player.setPlayerType(Player.PLAYER_TYPE_TANK);
            player.generateTotalHp();
            player.generateAbilities(Player.PLAYER_TYPE_TANK);
            playerPanel.dataToView();
        });
    }

    /**
     * this method is used to save the object currentPlayer to a file.
     */
    private void save(){
        PlayerFileManager.save(player);
        navigationView.popTo(EditorScene.class);
    }

    /**
     * override the method of the delegate interface
     * @param selectorPanel EquipmentSelectorPanel
     * @param equipment Equipment
     */
    @Override
    public void equipmentSelectorPerformAction(EquipmentSelectorPanel selectorPanel, Equipment equipment) {
        player.pickUpEquipment(equipment);
    }

    /**
     * The method is used to refresh PlayerPanel.
     * @param inventoryPanel
     */
    @Override
    public void inventoryEnhancedPerformAction(InventoryPanel inventoryPanel) {
        playerPanel.dataToView();
    }

    /**
     * The method is an empty implemented method.
     * @param inventoryPanel
     * @param equipment
     */
    @Override
    public void inventoryExchangePerformAction(InventoryPanel inventoryPanel, Equipment equipment) {

    }
}

