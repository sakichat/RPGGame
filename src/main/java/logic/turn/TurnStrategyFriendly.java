package logic.turn;

import logic.Play;
import logic.PlayRuntime;
import logic.map.*;

import java.util.List;

/**
 * Created by GU_HAN on 2017-04-08.
 */
public class TurnStrategyFriendly extends TurnStrategy {

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

    @Override
    public boolean couldAttack(Point target) {
        return false;
    }

    @Override
    protected boolean couldInteract(Point target) {

        PlayRuntime runtime = PlayRuntime.currentRuntime();
        GameMap map = runtime.getMap();

        Cell targetCell = map.getCell(target);

        if (targetCell instanceof Chest) {
            return true;
        }

        return false;
    }

    @Override
    public Point preferredAttackingLocation() {
        return null;
    }

    @Override
    public Point preferredInteractionLocation() {

        GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();
        List<Point> points = interactTargetsInNear();
        if (points.size() != 0){
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }else {
            return null;
        }

    }
}
