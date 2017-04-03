package logic;

import com.google.gson.annotations.Expose;
import persistence.MapFileManager;

import java.util.*;

/**
 * @author Qi Xia
 * @version 0.2
 * This is the class for play.
 */
public class Play {

    @Expose
    private String name;

    @Expose
    private Campaign campaign;

    @Expose
    private Player player;

    @Expose
    private int currentMapIndex;

    @Expose
    private Point direction;

    private GameMap currentMap;

    /**
     * Getter for name.
     * @return String
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
     * @return Campaign
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
     * @return Player
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
     * Getter for direction
     * @return direction
     */
    public Point getDirection() {
        return direction;
    }

    /**
     * Setter for direction
     * @param direction
     */
    public void setDirection(Point direction) {
        this.direction = direction;
    }

    /**
     * Getter for currentMap.
     * @return GameMap
     */
    public GameMap getCurrentMap() {
        return currentMap;
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
     * This is the method for judging
     * whether currentMap is the last map in campaign.
     * @return Boolean
     */
    public boolean isLastMap(){
        int campaignSize = campaign.getMapNames().size();
        if (currentMapIndex == (campaignSize - 1)) {
            return true;
        }
        return false;
    }

    /**
     * This is the method for sort the players in play list
     * @return playerList LinkedList
     */
    public LinkedList<Player> playerSortList(){
        LinkedList<Player> playerList = currentMap.getPlayers();
        Map<Player, Integer> initutiveValues = new HashMap<Player, Integer>();

        int sortStandard;

        for (Player sortingPlayer : playerList) {
            int diceScore = Dice.rool(20);
            int dexScore = sortingPlayer.getAbilityModifier(sortingPlayer.ABILITY_DEX);
            sortStandard = diceScore + dexScore;
            initutiveValues.put(sortingPlayer, sortStandard);
        }

        Collections.sort(playerList, new Comparator<Player>() {
                    @Override
                    public int compare(Player o1, Player o2) {
                        return initutiveValues.get(o2).compareTo(initutiveValues.get(o1));
                    }
                }
        );

        return playerList;
    }

    /**
     * This is the method to make player move.
     */
    public void move(){
        Point location = player.getLocation();
        Point targetLocation = location.add(direction);

        if (currentMap.canPlace(targetLocation)){
            currentMap.moveCell(location, targetLocation);
        }
    }

    /**
     * This is the method to limit player's movement.
     * @param originalPoint Point
     */
    public void movementLimit(Point originalPoint){
        Point currentLocation = player.getLocation();
        int differenceX = Math.abs(originalPoint.getX() - currentLocation.getX());
        int differenceY = Math.abs(originalPoint.getY() - currentLocation.getY());
        int difference = differenceX + differenceY;

        if (difference <= 3) {
            move();
        }
    }

    /**
     * This is a method makes player enter into the map.
     * @return Point
     */
    private void enterIntoMap(){
        Point entrance = currentMap.getEntrances().get(0).getLocation();

        LinkedList<Point> directions = Point.directions();
        for (Point direction : directions) {
            Point enter = entrance.add(direction);

            if (currentMap.canPlace(enter)){
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
    private void mapLevelRefresh() {

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
     * This method is used for judge whether the objectives are fulfilled
     * @return Boolean
     */
    public Boolean isObjective() {
        List<Player> players = currentMap.getPlayers();
        List<Player> hostilePlayers = new LinkedList<Player>();

        for (Player player : players) {
            if (player.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE)) {
                hostilePlayers.add(player);
            }
        }

        boolean objectiveFulfilled = true;

        for (Player hostilePlayer : hostilePlayers) {
            if (!hostilePlayer.isDead()) {
                objectiveFulfilled = false;
            }
        }

        return objectiveFulfilled;
    }

    /**
     * This is the method for get target cell in direction
     * @return Cell
     */
    public Cell getTartget(){
        Point location = player.getLocation();
        Point targetLocation = location.add(direction);
        Cell cell = currentMap.getCell(targetLocation);
        return cell;
    }

    /**
     * This method is used for removing chest when it is empty.
     */
    public void refreshChest() {
        Point location = player.getLocation();
        Point chestPoint = location.add(direction);

        Chest chest = (Chest) currentMap.getCell(chestPoint);
        if (chest.isChestEmpty()) {
            currentMap.removeCell(chestPoint);
        }
    }

    /**
     * This method is used for removing dead player when his inventory is empty.
     */
    public void refreshPlayer( ) {

        Player targetPlayer = (Player)getTartget();

        Point location = player.getLocation();
        Point targetLocation = location.add(direction);

        int size = targetPlayer.getInventories().size();
        if (size == 0) {
            currentMap.removeCell(targetLocation);
        }
    }

}