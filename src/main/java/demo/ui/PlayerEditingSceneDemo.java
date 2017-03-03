package demo.ui;

import game.Player;
import game.Simulation;
import ui.scene.PlayerEditingScene;
import ui.view.View;
import ui.view.Window;

import javax.swing.*;

/**
 * Created by Kai QI on 2017/2/25.
 */
public class PlayerEditingSceneDemo {
    public static void main(String[] args) {


        PlayerEditingScene playerEditingScene = new PlayerEditingScene();
        playerEditingScene.setPlayer(Simulation.newPlayer());

        Window window = new Window(playerEditingScene);
        window.setSize(1000, 700);
        window.setVisible(true);

    }

}
