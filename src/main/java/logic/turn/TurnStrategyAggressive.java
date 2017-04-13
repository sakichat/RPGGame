package logic.turn;

import logic.PlayRuntime;
import logic.map.*;
import logic.player.Player;

public class TurnStrategyAggressive extends TurnStrategy {
    @Override
    public Path preferredMovingPath() {

        PlayRuntime runtime = PlayRuntime.currentRuntime();
        Player mainPlayer = runtime.getPlay().getMainPlayer();
        GameMap map = runtime.getMap();
        GameMapGraph gameMapGraph = map.getGraph();
        gameMapGraph.addIgnoreType(Cell.Type.CHEST);
        gameMapGraph.addIgnoreType(Cell.Type.PLAYER);
        Path path = gameMapGraph.path(player.getLocation(), mainPlayer.getLocation(), player.getRangeForMove());
        return path;
    }

    @Override
    public boolean couldAttack(Point target) {
        PlayRuntime runtime = PlayRuntime.currentRuntime();
        Player mainPlayer = runtime.getPlay().getMainPlayer();
        GameMap map = runtime.getMap();

        map.getPlayer(target);

        if (! (cell instanceof Player)) {
            return false;
        } else if (((Player)cell).equals(mainPlayer)) {
            return true;
        } else {
            return false;
        }
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
