package map;


import java.util.LinkedList;

/**
 * Created by Saki on 2017/2/20.
 */
public class Point {
    private int x;
    private int y;
    private int visited;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Point delta){
        Point point = new Point();
        point.x = x + delta.x;
        point.y = y + delta.y;
        return point;
    }

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
