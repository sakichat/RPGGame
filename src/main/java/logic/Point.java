package logic;


import java.util.LinkedList;

/**
 * Created by Saki on 2017/2/20.
 * this class is the Point
 */
public class Point {
    private int x;
    private int y;
    private int visited;

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
     * this method is to get points from the directions
     * @return LinkedList<Point>
     */

    public static LinkedList<Point> directions(){
        LinkedList<Point> points = new LinkedList<>();

        Point pointUp = new Point(0,1);
        points.add(pointUp);

        Point pointRight = new Point(1,0);
        points.add(pointRight);

        Point pointDown = new Point(0,-1);
        points.add(pointDown);

        Point pointLeft = new Point(-1,0);
        points.add(pointLeft);

        return points;
    }

    /**
     * this method is to get X
     * @return int
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
     * @return int
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
}
