package logic.interaction;

import logic.PlayRuntime;
import logic.map.Exit;
import ui.scene.FinishScene;

/**
 * @author Kai QI
 * @version 0.3
 * The class is a subclass of Interaction, which is used to interact with Exit
 *
 */
public class InteractionExit extends Interaction<Exit> {

    /**
     * override the interact method in superclass
     * this method is to interact with Exit
     */
    @Override
    public void interact() {
        PlayRuntime playRuntime = PlayRuntime.currentRuntime();
        if (playRuntime.getMap().finishObjective()) {
            int currentLevel = player.getLevel();
            player.setLevel(currentLevel + 1);

            if (playRuntime.getPlay().isLastMap()) {
                playRuntime.stop();
                playRuntime.toFinish("Success");
            } else {
                playRuntime.stop();
                playRuntime.toNextMap();
            }
        }
    }
}
