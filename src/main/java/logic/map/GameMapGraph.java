package logic.map;


import java.util.LinkedList;
import java.util.List;

public class GameMapGraph {
    private GameMap gameMap;

    public GameMapGraph(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public List<Point> pointsInRangeFromLocation(Point location, int range) {
        // TODO: 06/04/2017
        return null;
    }

    private List<Cell.Type> ignoreTypes = new LinkedList<>();

    public void addIgnoreType(Cell.Type type){
        // TODO: 06/04/2017  
    }

    public Path shortestPath(Point source, Point target){
        // TODO: 06/04/2017
        return null;
    }

    public int distanceBetween(Point source, Point target){
        // TODO: 06/04/2017
        return 0;
    }
}
