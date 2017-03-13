package ui.scene;

import logic.GameMap;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;

/**
 * @author Siyu Chen
 * @version 0.2
 */
public class PlayScene extends Scene {

    private GameMap gameMap;
    private GameMapView gameMapView;

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
        saveButtonEnabled = false;
    }

    private View controlViewContainerView;
    private JButton upDirection;
    private JButton downDirection;
    private JButton leftDirection;
    private JButton rightDirection;
    private JButton middleDirection;

    @Override
    protected void initSubviews() {
        gameMapView = new GameMapView();
        gameMapView.setLocation(40, 40);
        contentView.add(gameMapView);

        controlViewContainerView = new View();
        controlViewContainerView.setLocation(820, 40);
        controlViewContainerView.setSize(180, 560);
        add(controlViewContainerView);

        JButton button;

        button = new JButton("Up");
        button.setLocation(700, 30);
        button.setSize(40, 40);
        upDirection = button;
        add(button);

        button = new JButton("Left");
        button.setLocation(650, 80);
        button.setSize(40, 40);
        leftDirection = button;
        add(button);

        button = new JButton("Middle");
        button.setLocation(700, 80);
        button.setSize(40, 40);
        middleDirection = button;
        add(button);

        button = new JButton("Right");
        button.setLocation(750, 80);
        button.setSize(40, 40);
        rightDirection = button;
        add(button);

        button = new JButton("Down");
        button.setLocation(700, 130);
        button.setSize(40, 40);
        downDirection = button;
        add(button);
        repaint();
    }
}
