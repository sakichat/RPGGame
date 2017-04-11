package logic.turn;

import com.sun.org.apache.regexp.internal.RE;
import logic.Play;
import logic.map.Cell;
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

    public final List<Player> attackTargetsInNear(){
        // TODO: 08/04/2017
        return null;
    }

    protected abstract boolean couldAttack(Player targetPlayer);

    public final List<Cell> interactTargetsInNear(){
        // TODO: 08/04/2017
        return null;
    }

    protected abstract boolean couldInteract(Cell cell);

    public abstract Point preferredAttackingLocation();

    public abstract Point preferredInteractionLocation();


}
