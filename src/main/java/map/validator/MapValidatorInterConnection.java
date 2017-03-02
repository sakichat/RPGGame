package map.validator;

import map.Entrance;
import map.Exit;
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




        return true;
    }

    private LinkedList<Point> aroudPoints(){
        LinkedList<Point> directions = new LinkedList<>();
        return null;
    }
}
