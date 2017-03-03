package logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-01.
 * @author GU_HAN
 * @version 0.1
 *
 * This class is for testing the map.
 */
public class MapValidatorTest {

    /**
     * This method tests if the map has no entrance.
     * @throws Exception
     */
    @Test
    public void testNoEntrance() throws Exception{
        Point point = new Point(3, 3);
        GameMap gameMap1 = Simulation.gameMap1();
        gameMap1.removeCell(point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_NO_ENTRANCE, gameMap1.validate());
    }

    /**
     * This case tests if the map can have more than one entrance.
     * @throws Exception
     */
    @Test
    public void testTooMuchEntrance() throws Exception{
        Point point = new Point(0, 0);
        Entrance entrance = new Entrance();
        GameMap gameMap2 = Simulation.gameMap1();
        gameMap2.addCell(entrance, point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_TOO_MUCH_ENTRANCE, gameMap2.validate());
    }

    /**
     * This case tests if the map has no exits.
     * @throws Exception
     */
    @Test
    public void testNoExits() throws Exception{
        Point point = new Point(1, 1);
        GameMap gameMap3 = Simulation.gameMap1();
        gameMap3.removeCell(point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_NO_EXIT, gameMap3.validate());
    }

    /**
     * This case tests if the map has too much exits.
     * @throws Exception
     */
    @Test
    public void testTooMuchExits() throws Exception{
        Point point = new Point(0, 1);
        GameMap gameMap4 = Simulation.gameMap1();
        Exit exit = new Exit();
        gameMap4.addCell(exit, point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_TOO_MUCH_EXIT, gameMap4.validate());
    }

    /**
     * This case tests if the map can be reached to the exit.
     * @throws Exception
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

    /**
     * This case tests if the map cannot be reached to the exit.
     * @throws Exception
     */
    @Test
    public void testNotConnection() throws Exception{
        GameMap gameMap6 = Simulation.gameMap1();
        Obstacle obstacle1 = new Obstacle();
        Obstacle obstacle2 = new Obstacle();
        Point point1 = new Point(2, 3);
        Point point2 = new Point(3, 2);

        gameMap6.addCell(obstacle1, point1);
        gameMap6.addCell(obstacle2, point2);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_EXIT_IS_NOT_REACHABLE, gameMap6.validate());
    }


}