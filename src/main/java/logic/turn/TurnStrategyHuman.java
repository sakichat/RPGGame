package logic.turn;

import logic.PlayRuntime;
import logic.map.*;
import logic.player.Player;

import java.util.List;

public class TurnStrategyHuman extends TurnStrategy {
    @Override
    public Path preferredMovingPath() {
        TurnThread.waitForUser(TurnThread.UserResponse.MOVE);
        Point targetLocation = PlayRuntime.currentRuntime().getPlay().getTargetLocation();

        GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();

        return gameMapGraph.path(player.getLocation(), targetLocation, player.getRangeForMove());
    }

    @Override
    public boolean couldAttack(Point target) {
        PlayRuntime runtime = PlayRuntime.currentRuntime();
        GameMap map = runtime.getMap();

        Player targetPlayer = map.getPlayer(target);
        if (targetPlayer.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE)) {
            return true;
        }

        return false;
    }

    @Override
    protected boolean couldInteract(Point target) {
        PlayRuntime runtime = PlayRuntime.currentRuntime();
        GameMap map = runtime.getMap();

        Cell targetCell = map.getCell(target);
        if (targetCell instanceof Chest || player.isDead()){
            return true;
        }

        return false;
    }

    @Override
    public Point preferredAttackingLocation() {
        TurnThread.waitForUser(TurnThread.UserResponse.ATTACK);
        return PlayRuntime.currentRuntime().getPlay().getTargetLocation();
    }

    @Override
    public Point preferredInteractionLocation() {
        TurnThread.waitForUser(TurnThread.UserResponse.INTERACT);
        return PlayRuntime.currentRuntime().getPlay().getTargetLocation();
    }
}
