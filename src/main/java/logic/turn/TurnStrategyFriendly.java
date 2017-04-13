package logic.turn;

import logic.PlayRuntime;
import logic.map.*;

import java.util.List;

/**
 * @author Li Zhen
 * @version 0.3
 */
public class TurnStrategyFriendly extends TurnStrategy {

    /**
     * @override This method is used for find path
     * @return Path
     */
    @Override
    public Path preferredMovingPath() {

        GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), player.getRangeForMove());
        if (points.size() != 0){
            Point target = points.get((int)(Math.random() * points.size()));
            return gameMapGraph.path(player.getLocation(), target, player.getRangeForMove());
        } else {
            return new Path();
        }
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
        PlayRuntime runtime = PlayRuntime.currentRuntime();
        GameMap map = runtime.getMap();

        Cell targetCell = map.getCell(target);

        if (targetCell != null) {
            if (targetCell instanceof Chest) {
                return true;
            }
        }
        
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

    @Override
    public Point preferredInteractionLocation() {
        List<Point> interactTargets = interactTargetsInNear();

        if (interactTargets != null){
            return interactTargets.get(0);
        }

        return null;
    }
}
