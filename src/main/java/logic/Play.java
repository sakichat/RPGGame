package logic;

import persistence.MapFileManager;

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

    private Point direction;

    /**
     * This is the method for get currentMap,
     * and add player into the map(enter).
     */
    private void resolveMap(){
        currentMap = MapFileManager.read(campaign.getMapName(currentMapIndex));
        Point enterPoint = enterIntoMap();
        currentMap.addCell(player, enterPoint);
    }

    /**
     * This is the method for exit from currentMap,
     * move into next map.
     */
    public void moveToNextMap(){
        currentMapIndex++;
        resolveMap();
    }

    /**
     * This is get method for currentMap.
     * @return GameMap
     */
    public GameMap getCurrentMap() {
        return currentMap;
    }

    /**
     * This is the method to make player move.
     */
    public void move(){
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

    public void removeChest(){

    }
}
