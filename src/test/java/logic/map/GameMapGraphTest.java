package logic.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GU_HAN
 * @version 0.2
 * This class tests the class of GameMapGraph.
 */
public class GameMapGraphTest {
    /**
     * These parameters are for initializing.
     */
    public static final int SIZE = 9;
    private GameMap emptyMap;
    private Point centerPoint;
    private Point rightTopPoint;

    private GameMap realMap;


    /**
     * This method is for initializing.
     * @throws Exception
     */
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
        realMap.addCell(new Obstacle(), centerPoint.add(Point.Direction.UP));
        realMap.addCell(new Obstacle(), centerPoint.add(Point.Direction.UP).add(Point.Direction.UP));
        realMap.addCell(new Obstacle(), centerPoint.add(Point.Direction.UP).add(Point.Direction.UP).add(Point.Direction.UP));
        realMap.addCell(new Chest(), centerPoint.add(Point.Direction.RIGHT));
        realMap.addCell(new Chest(), centerPoint.add(Point.Direction.RIGHT).add(Point.Direction.RIGHT));
        realMap.addCell(new Chest(), centerPoint.add(Point.Direction.RIGHT).add(Point.Direction.RIGHT).add(Point.Direction.RIGHT));
    }

    /**
     * This method tests the range.
     * @throws Exception
     */
    @Test
    public void pointsInRange() throws Exception {
        {
            System.out.println("pointsInRange, (4, 4), range 2");
            GameMapGraph graph = emptyMap.getGraph();
            List<Point> points = graph.pointsInRange(centerPoint, 1);
            System.out.println(points);

            Assert.assertEquals(4, points.size());
        }
        {
            System.out.println("pointsInRange, (4, 4), range 2");
            GameMapGraph graph = emptyMap.getGraph();
            List<Point> points = graph.pointsInRange(centerPoint, 2);
            System.out.println(points);

            Assert.assertEquals(12, points.size());
        }
        {
            System.out.println("pointsInRange, (8, 0), range 2");
            GameMapGraph graph = emptyMap.getGraph();
            List<Point> points = graph.pointsInRange(rightTopPoint, 2);
            System.out.println(points);

            Assert.assertEquals(5, points.size());
        }
        {
            System.out.println("pointsInRange, (4, 4), range 2");
            GameMapGraph graph = realMap.getGraph();
            List<Point> points = graph.pointsInRange(centerPoint, 2);
            System.out.println(points);

            Assert.assertEquals(7, points.size());
        }
        {
            System.out.println("pointsInRange, (4, 4), range 2");
            GameMapGraph graph = realMap.getGraph();
            graph.addIgnoreType(Cell.Type.CHEST);
            List<Point> points = graph.pointsInRange(centerPoint, 2);
            System.out.println(points);

            Assert.assertEquals(10, points.size());
        }
    }

    /**
     * This method tests if the cell within the range can be achieved.
     * @throws Exception
     */
    @Test
    public void cellsInRange() throws Exception {
        GameMapGraph graph = realMap.getGraph();
        List<Cell> cells = graph.cellsInRange(centerPoint, 2, Cell.Type.CHEST);
        List<Point> points = cells.stream().map(c -> c.getLocation()).collect(Collectors.toList());
        int length = points.size();

        Assert.assertEquals(2, length);
    }

    /**
     * This method tests the shortest path.
     * @throws Exception
     */
    @Test
    public void shortestPath() throws Exception {
        GameMapGraph graph = realMap.getGraph();
        Path path = graph.shortestPath(centerPoint, rightTopPoint);

        int length = path.getLocations().size();

        Assert.assertEquals(11, length);
    }

    /**
     * This method tests the distance between two points.
     * @throws Exception
     */
    @Test
    public void distanceBetween() throws Exception {
        GameMapGraph graph = realMap.getGraph();
        int distanceBetween = graph.distanceBetween(new Point(0, 0), new Point(5, 5));

        Assert.assertEquals(10, distanceBetween);
    }

}