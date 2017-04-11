package demo;

import ui.view.PlayerCellView;
import ui.view.Simulation;

import javax.swing.*;

/**
 * Created by Penelope on 2017-04-09.
 */
public class PlayerCellViewDemo {
    public static void main(String[] args) {
        new PlayerCellViewDemo().run();
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 640);
        frame.setLayout(null);
        frame.setVisible(true);

//        GameMapView gameMapView = new GameMapView();
//        gameMapView.setGameMap(Simulation.gameMap());
//        gameMapView.setSize(500, 500);
//        gameMapView.setLocation(40, 40);
//        add(gameMapView);

        PlayerCellView playerCellView = new PlayerCellView();
        playerCellView.setPlayer(Simulation.player());
        playerCellView.setLayout(null);
        playerCellView.setSize(40, 40);
        playerCellView.setLocation(100, 100);
        frame.add(playerCellView);

        frame.repaint();
    }
}
