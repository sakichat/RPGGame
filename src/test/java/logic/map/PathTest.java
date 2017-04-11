package logic.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kai QI on 2017/4/6.
 * @author Kai Qi
 * @version 0.2
 */
public class PathTest {
    /**
     * These parameters are for initializing.
     */
    private Point location1;
    private Point location2;
    private Path path;
    private Point location3;

    /**
     * This method is for initializing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        path = new Path();
        location1 = new Point(3, 1);
        location2 = new Point(3, 5);
        location3 = new Point(0, 5);
        path.addLocation(location1);
    }

    /**
     * This method tests the addLocation.
     * @throws Exception
     */
    @Test
    public void addLocationsToLocation() throws Exception {
        {
            System.out.println("location1");
            for (Point point : path.getLocations()) {
                System.out.println(point);
            }
            Assert.assertEquals(1, path.getLocations().size());
        }

        {
            path.addLocationsToLocation(location2);
            System.out.println("location1 + location2");
            for (Point point : path.getLocations()) {
                System.out.println(point);
            }
            Assert.assertEquals(5, path.getLocations().size());
        }

        {
            path.addLocationsToLocation(location3);
            System.out.println("location1 + location2 + location3");
            for (Point point : path.getLocations()) {
                System.out.println(point);
            }
            Assert.assertEquals(8, path.getLocations().size());
        }

    }

    /**
     * This method tests the movement.
     * @throws Exception
     */
    @Test
    public void getMovement() throws Exception {
        {
            System.out.println("location1, movement3");
            Movement movement = path.getMovement(3);
            for (Point.Direction direction : movement) {
                System.out.println(direction);
            }
            Assert.assertEquals(0, movement.getMoves().size());
        }

        {
            System.out.println("location1 + location2, movement3");
            path.addLocationsToLocation(location2);
            Movement movement = path.getMovement(3);
            for (Point.Direction direction : movement) {
                System.out.println(direction);
            }
            Assert.assertEquals(3, movement.getMoves().size());
        }

        {
            path.addLocationsToLocation(location3);
            System.out.println("location1 + location2 + location3, movement6");
            Movement movement = path.getMovement(6);
            for (Point.Direction direction : movement) {
                System.out.println(direction);
            }
            Assert.assertEquals(6, movement.getMoves().size());
        }
        {
            System.out.println("location1 + location2 + location3, movement10");
            Movement movement = path.getMovement(10);
            for (Point.Direction direction : movement) {
                System.out.println(direction);
            }
            Assert.assertEquals(7, movement.getMoves().size());
        }
    }

    /**
     * This method tests the equal of the path.
     * @throws Exception
     */
    @Test
    public void equalsToPath() throws Exception {
        path.addLocationsToLocation(location2);

        Path path2 = new Path();
        path2.addLocation(new Point(3, 1));
        path2.addLocation(new Point(3, 2));
        path2.addLocation(new Point(3, 3));
        path2.addLocation(new Point(3, 4));
        path2.addLocation(new Point(3, 5));

        for (Point point : path2) {
            System.out.println(point);
        }

        Assert.assertTrue(path.equalsToPath(path2));
    }
}