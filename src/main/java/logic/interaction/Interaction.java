package logic.interaction;

import logic.map.Cell;
import logic.player.Player;

/**
 * @author Kai QI
 * @version 0.3
 * @param <T> Generics
 * The class is Interaction abstract class.
 */

public abstract class Interaction<T extends Cell> {

    /**
     * The property of player
     */
    protected Player player;

    /**
     * Getter for player
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter for player
     * @param player Player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * the property of target
     */
    protected T target;

    /**
     * Getter for target
     * @return
     */
    public T getTarget() {
        return target;
    }

    /**
     * Setter for target
     * @param target
     */
    public void setTarget(T target) {
        this.target = target;
    }

    /**
     * abstract method of interact.
     */
    public abstract void interact();
}
