package logic.turn;

import logic.PlayRuntime;
import logic.map.*;
import logic.player.Player;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Li Zhen
 * @version 0.3
 */
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

        points = points.stream()
                .filter(p -> couldAttack(p))
                .collect(Collectors.toList());
        return points;

    }

    public abstract boolean couldAttack(Point target);

    public final List<Point> interactTargetsInNear(){

        GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), 1);
        points = points.stream()
                .filter(i -> couldInteract(i))
                .collect(Collectors.toList());
        return points;
    }

    protected abstract boolean couldInteract(Point target);

    public abstract Point preferredAttackingLocation();

    public abstract Point preferredInteractionLocation();


}
