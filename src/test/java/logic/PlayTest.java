package logic;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-20.
 */
public class PlayTest {
    @Before
    public void setUp() throws Exception {
        GameMap gameMap = new GameMap();
        gameMap.addCell(new Entrance(), new Point(5,5));
        gameMap.addCell(new Exit(), new Point(3,3));


    }

    @Test
    public void moveTest() throws Exception {

    }

    @Test
    public void cannotMoveTest() throws Exception {

    }
}