package logic.interation;

import logic.Play;
import logic.map.GameMap;
import logic.player.Player;

public abstract class Interaction {
    protected Play play;
    protected GameMap gameMap;
    protected Player player;

    public Interaction() {
        play = Play.getCurrentPlay();
        gameMap = play.getCurrentMap();
        player = play.getPlayer();
    }

    public abstract void execute();
}
