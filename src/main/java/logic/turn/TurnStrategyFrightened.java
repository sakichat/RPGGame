package logic.turn;

import logic.map.Cell;
import logic.map.Point;
import logic.player.Player;

public class TurnStrategyFrightened extends TurnStrategy {

    @Override
    protected Point preferredNextLocation() {
        // TODO: 10/04/2017
        return null;
    }

    @Override
    protected boolean couldAttack(Player targetPlayer) {
        // TODO: 10/04/2017
        return false;
    }

    @Override
    protected boolean couldInteract(Cell cell) {
        // TODO: 10/04/2017
        return false;
    }

    @Override
    public Point preferredAttackingLocation() {
        // TODO: 10/04/2017
        return null;
    }

    @Override
    public Point preferredInteractionLocation() {
        // TODO: 10/04/2017
        return null;
    }
}
