package logic.interation;

import logic.Play;
import logic.PlayRuntime;
import logic.map.GameMap;
import logic.player.Player;

public abstract class Interaction {
    protected Play play;
    protected GameMap gameMap;
    protected Player player;

    public Interaction() {
        play = PlayRuntime.currentRuntime().getPlay();
        gameMap = play.getCurrentMap();
        player = play.getPlayer();
    }

    public abstract void execute();


}
