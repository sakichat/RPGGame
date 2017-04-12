package logic.turn;

import logic.PlayRuntime;
import logic.map.*;
import logic.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public abstract class TurnStrategy {
    protected Player player;

    public final Player getPlayer() {
        return player;
    }

    public final void setPlayer(Player player) {
        this.player = player;
    }

    public abstract Path preferredMovingPath();

    public final List<Point> attackTargetsInNear(){
        GameMap gameMap = PlayRuntime.currentRuntime().getMap();
        GameMapGraph gameMapGraph = gameMap.getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), player.getRangeForAttack());

//        points = points.stream()
//                .filter(i -> {
//                    Cell cell = gameMap.getCell(i);
//                    if (cell == null) {
//                        return false;
//                    }
//
//                    if (!(cell instanceof Player)){
//                        return false;
//                    }
//
//                    Player player = (Player) cell;
//                    return player.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE);
//                })
//                .collect(Collectors.toList());


        points = points.stream()
                .map(gameMap::getCell)
                .filter(c -> c != null && c instanceof Player)
                .map(c -> (Player)c)
                .filter(p -> p.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE))
                .map(Player::getLocation)
                .collect(Collectors.toList());
        return points;

    }

    public abstract boolean couldAttack(Point target);

    public final List<Point> interactTargetsInNear(){

        GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), 1).stream()
                .filter(i -> couldInteract(i))
                .collect(Collectors.toList());
        return points;
    }

    protected abstract boolean couldInteract(Point target);

    public abstract Point preferredAttackingLocation();

    public abstract Point preferredInteractionLocation();


}
