package logic.turn;

import logic.PlayRuntime;
import logic.map.*;
import logic.player.Player;
import java.util.List;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class TurnStrategyAggressive extends TurnStrategy {

    /**
     * @override This method is used for find path
     * @return Path
     */
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

    /**
     * @override This method is used for couldAttack
     * @param target Point
     * @return Boolean
     */
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

    /**
     * @override This method is used for couldInteract
     * @param target Point
     * @return Boolean
     */
    @Override
    protected boolean couldInteract(Point target) {
        PlayRuntime runtime = PlayRuntime.currentRuntime();
        GameMap map = runtime.getMap();

        Cell targetCell = map.getCell(target);

        if (targetCell != null){
            if (targetCell instanceof Chest) {
                return true;
            }
        }

        return false;
    }

    /**
     * @override This method is used for preferredAttackingLocation
     * @return Point
     */
    @Override
    public Point preferredAttackingLocation() {
        List<Point> attackTargets = attackTargetsInNear();

        if (attackTargets != null){
            return attackTargets.get(0);
        }

        return null;
    }

    @Override
    public Point preferredInteractionLocation() {
        List<Point> interactTargets = interactTargetsInNear();

        if (interactTargets != null){
            return interactTargets.get(0);
        }

        return null;
    }
}
