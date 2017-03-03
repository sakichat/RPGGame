package map.validator;

import game.Simulation;
import map.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-01.
 */
public class MapValidatorEntranceTest {
    @Before
    public void setUp() throws Exception {

    }

    /*
     * This method tests if the map has no entrance.
     */
    @Test
    public void testNoEntrance() throws Exception{
        Point point = new Point(3, 3);
        GameMap gameMap1 = Simulation.gameMap1();
        gameMap1.removeCell(point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_NO_ENTRANCE, gameMap1.validate());
    }

    /*
     * This case tests if the map can have more than one entrance.
     */
    @Test
    public void testTooMuchEntrance() throws Exception{
        Point point = new Point(0, 0);
        Entrance entrance = new Entrance();
        GameMap gameMap2 = Simulation.gameMap1();
        gameMap2.addCell(entrance, point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_TOO_MUCH_ENTRANCE, gameMap2.validate());
    }

    /*
     * This case tests if the map has no exits.
     */
    @Test
    public void testNoExits() throws Exception{
        Point point = new Point(1, 1);
        GameMap gameMap3 = Simulation.gameMap1();
        gameMap3.removeCell(point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_NO_EXIT, gameMap3.validate());
    }

    /*
     * This case tests if the map has too much exits.
     */
    @Test
    public void testTooMuchExits() throws Exception{
        Point point = new Point(0, 1);
        GameMap gameMap4 = Simulation.gameMap1();
        Exit exit = new Exit();
        gameMap4.addCell(exit, point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_TOO_MUCH_EXIT, gameMap4.validate());
    }

    /*
     * This case tests if the map can be reached to the exit.
     */
    @Test
    public void testConnection() throws Exception{
        GameMap gameMap5 = Simulation.gameMap1();
        Obstacle obstacle1 = new Obstacle();
        Obstacle obstacle2 = new Obstacle();
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 2);

        gameMap5.addCell(obstacle1, point1);
        gameMap5.addCell(obstacle2, point2);

        Assert.assertEquals(GameMap.VALIDATION_SUCCESS, gameMap5.validate());
    }


}