package demo.ui;

import game.Player;
import game.Simulation;
import ui.scene.PlayerEditingScene;
import ui.view.View;

import javax.swing.*;

/**
 * Created by Kai QI on 2017/2/25.
 */
public class PlayerEditingSceneDemo {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        View view = new View();

        PlayerEditingScene playerEditingScene = new PlayerEditingScene();
        playerEditingScene.setPlayer(Simulation.newPlayer());

        frame.add(playerEditingScene);
        frame.repaint();
    }

}
