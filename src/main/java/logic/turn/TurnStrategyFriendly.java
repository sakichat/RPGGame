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
    protected Point preferredNextLocation() {

        Play play = Play.getCurrentPlay();
        GameMap gameMap = play.getCurrentMap();
        GameMapGraph gameMapGraph = gameMap.getGraph();
        List<Point> points = gameMapGraph.pointsInRange(getPlayer().getLocation(), getPlayer().getRangeForMove());

        Point result = points.get((int)(Math.random() * points.size()));
        return result;
    }

    @Override
    public boolean couldAttack(Point target) {
        // TODO: 10/04/2017
        return false;
    }

    @Override
    protected boolean couldInteract(Point target) {

        boolean result = false;
        Play play = Play.getCurrentPlay();
        GameMap gameMap = play.getCurrentMap();
        Cell cell = gameMap.getCell(target);
        if (cell instanceof Chest){
            result = true;
        }

        return result;
    }

    @Override
    public Point preferredAttackingLocation() {

        Play play = Play.getCurrentPlay();
        GameMap gameMap = play.getCurrentMap();
        GameMapGraph gameMapGraph = gameMap.getGraph();
        List<Point> points = gameMapGraph.pointsInRange(getPlayer().getLocation(), getPlayer().getRangeForAttack());
        Point result = points.get((int)(Math.random() * points.size()));
        return result;
    }

    @Override
    public Point preferredInteractionLocation() {
        Play play = Play.getCurrentPlay();
        GameMap gameMap = play.getCurrentMap();
        GameMapGraph gameMapGraph = gameMap.getGraph();
        List<Point> points = gameMapGraph.pointsInRange(getPlayer().getLocation(), 1);
        Point result = points.get((int)(Math.random() * points.size()));
        return result;
    }
}
