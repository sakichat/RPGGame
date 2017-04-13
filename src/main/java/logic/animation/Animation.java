package logic.animation;

import logic.Play;
import logic.PlayRuntime;
import logic.map.GameMap;
import logic.player.Player;

/**
 * @author Qi Xia
 * @version 0.3
 */
public abstract class Animation {

    /**
     * attributes
     */
    protected Play play;
    protected GameMap gameMap;
    protected Player currentPlayer;

    /**
     * This is the method for animation
     */
    public Animation() {
        play = PlayRuntime.currentRuntime().getPlay();
        gameMap = play.currentMap();
        currentPlayer = play.currentPlayer();
    }

    /**
     * This is a abstract method for animate
     */
    public abstract void animate();

}
