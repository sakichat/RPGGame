package map.validator;

import map.Entrance;
import map.MapValidator;
import map.Point;

import java.util.LinkedList;

/**
 * Created by Saki on 2017/2/20.
 */
public class MapValidatorInterConnection extends MapValidator{
    @Override
    public boolean validate() {
        return bfsSearch();
    }

    public boolean bfsSearch(){
        LinkedList<Point> pending = new LinkedList<>();
        LinkedList<Point> visited = new LinkedList<>();

        Entrance entrance = gameMap.getEntrances().get(0);
//        Exit exit = gameMap.getExits().get(0);

        Point entrancePoint = new Point();
        entrancePoint = entrance.getLocation();

//        Point exitPoint = new Point();
//        exitPoint.setX(exit.getLocation().getX());
//        exitPoint.setY(exit.getLocation().getY());

        pending.add(entrancePoint);

        LinkedList<Point> aroundPoints =  aroundPoints(entrancePoint);
        for (Point aroundPoint : aroundPoints) {

        }




        return true;
    }

    private LinkedList<Point> aroundPoints(Point point){
        LinkedList<Point> directions = Point.directions();
        LinkedList<Point> aroundPoints = new LinkedList<>();
        for (Point direction : directions) {
            Point newPoint = point.add(direction);
            aroundPoints.add(newPoint);
        }

        return aroundPoints;
    }
}
