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

    private String name;

    private Campaign campaign;
    private Player player;

    private int currentMapIndex;
    private GameMap currentMap;

    private Point direction;

    /**
     * Getter for name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for campaign
     * @return
     */
    public Campaign getCampaign() {
        return campaign;
    }

    /**
     * Setter for campaign
     * @param campaign
     */
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;

        currentMap = MapFileManager.read(campaign.getMapName(currentMapIndex));
    }

    /**
     * Getter for player
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter for player
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * This is the method for get currentMap,
     * and add player into the map(enter).
     */
<<<<<<< Updated upstream
    public void resolveMap(){
=======
    private void resolveMap(){

        currentMap = MapFileManager.read(campaign.getMapName(currentMapIndex));
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
     */
    public void move(){

    }
    /**
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


    /**
     * This is the method for remove empty chest.
     */
    public void removeChest() {
        Point location = player.getLocation();
        Point chestPoint = location.add(direction);

        if (currentMap.getCell(chestPoint) instanceof Chest) {
            Chest chest = (Chest) currentMap.getCell(chestPoint);
            if (!chest.isChestEmpty()) {
                currentMap.removeCell(chestPoint);
            }
        }
    }
}
