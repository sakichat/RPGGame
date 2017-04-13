package logic.interaction;

import logic.PlayRuntime;
import logic.map.Cell;
import logic.player.Player;
import logic.turn.TurnThread;
import ui.scene.PlayScene;

/**
 * Created on 13/04/2017.
 */
public class InteractionFriendlyNPC extends Interaction<Player> {
    @Override
    public void interact() {
        PlayScene playScene = PlayRuntime.currentRuntime().getPlayScene();
        playScene.showInventoryInspectorForExchange(player);
        TurnThread.waitForUser(TurnThread.UserResponse.INTERACT);
    }
}
