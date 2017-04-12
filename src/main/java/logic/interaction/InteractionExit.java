package logic.interaction;

import logic.PlayRuntime;
import logic.map.Cell;
import logic.map.Exit;
import ui.scene.FinishScene;
import ui.scene.PlayScene;

/**
 * Created on 12/04/2017.
 */
public class InteractionExit extends Interaction<Exit> {
    @Override
    public void interact() {
        PlayRuntime playRuntime = new PlayRuntime();
        int currentLevel = player.getLevel();
        player.setLevel(currentLevel + 1);


        if (playRuntime.getPlay().isLastMap()) {
            FinishScene finishScene = new FinishScene();
            playRuntime.getPlayScene().getNavigationView().push(finishScene);
        } else {
            playRuntime.getPlay().moveToNextMap();
            playRuntime.getMapView().setGameMap(playRuntime.getPlay().getCurrentMap());

            playRuntime.getMapView().refreshHighlight();
        }
    }
}
