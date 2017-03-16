package logic;

import java.util.LinkedList;

/**
 * @author Qi Xia
 * @version 0.2
 * This is the class for play.
 */

/**
 * interact method
 * remove chest if == null
 * remove player if inventory == null
 */
public class Play {
    private Campaign campaign;
    private Player player;

    private int currentMapIndex;
    private GameMap currentMap;

    private void resolveMap(){
//        currentMap = ...
        Point enterPoint = enterIntoMap();
        currentMap.addCell(player, enterPoint);
    }

    public void moveToNextMap(){
        currentMapIndex++;
        resolveMap();
    }

    public GameMap getCurrentMap() {
        return currentMap;
    }

    /**
     * This is the method to make player move.
     * @param direction
     */
    public void move(Point direction){
        Point location = player.getLocation();
        Point targetLocation = location.add(direction);

        if (!currentMap.hasCell(targetLocation)){
            currentMap.moveCell(location, location.add(direction));
        }
    }

    /**
     * This is a method makes player enter into the map.
     * @return Point
     */
    public Point enterIntoMap(){
        Point enterPoint = null;
        Entrance entrance = currentMap.getEntrances().get(0);
        LinkedList<Point> enterPointChoices = entrance.getLocation().directions();
        for (Point enterPointChoice : enterPointChoices) {
            if (enterPointChoice == null){
                enterPoint = enterPointChoice;
                break;
            }
        }

        return enterPoint;
    }
}
