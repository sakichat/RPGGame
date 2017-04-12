package logic.turn;

import logic.PlayRuntime;
import logic.effect.EffectFrightening;
import logic.map.GameMapGraph;
import logic.map.Path;
import logic.map.Point;

import java.util.*;

public class TurnStrategyFrightened extends TurnStrategy {

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

        return gameMapGraph.path(player.getLocation(), farestPoint, 3);
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
