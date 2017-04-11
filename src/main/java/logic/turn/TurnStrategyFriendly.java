package logic.turn;

import logic.Play;
import logic.map.GameMap;
import logic.map.GameMapGraph;
import logic.map.Point;

import java.util.List;

/**
 * Created by GU_HAN on 2017-04-08.
 */
public class TurnStrategyFriendly extends TurnStrategy {

    @Override
    protected Point preferredNextLocation() {
        // TODO: 10/04/2017
        Play play = Play.getCurrentPlay();
        GameMap gameMap = play.getCurrentMap();
        GameMapGraph gameMapGraph = gameMap.getGraph();
        List<Point> points = gameMapGraph.pointsInRange(getPlayer().getLocation(), 3);

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
