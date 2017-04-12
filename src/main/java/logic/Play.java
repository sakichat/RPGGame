package logic;

import com.google.gson.annotations.Expose;
import logic.map.Cell;
import logic.map.GameMap;
import logic.map.Point;
import logic.player.Player;
import persistence.MapFileManager;

import java.util.*;

/**
 * @author Qi Xia
 * @version 0.2
 * This is the class for play.
 */
public class Play extends Observable{

    //  =======================================================================
    //  Section - Basic
    //  =======================================================================

    @Expose
    private String name;


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

    //  =======================================================================
    //  Section - Context
    //  =======================================================================

    @Expose
    private Player mainPlayer;

    /**
     * Getter for mainPlayer
     * @return Player
     */
    public Player getMainPlayer() {
        return mainPlayer;
    }

    /**
     * Setter for mainPlayer
     * @param mainPlayer
     */
    public void setMainPlayer(Player mainPlayer) {
        this.mainPlayer = mainPlayer;
    }

    //  =======================================================================
    //  Section - Campaign
    //  =======================================================================


    @Expose
    private Campaign campaign;

    @Expose
    private int currentMapIndex;

    @Expose
    private GameMap currentMap;


    /**
     * This is the method for get currentMap,
     * and add mainPlayer into the map(enter).
     */
    public void resolveMap(){
        String mapName = campaign.getMapName(currentMapIndex);
        currentMap = MapFileManager.read(mapName);
        enterIntoMap(mainPlayer);
        resolvePlayersOrder();
    }


    /**
     * This is a method makes mainPlayer enter into the map.
     * @return Point
     */
    private void enterIntoMap(Player player){
        Point entrance = currentMap.getEntrances().get(0).getLocation();

        List<Point.Direction> directions = Point.Direction.directions();
        for (Point.Direction direction : directions) {
            Point enter = entrance.add(direction);

            if (currentMap.canPlace(enter)){
                currentMap.addCell(player, enter);
                currentMap.adaptEquipments(player.getLevel());
                break;
            }
        }
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
     * Getter for currentMap.
     * @return GameMap
     */
    public GameMap getCurrentMap() {
        return currentMap;
    }

    //  =======================================================================
    //  Section - Order
    //  =======================================================================

    private int currentPlayerIndex;

    private LinkedList<Player> playerOrders;

    /**
     * This is the method for sort the players in play list
     */
    public void resolvePlayersOrder(){
        playerOrders = new LinkedList<>(currentMap.getPlayers());
        Map<Player, Integer> initiativeValues = new HashMap<Player, Integer>();

        int sortStandard;

        for (Player sortingPlayer : playerOrders) {
            int diceScore = Dice.rool(20);
            int dexScore = sortingPlayer.getTotalAbilityModifier(Player.ABILITY_DEX);
            sortStandard = diceScore + dexScore;
            initiativeValues.put(sortingPlayer, sortStandard);
        }

        Collections.sort(playerOrders, new Comparator<Player>() {
                    @Override
                    public int compare(Player o1, Player o2) {
                        return initiativeValues.get(o2).compareTo(initiativeValues.get(o1));
                    }
                }
        );
    }

    public Player currentPlayer(){
        return playerOrders.get(currentMapIndex);
    }

    public Player nextPlayer(){
        currentPlayerIndex += 1;
        currentPlayerIndex %= playerOrders.size();
        return currentPlayer();
    }

    //  =======================================================================
    //  Section - Target
    //  =======================================================================

    private Point targetLocation;

    public Cell getTarget(){
        return currentMap.getCell(targetLocation);
    }

    public Point getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Point targetLocation) {
        this.targetLocation = targetLocation;
    }


    //  =======================================================================
    //  Section - Observer
    //  =======================================================================

    public static class Update{
        public static String RANGE = "play range";
    }

    //  =======================================================================
    //  Section - Range
    //  =======================================================================

    public enum RangeIndicationMode {
        MOVE("movement"), ATTACK("attack");

        private String name;

        RangeIndicationMode(String name) {
            this.name = name;
        }

        public String getImageName(){
            String imageName = "data/images/" + name+ "_range.png";

            return imageName;
        }
    }

    private RangeIndicationMode rangeIndicationMode;

    private List<Point> rangeIndicationLocations;

    public RangeIndicationMode getRangeIndicationMode() {
        return rangeIndicationMode;
    }

    public List<Point> getRangeIndicationLocations() {
        return rangeIndicationLocations;
    }

    public void setRangeIndication(List<Point> locations, RangeIndicationMode mode){
        rangeIndicationLocations = locations;
        rangeIndicationMode = mode;

        setChanged();
        notifyObservers(Update.RANGE);
    }
}