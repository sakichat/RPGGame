package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persistence.MapFileManager;

/**
 * Created by GU_HAN on 2017-03-01.
 * @author GU_HAN
 * @version 0.1
 *
 * This class is for testing the map.
 */
public class MapValidatorTest {

    private GameMap gameMapTest;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = new GameMap();
        gameMap.setWidth(4);
        gameMap.setHeight(6);
        Exit exit1 = new Exit();
        Entrance entrance = new Entrance();

        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);

        gameMap.addCell(exit1, point1);
        gameMap.addCell(entrance, point2);

        gameMapTest = gameMap;
    }

    /**
     * This method tests if the map has no entrance.
     * @throws Exception
     */
    @Test
    public void testNoEntrance() throws Exception{
        Point point = new Point(3, 3);
        gameMapTest.removeCell(point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_NO_ENTRANCE, gameMapTest.validate());
    }

    /**
     * This case tests if the map can have more than one entrance.
     * @throws Exception
     */
    @Test
    public void testTooMuchEntrance() throws Exception{
        Point point = new Point(0, 0);
        Entrance entrance = new Entrance();
        gameMapTest.addCell(entrance, point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_TOO_MUCH_ENTRANCE, gameMapTest.validate());
    }

    /**
     * This case tests if the map has no exits.
     * @throws Exception
     */
    @Test
    public void testNoExits() throws Exception{
        Point point = new Point(1, 1);
        gameMapTest.removeCell(point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_NO_EXIT, gameMapTest.validate());
    }

    /**
     * This case tests if the map has too much exits.
     * @throws Exception
     */
    @Test
    public void testTooMuchExits() throws Exception{
        Point point = new Point(0, 1);
        Exit exit = new Exit();
        gameMapTest.addCell(exit, point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_TOO_MUCH_EXIT, gameMapTest.validate());
    }

    /**
     * This case tests if the map can be reached to the exit.
     * @throws Exception
     */
    @Test
    public void testConnection() throws Exception{
        Obstacle obstacle1 = new Obstacle();
        Obstacle obstacle2 = new Obstacle();
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 2);

        gameMapTest.addCell(obstacle1, point1);
        gameMapTest.addCell(obstacle2, point2);

        Assert.assertEquals(GameMap.VALIDATION_SUCCESS, gameMapTest.validate());
    }

    /**
     * This case tests if the map cannot be reached to the exit.
     * @throws Exception
     */
    @Test
    public void testNotConnection() throws Exception{
        Obstacle obstacle1 = new Obstacle();
        Obstacle obstacle2 = new Obstacle();
        Obstacle obstacle3 = new Obstacle();
        Point point1 = new Point(2, 3);
        Point point2 = new Point(3, 2);
        Point point3 = new Point(3, 4);

        gameMapTest.addCell(obstacle1, point1);
        gameMapTest.addCell(obstacle2, point2);
        gameMapTest.addCell(obstacle3, point3);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_EXIT_IS_NOT_REACHABLE, gameMapTest.validate());
    }

    /**
     * This method tests if the map can be saved when player is not defined its party.
     * @throws Exception
     */
    @Test
    public void testPlayerNotDefined() throws Exception {
        GameMap gameMap = MapFileManager.read("libeng");
        Player player = new Player();
        gameMap.addCell(player, new Point(3, 3));

        Assert.assertEquals(GameMap.VALIDATION_ERROR_PLAYER_IS_NOT_DEFINED, gameMap.validate());
    }
}