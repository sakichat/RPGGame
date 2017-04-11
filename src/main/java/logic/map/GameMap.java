package logic.map;

import com.google.gson.annotations.Expose;
import logic.player.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Qi Xia
 * @version 0.2
 * this class is the map
 */
public class GameMap {

    @Expose
    private String name;

    @Expose
    private int width;

    @Expose
    private int height;

    @Expose
    private Cell[][] cells;

    /**
     * this method is to get width
     * @return Integer
     */
    public int getWidth() {
        return width;
    }

    /**
     * this method is to set width
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
        cells = new Cell[height][width];
    }

    /**
     * this method is to get height
     * @return Integer
     */
    public int getHeight() {
        return height;
    }

    /**
     * this method is to set height
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
        cells = new Cell[height][width];
    }

    /**
     * this method is to set name of map
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * this method is to get name of map
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * this method is to add cell
     * @param cell Cell
     * @param location Point
     */
    public void addCell(Cell cell, Point location){
        int x = location.getX();
        int y = location.getY();
        cells[y][x] = cell;

        cell.location = location;
    }

    /**
     * this method is to remove cell
     * @param location Point
     */
    public void removeCell(Point location){
        int x = location.getX();
        int y = location.getY();
        cells[y][x] = null;
    }

    /**
     * this method is to get cell
     * @param location Point
     * @return Cell
     */
    public Cell getCell(Point location){
        if (!pointInMap(location)) {
            return null;
        }

        int x = location.getX();
        int y = location.getY();
        return cells[y][x];
    }

    /**
     * this method is to judge if there is a cell
     * @param location Point
     * @return Boolean
     */
    public boolean hasCell(Point location){
        if (!pointInMap(location)){
            return false;
        }

        return getCell(location) != null;
    }

    /**
     * this method is to judge if this location can place cell
     * @param location
     * @return Boolean
     */
    public boolean canPlace(Point location){
        if (pointInMap(location)) {
            return !hasCell(location);
        }

        return false;
    }


    /**
     * this method is to move cell
     * @param startPoint Point
     * @param endPoint Point
     */
    public void moveCell(Point startPoint, Point endPoint){

        int startX = startPoint.getX();
        int startY = startPoint.getY();
        int endX = endPoint.getX();
        int endY = endPoint.getY();

        Cell cell = cells[startY][startX];
        cells[endY][endX] = cell;
        cells[startY][startX] = null;
        cell.setLocation(endPoint);
    }

    /**
     * this method is to get all entrances
     * @return List<Entrance>
     */
    public List<Entrance> getEntrances(){
        LinkedList<Entrance> entrances = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j] instanceof Entrance){
                    Cell cell = cells[i][j];
                    Entrance entrance = (Entrance) cell;
                    entrances.add(entrance);
                }
            }
        }

        return entrances;
    }

    /**
     * this method is to get all Exists
     * @return List<Exit>
     */
    public List<Exit> getExits() {
        LinkedList<Exit> exits = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j] instanceof Exit){
                    Cell cell = cells[i][j];
                    Exit exit = (Exit) cell;
                    exits.add(exit);
                }
            }
        }
        return exits;
    }

    /**
     * this method is to get all players on the map
     * @return List<Player>
     */
    public LinkedList<Player> getPlayers(){
        LinkedList<Player> players = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j] instanceof Player){
                    Cell cell = cells[i][j];
                    Player player = (Player) cell;
                    players.add(player);
                }
            }
        }
        return players;
    }

    /**
     * this method is to get all chests on the map
     * @return List<Chest>
     */
    public List<Chest> getChests(){
        LinkedList<Chest> chests = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j] instanceof Chest){
                    Cell cell = cells[i][j];
                    Chest chest = (Chest) cell;
                    chests.add(chest);
                }
            }
        }
        return chests;
    }

    public final static String VALIDATION_SUCCESS = "Valid";
    public final static String VALIDATION_ERROR_NO_ENTRANCE = "No entrance";
    public final static String VALIDATION_ERROR_TOO_MANY_ENTRANCES = "Should be only one entrance";
    public final static String VALIDATION_ERROR_NO_EXIT = "No exit";
    public final static String VALIDATION_ERROR_TOO_MANY_EXITS = "Should be only one exit";
    public final static String VALIDATION_ERROR_EXIT_IS_NOT_REACHABLE = "The exit is not reachable";
    public final static String VALIDATION_ERROR_PLAYER_IS_NOT_DEFINED = "The player party is not defined";

    /**
     * this method is to validate the map
     * @return String
     */
    public String validate(){

        List<Entrance> entrances = getEntrances();
        List<Exit> exits = getExits();

        //  if no entrance or more than 1 entrance
        if (entrances.size() != 1){
            return entrances.size() < 1 ?
                    VALIDATION_ERROR_NO_ENTRANCE :
                    VALIDATION_ERROR_TOO_MANY_ENTRANCES;
        }

        //  if no exit or more than 1 exit
        if (exits.size() != 1) {
            return exits.size() < 1 ?
                    VALIDATION_ERROR_NO_EXIT :
                    VALIDATION_ERROR_TOO_MANY_EXITS;
        }

        List<Player> players = getPlayers();

        // if player party is not defined
        for (Player player: players) {
            if (player.getPlayerParty().equals(Player.PLAYER_PARTY_NOT_DEFINED)){
                return VALIDATION_ERROR_PLAYER_IS_NOT_DEFINED;
            }
        }

        GameMapGraph graph = getGraph();
        graph.addIgnoreType(Cell.Type.CHEST);
        graph.addIgnoreType(Cell.Type.PLAYER);

        Point startPoint = entrances.get(0).getLocation();
        Point endPoint = exits.get(0).getLocation();
        boolean reachable = graph.isReachable(startPoint, endPoint);

        return reachable ? VALIDATION_SUCCESS : VALIDATION_ERROR_EXIT_IS_NOT_REACHABLE;
    }

    /**
     * this method is to if the cell is out of bounds
     * @param location Point
     * @return Boolean
     */
    public boolean pointInMap(Point location) {
        int x = location.getX();
        if (x < 0 || x >= width) {
            return false;
        }

        int y = location.getY();
        if (y < 0 || y >= height) {
            return false;
        }

        return true;
    }

    /**
     * This method is used for provide the range points for all the players.
     */

    @Deprecated
    public Map<Player, List<Point>> getAttackRanges() {

        Map<Player, List<Point>> attackRanges = new HashMap<>();
        List<Player> players = getPlayers();

        for (Player player : players) {
            attackRanges.put(player, getAttackRange(player));
        }

        return attackRanges;
    }

    /**
     * The method is used to provide the range points for one player.
     * @param player Player
     * @return List<Point>
     */

    @Deprecated
    private List<Point> getAttackRange(Player player) {

        List<Point> attackRange = new LinkedList<>();

        List<Point.Direction> directions = Point.Direction.directions();
        int range = player.getRangeForAttack();
        Point location = player.getLocation();

        for (Point.Direction direction : directions) {
            for (int i = 0; i < range; i++) {
                Point rangePoint = location.add(direction);
                if (pointInMap(rangePoint)) {
                    attackRange.add(rangePoint);
                }
            }
        }

        return attackRange;
    }


    public GameMapGraph getGraph(){
        return new GameMapGraph(this);
    }


    public Iterable<Point> fullLocations(){
        List<Point> locations = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                locations.add(new Point(j, i));
            }
        }
        return locations;
    }
}
