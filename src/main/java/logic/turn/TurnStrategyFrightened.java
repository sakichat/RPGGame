package logic.turn;

import logic.map.Point;

public class TurnStrategyFrightened extends TurnStrategy {

    @Override
    protected Point preferredNextLocation() {
        // TODO: 10/04/2017
        return null;
    }

    @Override
    public boolean couldAttack(Point target) {
        // TODO: 10/04/2017
        return false;
    }

    @Override
    protected boolean couldInteract(Point target) {
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
