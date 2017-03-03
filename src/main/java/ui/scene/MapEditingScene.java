package ui.scene;

import com.sun.org.apache.regexp.internal.RE;
import logic.*;
import org.omg.CORBA.PRIVATE_MEMBER;
import ui.controlView.*;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kai QI on 2017/2/28.
 */
public class MapEditingScene extends Scene implements GameMapView.Delegate{

    private GameMap gameMap;
    private GameMapView gameMapView;

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = Simulation.gameMap2();
//        this.gameMap = gameMap;
        titleLabel.setText(this.gameMap.getName());
        gameMapView.setGameMap(this.gameMap);
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
        validateButton.setLocation(550, 40);
        validateButton.setSize(160, 40);
        contentView.add(validateButton);

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

    @Override
    public void gameMapViewSelect(GameMapView gameMapView, Point location) {
        Cell cell = gameMap.getCell(location);
        View view = generateControlView(cell);
        controlViewContainerView.removeAll();
        controlViewContainerView.add(view);
    }


    private ControlView generateControlView(Cell cell){
        if (cell == null) {
            return new EmptyControlView();

        } else if (cell instanceof Entrance){
            return new EntranceControlView();

        } else if (cell instanceof Exit) {
            return new ExitControlView();

        } else if (cell instanceof Obstacle) {
            return new ObstacleControlView();

        } else if (cell instanceof Player) {
            Player player = (Player) cell;
            PlayerControlView playerControlView = new PlayerControlView();
            playerControlView.setPlayer(player);
            return playerControlView;

        } else if (cell instanceof Chest) {
            Chest chest = (Chest) cell;
            ChestControlView chestControlView = new ChestControlView();
            chestControlView.setChest(chest);
            return chestControlView;
        }

        return null;
    }
}
