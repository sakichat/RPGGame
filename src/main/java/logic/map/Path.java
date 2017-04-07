package logic.map;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Path implements Iterable<Point>{
    private List<Point> locations = new LinkedList<>();

    List<Point> getLocations() {
        return locations;
    }

    public void addLocation(Point location) {
        locations.add(location);
    }

    public void addLocationsToLocation(Point location){

        Point lastLocation = locations.get(locations.size() - 1);
        Point.Direction direction = location.sub(lastLocation).toDirection();
        Point middle = lastLocation;

        while (!middle.equals(location)) {
            middle = middle.add(direction);
            locations.add(middle);
        }
    }

    public Movement getMovement(int steps) {

        Movement movement = new Movement();

        int number = Math.min(steps, locations.size() - 1);

        for (int i = 0; i < number; i++) {
            Point startLocation = locations.get(i);
            Point endLocation = locations.get(i + 1);
            Point point = endLocation.sub(startLocation);
            movement.addMove(point.toDirection());
        }

        return movement;
    }

    @Override
    public Iterator<Point> iterator() {
        return locations.iterator();
    }
}
