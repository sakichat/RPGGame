package logic.turn;

import logic.PlayRuntime;
import logic.effect.EffectFrightening;
import logic.map.GameMapGraph;
import logic.map.Path;
import logic.map.Point;
import java.util.*;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class TurnStrategyFrightened extends TurnStrategy {

    /**
     * @override This method is used for find path
     * @return Path
     */
    @Override
    public Path preferredMovingPath() {
        GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), player.getRangeForMove());

        EffectFrightening effectFrightening = new EffectFrightening();
        Point combatantLocation = effectFrightening.getCombatant().getLocation();

        int checkDistance = 0;
        Point farestPoint = null;
        for (Point point : points) {
            int distance = gameMapGraph.distanceBetween(combatantLocation, point);
            if (distance > checkDistance) {
                checkDistance = distance;
                farestPoint = point;
            }
        }

        return gameMapGraph.path(player.getLocation(), farestPoint, player.getRangeForMove());
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
