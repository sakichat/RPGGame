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
     * This is a method makes mainPlayer enter into the map.
     * @return Point
     */

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

    private int currentPlayerIndex;

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

    public Player currentPlayer(){
        return playerOrders.get(currentPlayerIndex);
    }

    public Player nextPlayer(){
        currentPlayerIndex += 1;
        currentPlayerIndex %= playerOrders.size();
        Logger.getInstance().log("turn to " + currentPlayer());

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


    private boolean targetLocationEnabled;

    private Point targetLocation;

    public Cell getTarget(){
        return currentMap.getCell(targetLocation);
    }

    public boolean isTargetLocationEnabled() {
        return targetLocationEnabled;
    }

    public void setTargetLocationEnabled(boolean targetLocationEnabled) {
        this.targetLocationEnabled = targetLocationEnabled;
        setChanged();
        notifyObservers(Update.TARGET);
    }

    public Point getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Point targetLocation) {
        this.targetLocation = targetLocation;
        setTargetLocationEnabled(true);
    }


    //  =======================================================================
    //  Section - Observer
    //  =======================================================================

    public static class Update{
        public static String RANGE = "play range";
        public static String TARGET = "play target";
        public static String CURRENT = "play current";
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
            return name + "_range.png";
        }
    }


    private boolean rangeIndicationEnabled;

    private RangeIndicationMode rangeIndicationMode = RangeIndicationMode.MOVE;

    private List<Point> rangeIndicationLocations;

    public void setRangeIndication(List<Point> locations, RangeIndicationMode mode){
        rangeIndicationLocations = locations;
        rangeIndicationMode = mode;
        setRangeIndicationEnabled(true);
    }

    public boolean isRangeIndicationEnabled() {
        return rangeIndicationEnabled;
    }

    public void setRangeIndicationEnabled(boolean rangeIndicationEnabled) {
        this.rangeIndicationEnabled = rangeIndicationEnabled;
        setChanged();
        notifyObservers(Update.RANGE);
    }

    public RangeIndicationMode getRangeIndicationMode() {
        return rangeIndicationMode;
    }

    public List<Point> getRangeIndicationLocations() {
        return rangeIndicationLocations;
    }


}