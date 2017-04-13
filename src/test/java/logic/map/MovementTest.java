package logic.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Kai Qi
 * @version 0.3
 */
public class MovementTest {

    /**
     * These parameters are for initializing.
     */
    private Movement movement;
    private Point.Direction move1;
    private Point.Direction move2;
    private Point.Direction move3;
    private Point.Direction move4;

    /**
     * This method is for initializing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        movement = new Movement();
        move1 = Point.Direction.UP;
        move2 = Point.Direction.DOWN;
        move3 = Point.Direction.LEFT;
        move4 = Point.Direction.RIGHT;
        movement.addMove(move1);
    }

    /**
     * This method tests the addMove.
     * @throws Exception
     */
    @Test
    public void addMove() throws Exception {
        Assert.assertEquals(1, movement.getMoves().size());
        movement.addMove(move2);
        movement.addMove(move3);
        movement.addMove(move4);
        Assert.assertEquals(4, movement.getMoves().size());
    }

}