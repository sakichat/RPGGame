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
            return gameMapGraph.path(player.getLocation(), target, 3);
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

        boolean result = false;
        Play play = PlayRuntime.currentRuntime().getPlay();
        GameMap gameMap = play.currentMap();
        Cell cell = gameMap.getCell(target);
        if (cell.getCellType().equals(Cell.Type.CHEST)){
            result = true;
        }

        return result;
    }

    @Override
    public Point preferredAttackingLocation() {

        List<Point> points = attackTargetsInNear();
        if (points.size() != 0){
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }else {
            return null;
        }
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
