package logic.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kai QI on 2017/4/6.
 */
public class PathTest {

    private Point location1;
    private Point location2;
    private Path path;

    @Before
    public void setUp() throws Exception {
        path = new Path();
        location1 = new Point(3, 1);
        location2 = new Point(3, 5);
        path.addLocation(location1);
    }

    @Test
    public void addLocation() throws Exception {

    }

    @Test
    public void addLocationsToLocation() throws Exception {
        System.out.println("before");
        for (Point point : path.getLocations()) {
            System.out.println(point);
        }

        path.addLocationsToLocation(location2);
        System.out.println("after");
        for (Point point : path.getLocations()) {
            System.out.println(point);
        }
    }

    @Test
    public void getMovement() throws Exception {

    }




}