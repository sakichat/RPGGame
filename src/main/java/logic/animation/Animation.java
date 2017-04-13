package logic.animation;

import logic.Play;
import logic.PlayRuntime;
import logic.map.GameMap;
import logic.player.Player;

public abstract class Animation {
    protected Play play;
    protected GameMap gameMap;
    protected Player currentPlayer;

    public Animation() {
        play = PlayRuntime.currentRuntime().getPlay();
        gameMap = play.currentMap();
        currentPlayer = play.currentPlayer();
    }

    public abstract void animate();

}
