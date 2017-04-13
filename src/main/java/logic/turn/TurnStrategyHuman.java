package logic.turn;

import logic.Play;
import logic.PlayRuntime;
import logic.map.*;
import logic.player.Player;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class TurnStrategyHuman extends TurnStrategy {

    /**
     * @override This method is used for find path
     * @return Path
     */
    @Override
    public Path preferredMovingPath() {
        TurnThread.waitForUser(TurnThread.UserResponse.MOVE);
        Play play = PlayRuntime.currentRuntime().getPlay();

        if (play.isTargetLocationEnabled()){
            Point targetLocation = play.getTargetLocation();
            GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();
            gameMapGraph.addIgnoreType(Cell.Type.PLAYER);
            return gameMapGraph.path(player.getLocation(), targetLocation, player.getRangeForMove());
        } else {
            return new Path();
        }
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
        return targetPlayer != null;
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

            if (targetCell instanceof Chest){
                return true;

            } else if (targetCell instanceof Exit){
                return true;

            } else if (targetCell instanceof Player) {
                Player targetPlayer = (Player) targetCell;
                if (targetPlayer.getPlayerParty().equals(Player.PLAYER_PARTY_FRIENDLY)){
                    return true;
                } else if (targetPlayer.isDead()){
                    return true;
                }
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
        TurnThread.waitForUser(TurnThread.UserResponse.ATTACK);

        Play play = PlayRuntime.currentRuntime().getPlay();
        if (play.isTargetLocationEnabled()){
            return play.getTargetLocation();
        } else {
            return null;
        }
    }

    /**
     * @override This method is used for preferredInteractionLocation
     * @return Point
     */
    @Override
    public Point preferredInteractionLocation() {
        TurnThread.waitForUser(TurnThread.UserResponse.INTERACT);

        Play play = PlayRuntime.currentRuntime().getPlay();
        if (play.isTargetLocationEnabled()){
            return play.getTargetLocation();
        } else {
            return null;
        }
    }
}
