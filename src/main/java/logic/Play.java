package logic;

import persistence.MapFileManager;

import java.util.LinkedList;
import java.util.List;

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

//    To test if targetLocation has set already
//    private Point targetLocation;
//
//    public Point getTargetLocation() {
//        return targetLocation;
//    }

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

    public Point getDirection() {
        return direction;
    }

    public void setDirection(Point direction) {
        this.direction = direction;
    }

    /**
     * This is the method for get currentMap,
     * and add player into the map(enter).
     */
    public void resolveMap(){
        String mapName = campaign.getMapName(currentMapIndex);
        currentMap = MapFileManager.read(mapName);
        enterIntoMap();
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
            currentMap.moveCell(location, targetLocation);
        }
    }

    /**
     * This is a method makes player enter into the map.
     * @return Point
     */
    public void enterIntoMap(){
        Point entrance = currentMap.getEntrances().get(0).getLocation();

        LinkedList<Point> directions = Point.directions();
        for (Point direction : directions) {
            Point enter = entrance.add(direction);

            if (currentMap.inMap(enter) && !currentMap.hasCell(enter)){
                currentMap.addCell(player, enter);
                this.direction = direction;
                mapLevelRefresh();
                break;
            }
        }
    }

    /**
     * This method is to refresh level of all the characters and chests on the map.
     */
    private void mapLevelRefresh(){

        List<Chest> chests = currentMap.getChests();
        List<Player> players = currentMap.getPlayers();

        int level = player.getLevel();

        for (Player character : players) {
            if (!character.equals(Player.PLAYER_PARTY_PLAYER)){
                character.setLevel(level);
                character.inventoryLevelRefresh();
            }
        }

        for (Chest chest : chests) {
            chest.chestLevelRefresh(level);
        }

    }

    /**
     * This method is used for removing chest when it is empty.
     */
    public void refreshChest(){
        Point location = player.getLocation();
        Point chestPoint = location.add(direction);

        if (currentMap.getCell(chestPoint) instanceof Chest){
            Chest chest = (Chest) currentMap.getCell(chestPoint);
            if (!chest.isChestEmpty()){
                currentMap.removeCell(chestPoint);
            }
        }
    }

    public void removePlayer(){

    }

}
