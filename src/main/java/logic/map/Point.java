package logic.map;


import com.google.gson.annotations.Expose;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Qi Xia
 * @version 0.2
 * this class is the Point
 */
public class Point {

    @Expose
    private int x;

    @Expose
    private int y;

    /**
     * this is the constructor
     */
    public Point() {
    }

    /**
     * this method is the constructor
     * @param x int
     * @param y int
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point sub(Point delta){
        // TODO: 06/04/2017
        Point point = new Point();
        point.x = x - delta.x;
        point.y = y - delta.y;
        return point;
    }

    /**
     * this method is to add point
     * @param delta Point
     * @return Point
     */
    public Point add(Point delta){
        Point point = new Point();
        point.x = x + delta.x;
        point.y = y + delta.y;
        return point;
    }


    /**
     * this method is to get X
     * @return Integer
     */
    public int getX() {
        return x;
    }

    /**
     * this method is to set X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * this method is to get Y
     * @return Integer
     */
    public int getY() {
        return y;
    }

    /**
     * this method is to set Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * this method is to show the Point
     * @return String
     */

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * this method is to compare the object
     * @param o Object
     * @return Boolean
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    /**
     * this is generated automatically
     * @return int
     */

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


    /**
     * This method is to get points from the directions.
     * @return LinkedList<Point>
     */

    @Deprecated
    public final static Point DIRECTION_UP = new Point(0, -1);

    @Deprecated
    public final static Point DIRECTION_DOWN = new Point(0, 1);

    @Deprecated
    public final static Point DIRECTION_LEFT = new Point(-1, 0);

    @Deprecated
    public final static Point DIRECTION_RIGHT = new Point(1, 0);


    @Deprecated
    public static LinkedList<Point> directions(){
        LinkedList<Point> points = new LinkedList<>();

        points.add(DIRECTION_UP);
        points.add(DIRECTION_RIGHT);
        points.add(DIRECTION_DOWN);
        points.add(DIRECTION_LEFT);

        return points;
    }

    public Direction toDirection(){
        // TODO: 06/04/2017
        if (x == 0){
            if (y > 0){
                return Direction.DOWN;
            }else {
                return Direction.UP;
            }
        }else if(y == 0){
            if (x > 0){
                return Direction.RIGHT;
            }else {
                return Direction.LEFT;
            }
        }
        return null;
    }

    public static enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private Point point;

        Direction(int x, int y) {
            // TODO: 06/04/2017
            // QIKAI

            point.setX(x);
            point.setY(y);
        }

        public Point toPoint(){
            // TODO: 06/04/2017
            // QIKAI

            return point;
        }
    }
}
