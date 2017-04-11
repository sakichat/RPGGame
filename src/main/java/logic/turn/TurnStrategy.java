package logic.turn;

import logic.map.Point;
import logic.player.Player;

import java.util.List;

public abstract class TurnStrategy {
    private Player player;

    public final Player getPlayer() {
        return player;
    }

    public final void setPlayer(Player player) {
        this.player = player;
    }

    protected abstract Point preferredNextLocation();

    public final List<Point> attackTargetsInNear(){
        // TODO: 08/04/2017
        return null;
    }

    public abstract boolean couldAttack(Point target);

    public final List<Point> interactTargetsInNear(){
        // TODO: 08/04/2017
        return null;
    }

    protected abstract boolean couldInteract(Point target);

    public abstract Point preferredAttackingLocation();

    public abstract Point preferredInteractionLocation();


}
