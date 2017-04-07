package logic.map;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kai QI
 * @version 0.3
 */

public class Movement implements Iterable<Point.Direction>{
    private List<Point.Direction> moves = new LinkedList<>();

    List<Point.Direction> getMoves() {
        return moves;
    }

    public void addMove(Point.Direction move){
        moves.add(move);
    }

    @Override
    public Iterator<Point.Direction> iterator() {
        return moves.iterator();
    }
}
