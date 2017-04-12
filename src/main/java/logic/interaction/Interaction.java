package logic.interaction;

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

    protected T target;

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }

    public abstract void interact();
}
