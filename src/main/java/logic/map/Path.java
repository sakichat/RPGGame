package logic.map;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kai QI
 * @version 0.3
 * The Class is Path.
 * In Path object, several Point objects are stored in order to form a path.
 */

public class Path implements Iterable<Point> {

    /**
     * The declaration of the property locations.
     */
    private List<Point> locations = new LinkedList<>();

    /**
     * Getter for the property locations, which will be called in the testCase.
     * @return List
     */
    List<Point> getLocations() {
        return locations;
    }

    /**
     * The method is used to add every location point into the path list.
     * @param location Point object, every single point on the path.
     */
    public void addLocation(Point location) {
        locations.add(location);
    }

    /**
     * The method is used to add a serial of locations into the path list.
     * If the parameter location is not adjacent to the last point of the path,
     * the points between them will be added in the method.
     * @param location the new point which should be add into the path.
     */
    public void addLocationsToLocation(Point location) {

        Point lastLocation = locations.get(locations.size() - 1);
        Point sub = location.sub(lastLocation);
        Point.Direction direction = sub.toDirection();

        while (!lastLocation.equals(location)) {
            lastLocation = lastLocation.add(direction);
            locations.add(lastLocation);
        }
    }

    /**
     * The method is used to get movements from the path, based on the given steps.
     * @param steps the number of steps we want to get from the path.
     * @return Movement object
     */
    public Movement getMovement(int steps) {

        Movement movement = new Movement();

        int number = Math.min(steps, locations.size() - 1);

        for (int i = 0; i < number; i++) {
            Point startLocation = locations.get(i);
            Point endLocation = locations.get(i + 1);
            Point.Direction direction = endLocation.sub(startLocation).toDirection();
            movement.addMove(direction);
        }

        return movement;
    }

    /**
     * The method is to compare two path object.
     * @param path Path
     * @return boolean
     */
    protected boolean equalsToPath(Path path) {

//        for (Point point : this) {
//            for (Point targetPoint : path) {
//                if (!point.equals(targetPoint)) {
//                    return false;
//                }
//            }
//        }

        List<Point> targetLocations = path.getLocations();
        if (locations.size() != targetLocations.size()) {
            return false;
        }
        for (int i = 0; i < locations.size(); i++) {
            if (!locations.get(i).equals(targetLocations.get(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * The override method of iterable, which means the Path object is iterable.
     * @return Iterator object
     */
    @Override
    public Iterator<Point> iterator() {
        return locations.iterator();
    }
}
