package ui.scene;

import logic.Campaign;
import logic.Equipment;
import logic.GameMap;
import logic.Player;
import ui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class for choosing editor and creation.
 * @author Siyu Chen
 * @version 0.2
 */
public class EditorScene extends Scene implements EquipmentSelectorPanel.Delegate, PlayerDelegate, MapDelegate, CampaignDelegate {

    private JLabel label;
    private JButton button;

    /**
     * Constructor
     */
    @Override
    protected void init() {
        super.init();

        title = "Editor";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    /**
     * set layout
     */
    protected void initSubviews() {
        label = new JLabel("Item");
        label.setSize(160, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        label = new JLabel("Player");
        label.setSize(160, 40);
        label.setLocation(210, 20);
        contentView.add(label);

        JLabel mapLabel = new JLabel("Map");
        mapLabel.setSize(160, 40);
        mapLabel.setLocation(400, 20);
        contentView.add(mapLabel);

        label = new JLabel("Campaign");
        label.setSize(160, 40);
        label.setLocation(590, 20);
        contentView.add(label);

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(20, 70);
        contentView.add(button);
        JButton itemCreateButton = button;

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(210, 70);
        contentView.add(button);
        JButton playerCreateButton = button;

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(400, 70);
        contentView.add(button);
        JButton mapCreateButton = button;

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(590, 70);
        contentView.add(button);
        JButton campaignCreateButton = button;

        button = new JButton("Edit");
        button.setSize(160, 40);
        button.setLocation(20, 150);
        contentView.add(button);
        JButton itemEditButton = button;

        button = new JButton("Edit");
        button.setSize(160, 40);
        button.setLocation(210, 150);
        contentView.add(button);
        JButton playerEditButton = button;

        button = new JButton("Edit");
        button.setSize(160, 40);
        button.setLocation(400, 150);
        contentView.add(button);
        JButton mapEditButton = button;

        button = new JButton("Edit");
        button.setSize(160, 40);
        button.setLocation(590, 150);
        contentView.add(button);
        JButton campaignEditButton = button;

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditorScene.this.navigationView.pop();
            }
        });

        itemCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemCreationScene itemCreationScene = new ItemCreationScene();
                EditorScene.this.navigationView.push(itemCreationScene);
            }
        });

        itemEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemEdit();
            }
        });

        playerCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerCreationScene playerCreationScene = new PlayerCreationScene();
                EditorScene.this.navigationView.push(playerCreationScene);
            }
        });

        playerEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerEdit();

            }
        });

        mapCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapCreationScene mapCreationScene = new MapCreationScene();
                EditorScene.this.navigationView.push(mapCreationScene);
            }
        });

        mapEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEdit();

            }
        });


        campaignCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CampaignCreationScene campaignCreationScene = new CampaignCreationScene();
                EditorScene.this.navigationView.push(campaignCreationScene);
            }
        });

        campaignEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campaignEdit();

            }
        });
    }

    /**
     * This method is used to edit the item.
     */
    private void itemEdit(){

        EquipmentSelectorPanel equipmentSelectorPanel = new EquipmentSelectorPanel();
        equipmentSelectorPanel.setLocation(20,260);
        equipmentSelectorPanel.setButtonText("Edit");
        equipmentSelectorPanel.setDelegate(this);
        add(equipmentSelectorPanel);
    }

    /**
     * override the method in delegate interface.
     * @param selectorPanel EquipmentSelectorPanel
     * @param equipment Equipment
     */
    @Override
    public void equipmentSelectorPerformAction(EquipmentSelectorPanel selectorPanel, Equipment equipment) {
        remove(selectorPanel);

        ItemEditingScene itemEditingScene = new ItemEditingScene();
        itemEditingScene.setEquipment(equipment);
        navigationView.push(itemEditingScene);
    }

    /**
     * This method is used to edit the player.
     */
    private void playerEdit(){
        PlayerSelectorPanel playerSelectorPanel = new PlayerSelectorPanel();
        playerSelectorPanel.setLocation(20,260);
        playerSelectorPanel.setButtonText("Edit");
        playerSelectorPanel.setPlayerDelegate(this);
        add(playerSelectorPanel);

    }

    /**
     * override the method in delegate interface.
     * @param playerSelectorPanel PlayerSelectorPanel
     * @param player Player
     */
    @Override
    public void playerSelectorPerformAction(PlayerSelectorPanel playerSelectorPanel, Player player) {
        remove(playerSelectorPanel);

        PlayerEditingScene playerEditingScene = new PlayerEditingScene();
        playerEditingScene.setPlayer(player);
        navigationView.push(playerEditingScene);

    }

    /**
     * This method is used to edit the map.
     */
    private void mapEdit(){
        MapSelectorPanel panel = new MapSelectorPanel();
        panel.setLocation(20,260);
        panel.setButtonText("Edit");
        panel.setMapDelegate(this);
        add(panel);
    }

    /**
     * override the method in delegate interface.
     * @param mapSelectorPanel MapSelectorPanel
     * @param gameMap GameMap
     */
    @Override
    public void mapSelectorPerformAction(MapSelectorPanel mapSelectorPanel, GameMap gameMap) {
        remove(mapSelectorPanel);

        MapEditingScene mapEditingScene = new MapEditingScene();
        mapEditingScene.setGameMap(gameMap);
        navigationView.push(mapEditingScene);
    }

    /**
     * This method is used to edit the map.
     */
    private void campaignEdit(){
        CampaignSelectorPanel panel = new CampaignSelectorPanel();
        panel.setLocation(20,260);
        panel.setButtonText("Edit");
        panel.setCampaignDelegate(this);
        add(panel);
    }

    /**
     * override the method in delegate interface.
     * @param campaignSelectorPanel CampaignSelectorPanel
     * @param campaign Campaign
     */
    @Override
    public void campaignSelectorPerformAction(CampaignSelectorPanel campaignSelectorPanel, Campaign campaign) {
        remove(campaignSelectorPanel);

        CampaignEditingScene campaignEditingScene = new CampaignEditingScene();
        campaignEditingScene.setCampaign(campaign);
        navigationView.push(campaignEditingScene);
    }
}
