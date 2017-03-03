package demo.ui;

import logic.Simulation;
import ui.scene.PlayerEditingScene;
import ui.view.Window;

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
