package logic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Saki on 2017/2/20.
 */
public class GameMap {
    private String name;
    private int size;
    private Cell[][] cells;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        cells = new Cell[size][size];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCell(Cell cell, Point location){
        int x = location.getX();
        int y = location.getY();
        cells[y][x] = cell;

        cell.location = location;
    }

    public void removeCell(Point location){
        int x = location.getX();
        int y = location.getY();
        cells[y][x] = null;
    }

    public Cell getCell(Point location){
        int x = location.getX();
        int y = location.getY();
        return cells[y][x];
    }

    public boolean hasCell(Point location){
        return getCell(location) != null;
    }

    public void moveCell(Point startPoint, Point endPoint){

        int startX = startPoint.getX();
        int startY = startPoint.getY();
        int endX = endPoint.getX();
        int endY = endPoint.getY();

        Cell cell = cells[startX][startY];
        cells[startY][startX] = null;
        cells[endY][endX] = cell;
    }

    public List<Entrance> getEntrances(){
        LinkedList<Entrance> entrances = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] instanceof Entrance){
                    Cell cell = cells[i][j];
                    Entrance entrance = (Entrance) cell;
                    entrances.add(entrance);
                }
            }
        }

        return entrances;
    }

    public List<Exit> getExits() {
        LinkedList<Exit> exits = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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

    private boolean inMap(Point location) {
        int x = location.getX();
        if (x < 0 || x >= size) {
            return false;
        }

        int y = location.getY();
        if (y < 0 || y >= size) {
            return false;
        }

        return true;
    }
}
