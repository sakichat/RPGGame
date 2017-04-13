package logic;

import com.google.gson.annotations.Expose;
import logic.map.Cell;
import logic.map.GameMap;
import logic.map.Point;
import logic.player.Player;
import logic.turn.TurnStrategyAggressive;
import logic.turn.TurnStrategyFriendly;
import persistence.MapFileManager;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Qi Xia
 * @version 0.3
 * This is the class for play.
 */
public class Play extends Observable{

    //  =======================================================================
    //  Section - Basic
    //  =======================================================================

    /**
     * property of name
     */
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

    /**
     * property of mainPlayer
     */
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

    /**
     * property of campaign
     */
    @Expose
    private Campaign campaign;

    /**
     * property of currentMapIndex
     */
    @Expose
    private int currentMapIndex;

    /**
     * property of currentMap
     */
    @Expose
    private GameMap currentMap;

    /**
     * The method of setCurrentMap
     */
    public void setCurrentMap(GameMap currentMap) {
        this.currentMap = currentMap;
    }

    /**
     * This is the method for get currentMap,
     * and add mainPlayer into the map(enter).
     */
    public void resolveMap(){
        String mapName = campaign.getMapName(currentMapIndex);
        currentMap = MapFileManager.read(mapName);
        currentMap.enter(mainPlayer);
        initStrategy();
        initTurnOrder();
    }

    /**
     * The method of initStrategy
     */
    private void initStrategy(){
        List<Player> players = currentMap.getPlayers();
        for (Player player : players) {
            if (player.getPlayerParty().equals(Player.PLAYER_PARTY_FRIENDLY)) {
                player.setStrategy(new TurnStrategyFriendly());

            } else if (player.getPlayerParty().equals(Player.PLAYER_PARTY_HOSTILE)) {
                player.setStrategy(new TurnStrategyAggressive());
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
    public GameMap currentMap() {
        return currentMap;
    }

    //  =======================================================================
    //  Section - Order
    //  =======================================================================

    /**
     * property of currentPlayerIndex
     */
    private int currentPlayerIndex;

    /**
     * property of playerOrders
     */
    private LinkedList<Player> playerOrders;

    /**
     * This is the method for sort the players in play list
     */
    public void initTurnOrder(){
        playerOrders = new LinkedList<>(currentMap.getPlayers());
        Map<Player, Integer> initiativeValues = new HashMap<Player, Integer>();

        int sortStandard;

        for (Player sortingPlayer : playerOrders) {
            int diceScore = Dice.roll(20);
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
        List<String> orders = playerOrders.stream().map(p -> p.toString()).collect(Collectors.toList());
        Logger.getInstance().log(orders.toString());
    }

    /**
     * The method of currentPlayer
     * @return Player
     */
    public Player currentPlayer(){
        if (playerOrders == null){
            initTurnOrder();
        }
        return playerOrders.get(currentPlayerIndex);
    }

    /**
     * The method of nextPlayer
     * @return Player
     */
    public Player nextPlayer(){
        currentPlayerIndex += 1;
        currentPlayerIndex %= playerOrders.size();
        updateCurrent();
        return currentPlayer();
    }

    public void updateCurrent(){
        setChanged();
        notifyObservers(Update.CURRENT);
    }


    //  =======================================================================
    //  Section - Target
    //  =======================================================================

    /**
     * Property of targetLocationEnabled
     */
    private boolean targetLocationEnabled;

    /**
     * Property of targetLocation
     */
    private Point targetLocation;

    /**
     * The method of getTarget
     * @return Cell
     */
    public Cell getTarget(){
        return currentMap.getCell(targetLocation);
    }

    /**
     * The method of isTargetLocationEnabled
     * @return boolean
     */
    public boolean isTargetLocationEnabled() {
        return targetLocationEnabled;
    }

    /**
     * The method of setTargetLocationEnabled
     * @param targetLocationEnabled boolean
     */
    public void setTargetLocationEnabled(boolean targetLocationEnabled) {
        this.targetLocationEnabled = targetLocationEnabled;
        setChanged();
        notifyObservers(Update.TARGET);
    }

    /**
     * The method of getTargetLocation
     * @return
     */
    public Point getTargetLocation() {
        return targetLocation;
    }

    /**
     * The method of setTargetLocation
     * @param targetLocation Point
     */
    public void setTargetLocation(Point targetLocation) {
        this.targetLocation = targetLocation;
        setTargetLocationEnabled(true);
    }


    //  =======================================================================
    //  Section - Observer
    //  =======================================================================

    /**
     * The method of Update
     */
    public static class Update{
        public static String RANGE = "play range";
        public static String TARGET = "play target";
        public static String CURRENT = "play current";
    }

    //  =======================================================================
    //  Section - Range
    //  =======================================================================

    /**
     * The method of RangeIndicationMode
     */
    public enum RangeIndicationMode {
        MOVE("movement"), ATTACK("attack"), INTERACT("interact");

        private String name;

        RangeIndicationMode(String name) {
            this.name = name;
        }

        public String getImageName(){
            return name + "_range.png";
        }
    }

    /**
     * property of rangeIndicationEnabled
     */
    private boolean rangeIndicationEnabled;

    /**
     * property of rangeIndicationMode
     */
    private RangeIndicationMode rangeIndicationMode = RangeIndicationMode.MOVE;

    /**
     * property of rangeIndicationLocations
     */
    private List<Point> rangeIndicationLocations;

    /**
     * The method of setRangeIndication
     * @param locations List
     * @param mode RangeIndicationMode
     */
    public void setRangeIndication(List<Point> locations, RangeIndicationMode mode){
        rangeIndicationLocations = locations;
        rangeIndicationMode = mode;
        setRangeIndicationEnabled(true);
    }

    /**
     * The method of isRangeIndicationEnabled
     * @return
     */
    public boolean isRangeIndicationEnabled() {
        return rangeIndicationEnabled;
    }

    /**
     * The method of setRangeIndicationEnabled
     * @param rangeIndicationEnabled boolean
     */
    public void setRangeIndicationEnabled(boolean rangeIndicationEnabled) {
        this.rangeIndicationEnabled = rangeIndicationEnabled;
        setChanged();
        notifyObservers(Update.RANGE);
    }

    /**
     * The method of getRangeIndicationMode
     * @return RangeIndicationMode
     */
    public RangeIndicationMode getRangeIndicationMode() {
        return rangeIndicationMode;
    }

    /**
     * The method of getRangeIndicationLocations
     * @return List
     */
    public List<Point> getRangeIndicationLocations() {
        return rangeIndicationLocations;
    }


}