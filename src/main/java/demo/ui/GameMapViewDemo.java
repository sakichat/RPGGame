package demo.ui;

import game.Simulation;
import map.GameMap;
import ui.view.GameMapView;

import javax.swing.*;

/**
 * Created by Penelope on 17/3/2.
 */
public class GameMapViewDemo extends JFrame {
    public static void main(String[] args) {
        GameMapViewDemo gameMapViewDemo = new GameMapViewDemo();
        gameMapViewDemo.setLayout(null);
        gameMapViewDemo.setSize(200, 200);
        gameMapViewDemo.setVisible(true);
    }

    public GameMapViewDemo() {
        GameMapView gameMapView = new GameMapView();
        GameMap gameMap = Simulation.gameMap1();
        gameMapView.setGameMap(gameMap);
        add(gameMapView);
    }
}
