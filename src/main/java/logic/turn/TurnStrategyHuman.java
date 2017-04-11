package logic.turn;

import logic.map.Point;

public class TurnStrategyHuman extends TurnStrategy {
    @Override
    public Point preferredNextLocation() {
        return null;
    }

    @Override
    public boolean couldAttack(Point target) {
        return false;
    }

    @Override
    protected boolean couldInteract(Point target) {
        return false;
    }

    @Override
    public Point preferredAttackingLocation() {
        return null;
    }

    @Override
    public Point preferredInteractionLocation() {
        return null;
    }
}
