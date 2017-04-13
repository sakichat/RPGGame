package logic.turn;


import logic.map.Path;
import logic.map.Point;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class TurnStrategyFrozen extends TurnStrategy {

    /**
     * @override This method is used for find path
     * @return Path
     */
    @Override
    public Path preferredMovingPath() {
        return new Path();
    }

    /**
     * @override This method is used for couldAttack
     * @param target Point
     * @return Boolean
     */
    @Override
    public boolean couldAttack(Point target) {
        return false;
    }

    /**
     * @override This method is used for couldInteract
     * @param target Point
     * @return Boolean
     */
    @Override
    protected boolean couldInteract(Point target) {
        return false;
    }

    /**
     * @override This method is used for preferredAttackingLocation
     * @return Point
     */
    @Override
    public Point preferredAttackingLocation() {
        return null;
    }

    /**
     * @override This method is used for preferredInteractionLocation
     * @return Point
     */
    @Override
    public Point preferredInteractionLocation() {
        return null;
    }
}
