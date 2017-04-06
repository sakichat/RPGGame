package logic.map;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Path {
    private List<Point> locations = new LinkedList<>();

    public void addLocation(Point location) {
        locations.add(location);
    }

    public void addLocationsToLocation(Point location){

        Point lastPoint = locations.get(locations.size() - 1);

        if (location.getX() == lastPoint.getX()) {
            int dy = location.getY() - lastPoint.getY();
            for (int i = 0; i < Math.abs(dy); i++) {
                if (dy > 0) {
                    Point point = lastPoint.add(Point.Direction.DOWN.toPoint());
                    locations.add(point);
                } else if (dy < 0) {
                    Point point = lastPoint.add(Point.Direction.UP.toPoint());
                    locations.add(point);
                }
            }
        }

        if (location.getY() == lastPoint.getY()) {
            int dx = location.getX() - lastPoint.getX();
            for (int i = 0; i < Math.abs(dx); i++) {
                if (dx > 0) {
                    Point point = lastPoint.add(Point.Direction.RIGHT.toPoint());
                    locations.add(point);
                } else if (dx < 0) {
                    Point point = lastPoint.add(Point.Direction.LEFT.toPoint());
                    locations.add(point);
                }
            }
        }


    }

    public Movement getMovement(int steps) {

        Movement movement = new Movement();

        for (int i = 0; i < steps; i++) {
            Point startLocation = locations.get(i);
            Point endLocation = locations.get(i + 1);
            Point point = endLocation.sub(startLocation);
            movement.addMove(point.toDirection());
        }

        return movement;
    }
}
