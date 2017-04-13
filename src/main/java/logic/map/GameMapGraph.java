package logic.map;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Kai QI
 * @version 0.3
 * The class is GameMapGraph.
 */
public class GameMapGraph {

    /**
     * property of gameMap
     */
    private GameMap gameMap;

    /**
     * This is a method for constructor.
     */

    public GameMapGraph(GameMap gameMap) {
        this.gameMap = gameMap;
        values = new int[gameMap.getHeight()][gameMap.getWidth()];
    }

    /**
     * property of values.
     */
    private int[][] values;

    /**
     * The method is getValue
     * @param location Point
     * @return int
     */
    private int getValue(Point location){
        if (gameMap.pointInMap(location)) {
            return values[location.getY()][location.getX()];
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * The method is setValue
     * @param location Point
     * @param value void
     */
    private void setValue(Point location, int value){
        values[location.getY()][location.getX()] = value;
    }

    /**
     * The method is resetValues
     */
    private void resetValues(){
        for (int i = 0; i < gameMap.getHeight(); i++) {
            for (int j = 0; j < gameMap.getWidth(); j++) {
                values[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    /**
     * The method is setValueByPath
     * @param path Path
     */
    void setValueByPath(Path path){
        resetValues();
        for (Point point : path) {
            setValue(point, 1);
        }
    }

    /**
     * The method is printValues
     */
    public void printValues(){
        Iterable<Point> locations = gameMap.getLocations();
        int y = 0;
        for (Point location : locations) {
            if (location.getY() != y) {
                y = location.getY();
            }

            int value = getValue(location);
        }
    }

    /**
     * The method is bfs.
     * @param source Point
     * @return List
     */
    private List<Point> bfs(Point source) {
        return bfs(source, v -> true);
    }

    /**
     * The method is bfs
     * @param source Point
     * @param rangeLimit Predicate
     * @return List
     */
    private List<Point> bfs(Point source, Predicate<Integer> rangeLimit) {
        resetValues();
        LinkedList<Point> visitedLocations = new LinkedList<>();
        LinkedList<Point> pendingLocations = new LinkedList<>();

        setValue(source, 0);
        pendingLocations.addLast(source);

        while (pendingLocations.size() > 0) {
            Point location = pendingLocations.removeFirst();
            int value = getValue(location);
            visitedLocations.addLast(location);

            List<Point.Direction> directions = Point.Direction.directions();
            for (Point.Direction direction : directions) {
                Point adjacentLocation = location.add(direction);


                // if point out of range, then ignore this point
                if (!gameMap.pointInMap(adjacentLocation)){
                    continue;
                }

                // if point is visited or pending, then ignore this point
                if (    pendingLocations.contains(adjacentLocation) ||
                        visitedLocations.contains(adjacentLocation)     ){
                    continue;
                }

                Cell adjacentCell = gameMap.getCell(adjacentLocation);

                if (adjacentCell != null) {
                    // if other object, can be ignored
                    if (!shouldIgnore(adjacentCell)){
                        continue;
                    }
                }

                int adjacentValue = value + 1;
                if (!rangeLimit.test(adjacentValue)) {
                    continue;
                }

                setValue(adjacentLocation, adjacentValue);
                pendingLocations.addLast(adjacentLocation);
            }
        }

        return visitedLocations;
    }

    /**
     * The method is pointsInRange
     * @param source Point
     * @param range int
     * @return List
     */
    public List<Point> pointsInRange(Point source, int range) {
        List<Point> points = bfs(source, r -> r <= range);
        points.remove(0);
        return points;
    }

    /**
     * The method is cellsInRange
     * @param source Point
     * @param range int
     * @param cellType Type
     * @return List
     */
    public List<Cell> cellsInRange(Point source, int range, Cell.Type cellType) {
        if (!ignoreTypes.contains(cellType)){
            addIgnoreType(cellType);
        }

        List<Point> points = pointsInRange(source, range);
        return points.stream()
                .map(p -> gameMap.getCell(p))
                .filter(c -> c != null)
                .filter(c -> c.getCellType() == cellType)
                .collect(Collectors.toList());
    }

    /**
     * the property of ignoreTypes
     */
    private List<Cell.Type> ignoreTypes = new LinkedList<>();

    public void ignoreAll(){
        Cell.Type[] types = Cell.Type.values();
        for (Cell.Type type : types) {
            addIgnoreType(type);
        }
    }

    /**
     * The method of addIgnoreType
     * @param type
     */
    public void addIgnoreType(Cell.Type type){
        ignoreTypes.add(type);
    }

    private boolean shouldIgnore(Cell cell){
        return ignoreTypes.contains(cell.getCellType());
    }

    /**
     * The method of shortestPath
     * @param source Point
     * @param target Point
     * @return Path
     */
    public Path shortestPath(Point source, Point target){
        bfs(source);

        printValues();
        if (getValue(target) == Integer.MAX_VALUE) {
            return null;
        }

        LinkedList<Point> steps = new LinkedList<Point>();
        steps.add(target);

        Point location = target;
        while (!location.equals(source)){
            Point.Direction direction = downsideDirection(location);

            Point nextLocation = location.add(direction);
            while (getValue(nextLocation) < getValue(location)){
                location = nextLocation;
                nextLocation = location.add(direction);
            }

            steps.addFirst(location);
        }
        steps.removeFirst();

        Path path = new Path();
        path.addLocation(source);

        steps.forEach(path::addLocationsToLocation);

        return path;
    }

    /**
     * The method of path
     * @param source Point
     * @param target Point
     * @param range int
     * @return Path
     */
    public Path path(Point source, Point target, int range){
        Path path = shortestPath(source, target);
        Path cutPath = new Path();
        List<Point> locations = path.getLocations();
        cutPath.addLocation(locations.get(0));

        for (int i = 1; i < locations.size(); i++) {
            if (i > range) {
                break;
            }

            Point location = locations.get(i);

            if (gameMap.canPlace(location)) {
                cutPath.addLocation(location);
            } else {
                break;
            }
        }

        return cutPath;
    }

    /**
     * The method of downsideDirection
     * @param source Point
     * @return Direction
     */
    private Point.Direction downsideDirection(Point source) {
        int value = getValue(source);
        List<Point.Direction> directions = Arrays.asList(Point.Direction.values());
        return directions
                .stream()
                .filter(d -> {
                    Point location = source.add(d.toPoint());
                    return getValue(location) < value;
                })
                .findAny()
                .get();
    }

    /**
     * The method of distanceBetween
     * @param source Point
     * @param target Point
     * @return int
     */
    public int distanceBetween(Point source, Point target){
        bfs(source);
        return getValue(target);
    }

    /**
     * The method of isReachable
     * @param source Point
     * @param target Point
     * @return boolean
     */
    public boolean isReachable(Point source, Point target){
        return distanceBetween(source, target) != Integer.MAX_VALUE;
    }
}
