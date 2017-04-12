package logic.turn;

import logic.map.Path;
import logic.map.Point;

public class TurnStrategyHuman extends TurnStrategy {
    @Override
    public Path preferredMovingPath() {
        return new Path();
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
