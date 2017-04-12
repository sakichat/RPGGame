package logic.interaction;

import logic.Play;
import logic.PlayRuntime;
import logic.map.Cell;
import logic.player.Player;

/**
 * Created by Zhaozhe on 12/04/2017.
 */
public abstract class Interaction<T extends Cell> {
    protected Player player = PlayRuntime.currentRuntime().getPlayer();
    public abstract void interact(T target);
}
