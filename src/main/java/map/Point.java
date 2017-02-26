package map;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Saki on 2017/2/20.
 */
public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Point delta){
        delta.x = this.x;
        delta.y = this.y;
        String movement = "";
        if(movement == "up"){
            delta.y += -1;
        }else if(movement == "right"){
            delta.x += 1;
        }else if(movement == "down"){
            delta.y +=1 ;
        }else if(movement == "left"){
            delta.x += -1;
        }

        return delta;
    }

    public static LinkedList directions(){
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
}
