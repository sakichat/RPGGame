package logic.turn;

import logic.Play;
import logic.map.GameMap;
import logic.map.GameMapGraph;
import logic.map.Point;

import java.util.List;

public class TurnStrategyFrightened extends TurnStrategy {

    @Override
    protected Point preferredNextLocation() {
        GameMapGraph gameMapGraph = Play.getCurrentPlay().getCurrentMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), player.getRangeForMove());

        if (points.size() != 0) {
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }

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
