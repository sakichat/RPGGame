package logic.turn;

import logic.Play;
import logic.map.*;
import logic.player.Player;

import java.util.List;

/**
 * Created by GU_HAN on 2017-04-08.
 */
public class TurnStrategyFriendly extends TurnStrategy {

    @Override
    public Point preferredNextLocation() {

        GameMapGraph gameMapGraph = Play.getCurrentPlay().getCurrentMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), player.getRangeForMove());

        if (points.size() != 0){
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }else {
            return null;
        }
    }

    @Override
    public boolean couldAttack(Point target) {
        return false;
    }

    @Override
    protected boolean couldInteract(Point target) {

        boolean result = false;
        Play play = Play.getCurrentPlay();
        GameMap gameMap = play.getCurrentMap();
        Cell cell = gameMap.getCell(target);
        if (cell.getCellType().equals(Cell.Type.CHEST)){
            result = true;
        }

        return result;
    }

    @Override
    public Point preferredAttackingLocation() {

        GameMapGraph gameMapGraph = Play.getCurrentPlay().getCurrentMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(getPlayer().getLocation(), getPlayer().getRangeForAttack());
        if (points.size() != 0){
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }else {
            return null;
        }
    }

    @Override
    public Point preferredInteractionLocation() {

        GameMapGraph gameMapGraph = Play.getCurrentPlay().getCurrentMap().getGraph();
        List<Point> points = interactTargetsInNear();
        if (points.size() != 0){
            Point result = points.get((int)(Math.random() * points.size()));
            return result;
        }else {
            return null;
        }

    }
}
