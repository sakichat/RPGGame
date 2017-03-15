package logic;

import com.google.gson.annotations.Expose;

import java.util.LinkedList;
import java.util.List;

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
        return getCell(location) != null;
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

        Cell cell = cells[startX][startY];
        cells[startY][startX] = null;
        cells[endY][endX] = cell;
    }

    /**
     * this method is to get  all entrances
     * @return List<Entreance>
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

    public final static String VALIDATION_SUCCESS = "Valid";
    public final static String VALIDATION_ERROR_NO_ENTRANCE = "No entrance";
    public final static String VALIDATION_ERROR_TOO_MUCH_ENTRANCE = "Should be only one entrance";
    public final static String VALIDATION_ERROR_NO_EXIT = "No exit";
    public final static String VALIDATION_ERROR_TOO_MUCH_EXIT = "Should be only one exit";
    public final static String VALIDATION_ERROR_EXIT_IS_NOT_REACHABLE = "The exit is not reachable";

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
                    VALIDATION_ERROR_TOO_MUCH_ENTRANCE;
        }

        //  if no exit or more than 1 exit
        if (exits.size() != 1) {
            return exits.size() < 1 ?
                    VALIDATION_ERROR_NO_EXIT :
                    VALIDATION_ERROR_TOO_MUCH_EXIT;
        }


        LinkedList<Point> visitedLocations = new LinkedList<>();
        LinkedList<Point> pendingLocations = new LinkedList<>();

        Point startPoint = entrances.get(0).getLocation();
        pendingLocations.addLast(startPoint);

        while (pendingLocations.size() > 0) {
            Point location = pendingLocations.removeFirst();
            visitedLocations.addLast(location);

            LinkedList<Point> directions = Point.directions();
            for (Point direction : directions) {
                Point adjacentLocation = location.add(direction);


                // if point out of range, then ignore this point
                if (!inMap(adjacentLocation)){
                    continue;
                }

                // if point is visited or pending, then ignore this point
                if (    pendingLocations.contains(adjacentLocation) ||
                        visitedLocations.contains(adjacentLocation)     ){
                    continue;
                }

                Cell adjacentCell = getCell(adjacentLocation);

                if (adjacentCell != null) {

                    //  if is exit
                    if (adjacentCell instanceof Exit) {
                        return VALIDATION_SUCCESS;
                    }

                    // if other object, which mean cannot go through
                    continue;
                }

                pendingLocations.addLast(adjacentLocation);
            }
        }

        //  mean exit is not reachable
        return VALIDATION_ERROR_EXIT_IS_NOT_REACHABLE;
    }

    /**
     * this method is to if the cell is out of bounds
     * @param location Point
     * @return Boolean
     */

    private boolean inMap(Point location) {
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
}
