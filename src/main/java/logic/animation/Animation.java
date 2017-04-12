package logic.animation;

import logic.Play;
import logic.PlayRuntime;
import logic.map.GameMap;
import logic.player.Player;

public abstract class Animation {
    protected Play play;
    protected GameMap gameMap;
    protected Player player;

    public Animation() {
        play = PlayRuntime.currentRuntime().getPlay();
        gameMap = play.currentMap();
        player = play.currentPlayer();
    }

    public abstract void execute();

}
