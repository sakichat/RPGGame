package ui.scene;

import logic.GameMap;
import ui.view.GameMapView;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        button = new JButton(new ImageIcon("data/images/up_button.png"));
        button.setLocation(700, 30);
        button.setSize(40, 40);
        upDirection = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/left_button.png"));
        button.setLocation(650, 80);
        button.setSize(40, 40);
        leftDirection = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/center_button.png"));
        button.setLocation(700, 80);
        button.setSize(40, 40);
        middleDirection = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/right_button.png"));
        button.setLocation(750, 80);
        button.setSize(40, 40);
        rightDirection = button;
        contentView.add(button);

        button = new JButton(new ImageIcon("data/images/down_button.png"));
        button.setLocation(700, 130);
        button.setSize(40, 40);
        downDirection = button;
        contentView.add(button);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayScene.this.navigationView.popTo(EditorScene.class);
            }
        });



    }
}
