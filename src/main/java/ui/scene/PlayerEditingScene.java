package ui.scene;

import logic.Equipment;
import logic.Player;
import persistence.PlayerFileManager;
import ui.panel.EquipmentPanel;
import ui.panel.EquipmentDelegate;
import ui.panel.EquipmentSelectorPanel;
import ui.panel.PlayerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a class for players to create or edit the details of their characters.
 * It concludes four different functions of creating or editing details of the player.
 *
 * @author Siyu Chen
 * @version 0.1
 */
public class PlayerEditingScene extends Scene implements EquipmentDelegate{

    /**
     * Declaration of the property player and getter & setter
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
        equipmentPanel.setPlayer(player);
        equipmentPanel.dataToView();
    }


    private PlayerPanel playerPanel;
    private EquipmentPanel equipmentPanel;

    JTextField levelField;
    JButton setButton;
    JButton geneButton;

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
        JLabel levelLabel = new JLabel("Level", JLabel.RIGHT);
        levelLabel.setSize(120, 40);
        levelLabel.setLocation(20, 20);
        contentView.add(levelLabel);

        levelField = new JTextField();
        levelField.setSize(160,40);
        levelField.setLocation(150, 20);
        contentView.add(levelField);

        setButton = new JButton("Set");
        setButton.setSize(100, 40);
        setButton.setLocation(320, 20);
        contentView.add(setButton);

        geneButton = new JButton("Generate Ability Scores");
        geneButton.setSize(270, 40);
        geneButton.setLocation(150, 70);
        contentView.add(geneButton);

        /**
         * Player Panel
         */
        playerPanel = new PlayerPanel();
        playerPanel.setLocation(20, 120);
        contentView.add(playerPanel);

        /**
         * Backpack Panel
         */
        equipmentPanel = new EquipmentPanel();
        equipmentPanel.setLocation(440, 200);
        contentView.add(equipmentPanel);

        /**
         * Equipment Selector Panel
         */
        EquipmentSelectorPanel equipmentSelectorPanel = new EquipmentSelectorPanel();
        equipmentSelectorPanel.setLocation(440, 20);
        equipmentSelectorPanel.setButtonText("Add");
        contentView.add(equipmentSelectorPanel);

        equipmentSelectorPanel.setEquipmentDelegate(this);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setLevel(Integer.valueOf(levelField.getText()));
                player.generateHp();
                playerPanel.dataToView();
            }
        });

        geneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.generateAbilities();
                playerPanel.dataToView();
            }
        });

    }

    /**
     * this method is used to save the object player to a file.
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
}

