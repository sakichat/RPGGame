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
    /**
     * attribute
     */
    protected Player player;

    /**
     * player getter
     * @return Player
     */
    public final Player getPlayer() {
        return player;
    }

    /**
     * player setter
     * @param player
     */
    public final void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * abstract method
     * @return Path
     */
    public abstract Path preferredMovingPath();

    /**
     * This method is used for attackTargetsInNear
     * @return List
     */
    public final List<Point> attackTargetsInNear(){
        GameMap gameMap = PlayRuntime.currentRuntime().getMap();
        GameMapGraph gameMapGraph = gameMap.getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), player.getRangeForAttack());

        points = points.stream()
                .filter(p -> couldAttack(p))
                .collect(Collectors.toList());
        return points;

    }

    /**
     * abstract method
     * @param target
     * @return Boolean
     */
    public abstract boolean couldAttack(Point target);

    /**
     * This method is used to interactTargetsInNear
     * @return List
     */
    public final List<Point> interactTargetsInNear(){

        GameMapGraph gameMapGraph = PlayRuntime.currentRuntime().getMap().getGraph();
        List<Point> points = gameMapGraph.pointsInRange(player.getLocation(), 1);
        points = points.stream()
                .filter(i -> couldInteract(i))
                .collect(Collectors.toList());
        return points;
    }

    /**
     * abstract method
     * @param target
     * @return Boolean
     */
    protected abstract boolean couldInteract(Point target);


    /**
     * This is a method for preferredAttackingLocation
     * @return Point
     */
    public abstract Point preferredAttackingLocation();

    /**
     * This is a method for preferredInteractionLocation
     * @return Point
     */
    public abstract Point preferredInteractionLocation();


}
