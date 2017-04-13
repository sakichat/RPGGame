package logic.map;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kai QI
 * @version 0.3
 * The class is Movement.
 * In movement object, the moves players should follow are stored.
 */

public class Movement implements Iterable<Point.Direction> {

    /**
     * The declaration of the property moves.
     */
    private List<Point.Direction> moves = new LinkedList<>();

    /**
     * Getter for the property moves, which will be called in the testCase.
     * @return List
     */
    List<Point.Direction> getMoves() {
        return moves;
    }

    /**
     * The method is used to add every move into the move list.
     * @param move every single move, which should be the enum item in the Direction class.
     */
    public void addMove(Point.Direction move){
        moves.add(move);
    }

    /**
     * The override method of iterable, which means the Movement object is iterable.
     * @return Iterator object
     */
    @Override
    public Iterator<Point.Direction> iterator() {
        return moves.iterator();
    }

    /**
     * The override method of toString.
     * @return
     */
    @Override
    public String toString() {
        return "Movement " + moves;
    }
}
