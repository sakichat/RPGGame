package ui.scene;

import game.Equipment;
import game.Player;
import persistence.EquipmentFileManager;
import persistence.PlayerFileManager;
import ui.panel.BackpackPanel;
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

    private Player player;

    private PlayerPanel playerPanel;
    private BackpackPanel backpackPanel;

    JTextField levelField;
    JButton setButton;
    JButton geneButton;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        playerPanel.setPlayer(player);
        playerPanel.dataToView();
        backpackPanel.setPlayer(player);
        backpackPanel.dataToView();
    }

    @Override
    protected void init() {
        super.init();

        title = "Edit Player";
        backButtonEnabled = true;
        saveButtonEnabled = true;
    }

    protected void initSubviews() {
        JLabel level = new JLabel("Level", JLabel.RIGHT);
        level.setSize(120, 40);
        level.setLocation(20, 20);
        contentView.add(level);

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
        backpackPanel = new BackpackPanel();
        backpackPanel.setLocation(440, 200);
        contentView.add(backpackPanel);

        /**
         * Equipment Selector Panel
         */
        EquipmentSelectorPanel equipmentSelectorPanel = new EquipmentSelectorPanel();
        equipmentSelectorPanel.setLocation(440, 20);
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
                PlayerEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setLevel(Integer.valueOf(levelField.getText()));
                playerPanel.dataToView();
            }
        });

        geneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.generateAbilities();
                player.setHp(100);
                playerPanel.dataToView();
            }
        });

    }

    private void save(){
        PlayerFileManager.save(player);
        navigationView.popTo(EditorScene.class);
    }

    @Override
    public void equipmentDelegate(Equipment equipment) {
        player.pickUpEquipment(equipment);
    }
}

