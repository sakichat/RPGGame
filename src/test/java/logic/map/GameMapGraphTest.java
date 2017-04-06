package logic.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class GameMapGraphTest {
    public static final int SIZE = 9;
    private GameMap emptyMap;
    private Point centerPoint;
    private Point rightTopPoint;

    private GameMap realMap;



    @Before
    public void setUp() throws Exception {
        centerPoint = new Point(SIZE / 2, SIZE / 2);
        rightTopPoint = new Point(SIZE - 1, 0);

        emptyMap = new GameMap();
        emptyMap.setWidth(SIZE);
        emptyMap.setHeight(SIZE);

        realMap = new GameMap();
        realMap.setWidth(SIZE);
        realMap.setHeight(SIZE);
        realMap.addCell(new Obstacle(), centerPoint.add(Point.DIRECTION_UP));
        realMap.addCell(new Obstacle(), centerPoint.add(Point.DIRECTION_UP).add(Point.DIRECTION_UP));
        realMap.addCell(new Obstacle(), centerPoint.add(Point.DIRECTION_UP).add(Point.DIRECTION_UP).add(Point.DIRECTION_UP));
        realMap.addCell(new Chest(), centerPoint.add(Point.DIRECTION_RIGHT));
        realMap.addCell(new Chest(), centerPoint.add(Point.DIRECTION_RIGHT).add(Point.DIRECTION_RIGHT));
        realMap.addCell(new Chest(), centerPoint.add(Point.DIRECTION_RIGHT).add(Point.DIRECTION_RIGHT).add(Point.DIRECTION_RIGHT));
    }

    @Test
    public void pointsInRange() throws Exception {
        {
            System.out.println("pointsInRange, (4, 4), range 2");
            GameMapGraph graph = emptyMap.getGraph();
            List<Point> points = graph.pointsInRange(centerPoint, 1);
            System.out.println(points);
            graph.printValues();
        }
        {
            System.out.println("pointsInRange, (4, 4), range 2");
            GameMapGraph graph = emptyMap.getGraph();
            List<Point> points = graph.pointsInRange(centerPoint, 2);
            System.out.println(points);
            graph.printValues();
        }
        {
            System.out.println("pointsInRange, (8, 0), range 2");
            GameMapGraph graph = emptyMap.getGraph();
            List<Point> points = graph.pointsInRange(rightTopPoint, 2);
            System.out.println(points);
            graph.printValues();
        }
        {
            System.out.println("pointsInRange, (4, 4), range 2");
            GameMapGraph graph = realMap.getGraph();
            List<Point> points = graph.pointsInRange(centerPoint, 2);
            System.out.println(points);
            graph.printValues();
        }
        {
            System.out.println("pointsInRange, (4, 4), range 2");
            GameMapGraph graph = realMap.getGraph();
            graph.addIgnoreType(Cell.Type.CHEST);
            List<Point> points = graph.pointsInRange(centerPoint, 2);
            System.out.println(points);
            graph.printValues();
        }
    }

    @Test
    public void cellsInRange() throws Exception {
        {
            GameMapGraph graph = realMap.getGraph();
            List<Cell> cells = graph.cellsInRange(centerPoint, 2, Cell.Type.CHEST);
            List<Point> points = cells.stream().map(c -> c.getLocation()).collect(Collectors.toList());
            System.out.println(points);
            graph.printValues();
        }
    }

    @Test
    public void shortestPath() throws Exception {

    }

    @Test
    public void distanceBetween() throws Exception {

    }

}