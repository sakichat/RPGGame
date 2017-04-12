package logic.map;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameMapGraph {
    private GameMap gameMap;

    public GameMapGraph(GameMap gameMap) {
        this.gameMap = gameMap;
        values = new int[gameMap.getHeight()][gameMap.getWidth()];
    }

    private int[][] values;

    private int getValue(Point location){
        if (gameMap.pointInMap(location)) {
            return values[location.getY()][location.getX()];
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private void setValue(Point location, int value){
        values[location.getY()][location.getX()] = value;
    }

    private void resetValues(){
        for (int i = 0; i < gameMap.getHeight(); i++) {
            for (int j = 0; j < gameMap.getWidth(); j++) {
                values[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    void setValueByPath(Path path){
        resetValues();
        for (Point point : path) {
            setValue(point, 1);
        }
    }

    public void printValues(){
        Iterable<Point> locations = gameMap.getLocations();
        int y = 0;
        for (Point location : locations) {
            if (location.getY() != y) {
                System.out.println();
                y = location.getY();
            }

            int value = getValue(location);
            if (value == Integer.MAX_VALUE){
                System.out.printf("  %s", gameMap.hasCell(location) ? "x" : ".");
            } else {
                System.out.printf("%3d", value);
            }
        }
        System.out.println();
    }

    private List<Point> bfs(Point source) {
        return bfs(source, v -> true);
    }

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

    public List<Point> pointsInRange(Point source, int range) {
        List<Point> points = bfs(source, r -> r <= range);
        points.remove(0);
        return points;
    }

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

    private List<Cell.Type> ignoreTypes = new LinkedList<>();

    public void addIgnoreType(Cell.Type type){
        ignoreTypes.add(type);
    }

    private boolean shouldIgnore(Cell cell){
        return ignoreTypes.contains(cell.getCellType());
    }

    public Path shortestPath(Point source, Point target){
        bfs(source);

        printValues();
        System.out.println(source + " to " + target);
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

        steps.forEach(System.out::println);
        steps.forEach(path::addLocationsToLocation);

        return path;
    }

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

    public int distanceBetween(Point source, Point target){
        bfs(source);
        return getValue(target);
    }

    public boolean isReachable(Point source, Point target){
        return distanceBetween(source, target) != Integer.MAX_VALUE;
    }
}
