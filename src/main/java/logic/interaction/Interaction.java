package logic.interaction;

import logic.Play;
import logic.PlayRuntime;
import logic.map.Cell;
import logic.player.Player;


public abstract class Interaction<T extends Cell> {
    protected Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public abstract void interact(T target);
}
