package logic.turn;

import logic.Play;
import logic.PlayRuntime;
import logic.map.*;
import logic.player.Player;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Zhen
 * @version 0.3
 */
public class TurnStrategyComputer extends TurnStrategy {

    /**
     * @override This method is used for find path
     * @return Path
     */
    @Override
    public Path preferredMovingPath() {
        PlayRuntime runtime = PlayRuntime.currentRuntime();
        GameMap map = runtime.getMap();
        GameMapGraph gameMapGraph = map.getGraph();
        gameMapGraph.addIgnoreType(Cell.Type.CHEST);
        gameMapGraph.addIgnoreType(Cell.Type.PLAYER);

        Point target = null;

        if (map.finishObjective()) {
            gameMapGraph.addIgnoreType(Cell.Type.EXIT);
            target = map.getExits().get(0).getLocation();
            return gameMapGraph.path(player.getLocation(), target, player.getRangeForMove());
        }

        List<Player> players = map.getPlayers();
        LinkedList<Player> hostilePlayers = new LinkedList<>();
        for (Player p : players) {
            if (p.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE)) {
                hostilePlayers.add(p);
            }
        }

        int checkDistance = Integer.MAX_VALUE;
        for (Player hostilePlayer : hostilePlayers) {
            int distance = gameMapGraph.distanceBetween(player.getLocation(), hostilePlayer.getLocation());
            if (checkDistance > distance) {
                checkDistance = distance;
                target = hostilePlayer.getLocation();
            }
        }

        return gameMapGraph.path(player.getLocation(), target, player.getRangeForMove());
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
            if (targetPlayer.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE)) {
                return true;
            }
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

        if (targetCell != null) {
            if (targetCell instanceof Exit){
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

    /**
     * @override This method is used for preferredInteractionLocation
     * @return Point
     */
    @Override
    public Point preferredInteractionLocation() {
        List<Point> targetsInNear = interactTargetsInNear();

        if (targetsInNear != null){
            return targetsInNear.get(0);
        }
        
        return null;
    }
}
