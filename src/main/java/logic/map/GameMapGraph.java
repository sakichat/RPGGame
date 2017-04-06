package logic.map;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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
        return values[location.getY()][location.getX()];
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

    public void printValues(){
        Iterable<Point> locations = gameMap.fullLocations();
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

            LinkedList<Point> directions = Point.directions();
            for (Point direction : directions) {
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

        if (getValue(target) == Integer.MAX_VALUE) {
            return null;
        }

        return null;
    }

    public int distanceBetween(Point source, Point target){
        bfs(source);
        return getValue(target);
    }

    public boolean isReachable(Point source, Point target){
        return distanceBetween(source, target) != Integer.MAX_VALUE;
    }
}
