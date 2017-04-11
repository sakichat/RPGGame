package logic.turn;

import logic.Play;
import logic.map.Cell;
import logic.map.GameMap;
import logic.map.GameMapGraph;
import logic.map.Point;
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

    protected abstract Point preferredNextLocation();

    public final List<Point> attackTargetsInNear(){
        GameMap gameMap = Play.getCurrentPlay().getCurrentMap();
        GameMapGraph gameMapGraph = gameMap.getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), player.getRangeForAttack()).stream().filter(i -> {if ((Player)(gameMap.getCell(i)))}).collect(Collectors.toList());
        return points;

    }

    public abstract boolean couldAttack(Point target);

    public final List<Point> interactTargetsInNear(){

        GameMapGraph gameMapGraph = Play.getCurrentPlay().getCurrentMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), 1).stream().filter(i -> couldInteract(i)).collect(Collectors.toList());
        return points;
    }

    protected abstract boolean couldInteract(Point target);

    public abstract Point preferredAttackingLocation();

    public abstract Point preferredInteractionLocation();


}
