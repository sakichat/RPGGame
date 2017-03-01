package demo.map;

import map.Point;

import java.util.LinkedList;

/**
 * Created by Saki on 2017/2/28.
 */
public class PointDemo {
    public static void main(String[] args) {
        Point point = new Point(2, 3);

        LinkedList<Point> directions = Point.directions();
        for (Point direction : directions) {
            Point newPoint = point.add(direction);
            System.out.println(newPoint);
        }
    }
}
