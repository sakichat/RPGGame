package ui.scene;

import logic.GameMap;
import ui.controlView.*;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kai QI on 2017/2/28.
 */
public class MapEditingScene extends Scene {
    private GameMap gameMap;
    private GameMapView gameMapView;
    private JLabel mapName;

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;

        gameMapView.setGameMap(gameMap);
    }

    private MainControlView mainControlView;
    private WallControlView wallControlView;
    private EntranceControlView entranceControlView;
    private ExitControlView exitControlView;
    private PlayerControlView playerControlView;
    private ChestControlView chestControlView;

    private View view;

    @Override
    protected void init() {
        super.init();



        title = mapName.getText();
        backButtonEnabled = true;
        saveButtonEnabled = true;
    }

    protected void initSubviews() {
        gameMapView = new GameMapView();
        gameMapView.setLocation(40, 40);
        contentView.add(gameMapView);

        JButton validateButton = new JButton("Validate");
        validateButton.setLocation(550, 40);
        validateButton.setSize(160, 40);
        contentView.add(validateButton);

        mainControlView = new MainControlView();
        mainControlView.setLocation(820, 40);
        add(mainControlView);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
                MapEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });
    }

    public void save() {

    }

}
