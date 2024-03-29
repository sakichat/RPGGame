package logic.map;


import com.google.gson.annotations.Expose;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Qi Xia
 * @version 0.3
 * this class is the Point
 */
public class Point {

    //  =======================================================================
    //  Section - Constructor
    //  =======================================================================

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


    //  =======================================================================
    //  Section - Basic
    //  =======================================================================

    @Expose
    private int x;

    @Expose
    private int y;


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
     * this method is to sub point
     * @param delta Point
     * @return Point
     */
    public Point sub(Point delta){
        Point point = new Point();
        point.x = x - delta.x;
        point.y = y - delta.y;
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

    //  =======================================================================
    //  Section - Object
    //  =======================================================================


    /**
     * this method is to show the Point
     * @return String
     */

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ")";
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
     * The method of copy
     * @return Point
     */
    public Point copy(){
        return new Point(x,y);
    }


    //  =======================================================================
    //  Section - Direction
    //  =======================================================================

    /**
     * The method of Direction
     */
    public static enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private Point point;

        Direction(int x, int y) {
            this.point = new Point(x,y);
        }

        public Point toPoint(){
            return point.copy();
        }

        public static List<Direction> directions(){
            List<Direction> directions = new LinkedList<>();
            directions.add(UP);
            directions.add(RIGHT);
            directions.add(DOWN);
            directions.add(LEFT);
            return directions;
        }

    }

    /**
     * The method of toDirection
     * @return Direction
     */
    public Direction toDirection(){
        if (x == 0){
            if (y > 0){
                return Direction.DOWN;
            } else {
                return Direction.UP;
            }
        } else if (y == 0){
            if (x > 0){
                return Direction.RIGHT;
            } else {
                return Direction.LEFT;
            }
        }
        return null;
    }

    /**
     * The method of add
     * @param direction Direction
     * @return Point
     */
    public Point add(Direction direction){
        return add(direction.toPoint());
    }
}
