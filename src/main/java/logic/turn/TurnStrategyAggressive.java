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
        GameMap map = runtime.getMap();

        Player targetPlayer = map.getPlayer(target);

        if (targetPlayer != null) {
            return true;
        }
        
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
        return null;
    }
}
