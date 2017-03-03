package ui.scene;

import com.sun.org.apache.regexp.internal.RE;
import logic.*;
import org.omg.CORBA.PRIVATE_MEMBER;
import persistence.MapFileManager;
import ui.controlView.*;
import ui.panel.EquipmentDelegate;
import ui.panel.EquipmentSelectorPanel;
import ui.panel.PlayerDelegate;
import ui.panel.PlayerSelectorPanel;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class MapEditingScene extends Scene implements GameMapView.Delegate, PlayerDelegate, EquipmentDelegate{

    private GameMap gameMap;
    private GameMapView gameMapView;
    private JLabel validationMessageLabel;

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
        titleLabel.setText(gameMap.getName());
        gameMapView.setGameMap(gameMap);
    }


    @Override
    protected void init() {
        super.init();

        backButtonEnabled = true;
        saveButtonEnabled = true;
    }

    private View controlViewContainerView;

    protected void initSubviews() {
        gameMapView = new GameMapView();
        gameMapView.setLocation(40, 40);
        contentView.add(gameMapView);
        gameMapView.setDelegate(this);

        JButton validateButton = new JButton("Validate");
        validateButton.setLocation(550, 80);
        validateButton.setSize(160, 40);
        add(validateButton);

        validationMessageLabel = new JLabel();
        validationMessageLabel.setLocation(40, 0);
        validationMessageLabel.setSize(320, 40);
        contentView.add(validationMessageLabel);

        controlViewContainerView = new View();
        controlViewContainerView.setLocation(820, 40);
        controlViewContainerView.setSize(180, 560);
        add(controlViewContainerView);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

        saveButton.setEnabled(false);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
                MapEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateMap();
            }
        });
    }

    private void validateMap(){
        String result = gameMap.validate();
        boolean success = result == GameMap.VALIDATION_SUCCESS;
        saveButton.setEnabled(success);

        validationMessageLabel.setText(result);
    }

    private void save() {
        MapFileManager.save(gameMap);
    }

    @Override
    public void gameMapViewSelect(GameMapView gameMapView, Point location) {
        refreshControlView();
    }

    private void refreshControlView(){
        Point location = gameMapView.getSelectedLocation();
        Cell cell = gameMap.getCell(location);
        View view = generateControlView(cell);
        controlViewContainerView.removeAll();
        controlViewContainerView.add(view);
    }


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

    public void build(Cell cell) {
        Point location = gameMapView.getSelectedLocation();
        gameMap.addCell(cell, location);

        gameMapView.refreshContent();
        refreshControlView();
    }

    public void destroy() {
        Point location = gameMapView.getSelectedLocation();
        gameMap.removeCell(location);

        gameMapView.refreshContent();
        refreshControlView();
    }

    PlayerSelectorPanel playerSelectorPanel;

    public void addPlayer(){
        playerSelectorPanel = new PlayerSelectorPanel();
        playerSelectorPanel.setLocation(520, 50);
        playerSelectorPanel.setButtonText("Add");
        add(playerSelectorPanel);

        playerSelectorPanel.setPlayerDelegate(this);
    }

    @Override
    public void playerSelectorPerformAction(PlayerSelectorPanel playerSelectorPanel, Player player) {
        remove(playerSelectorPanel);
        build(player);
    }


    EquipmentSelectorPanel equipmentSelectorPanel;

    public void addChest(){
        equipmentSelectorPanel = new EquipmentSelectorPanel();
        equipmentSelectorPanel.setLocation(420, 50);
        equipmentSelectorPanel.setButtonText("Add");
        add(equipmentSelectorPanel);

        equipmentSelectorPanel.setEquipmentDelegate(this);

    }

    @Override
    public void equipmentSelectorPerformAction(EquipmentSelectorPanel selectorPanel, Equipment equipment) {
        remove(equipmentSelectorPanel);
        Chest chest = new Chest();
        chest.setEquipment(equipment);
        build(chest);
    }
}
