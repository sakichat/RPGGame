package logic.turn;

import logic.PlayRuntime;
import logic.map.*;
import logic.player.Player;
import java.util.LinkedList;
import java.util.List;


public class TurnStrategyComputer extends TurnStrategy {
    @Override
    public Path preferredMovingPath() {
        PlayRuntime runtime = PlayRuntime.currentRuntime();
        GameMap map = runtime.getMap();
        GameMapGraph gameMapGraph = map.getGraph();
        Point target = null;

        if (map.finishObjective()) {
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

    @Override
    public boolean couldAttack(Point target) {

        return false;
    }

    @Override
    protected boolean couldInteract(Point target) {
//        boolean result = false;
//        Play play = PlayRuntime.currentRuntime().getPlay();
//        GameMap gameMap = play.currentMap();
//        Cell cell = gameMap.getCell(target);
//        if (cell.getCellType().equals(Cell.Type.CHEST)){
//            result = true;
//        }
//        if (cell == null){
//            return result;
//        }else {
//            if (cell.getCellType().equals(Cell.Type.PLAYER)){
//                Player targetPlayer = (Player)cell;
//                if ((targetPlayer.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE))){
//                    if (targetPlayer.isAlive()){
//                        result = true;
//                    }
//                }
//            }
//        }
//
//        return result;

        return false;
    }

    @Override
    public Point preferredAttackingLocation() {
//        List<Point> points = attackTargetsInNear();
//        if (points.size() != 0){
//            Point result = points.get((int)(Math.random() * points.size()));
//            return result;
//        }else {
//            return null;
//        }
        return null;
    }

    @Override
    public Point preferredInteractionLocation() {
//        GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();
//        List<Point> points = interactTargetsInNear();
//        if (points.size() != 0){
//            Point result = points.get((int)(Math.random() * points.size()));
//            return result;
//        }else {
//            return null;
//        }

        return null;
    }
}
