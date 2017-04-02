package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-01.
 * @author GU_HAN
 * @version 0.2
 *
 * This class tests map validation.
 */
public class MapValidatorTest {
    /**
     * This parameter is to define a GameMap as an arttribute.
     */
    private GameMap gameMapTest;

    /**
     * This method is for initializing the gameMap.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        GameMap gameMap = new GameMap();
        gameMap.setWidth(4);
        gameMap.setHeight(6);
        Exit exit = new Exit();
        Entrance entrance = new Entrance();

        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);

        gameMap.addCell(exit, point1);
        gameMap.addCell(entrance, point2);

        gameMapTest = gameMap;
    }

    /**
     * This case tests if the map has no entrance.
     * @throws Exception
     */
    @Test
    public void validate1() throws Exception{
        Point point = new Point(3, 3);
        gameMapTest.removeCell(point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_NO_ENTRANCE, gameMapTest.validate());
    }

    /**
     * This case tests if the map can have more than one entrance.
     * @throws Exception
     */
    @Test
    public void validate2() throws Exception{
        Point point = new Point(0, 0);
        Entrance entrance = new Entrance();
        gameMapTest.addCell(entrance, point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_TOO_MANY_ENTRANCES, gameMapTest.validate());
    }

    /**
     * This case tests if the map has no exits.
     * @throws Exception
     */
    @Test
    public void validate3() throws Exception{
        Point point = new Point(1, 1);
        gameMapTest.removeCell(point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_NO_EXIT, gameMapTest.validate());
    }

    /**
     * This case tests if the map has too much exits.
     * @throws Exception
     */
    @Test
    public void validate4() throws Exception{
        Point point = new Point(0, 1);
        Exit exit = new Exit();
        gameMapTest.addCell(exit, point);

        Assert.assertEquals(GameMap.VALIDATION_ERROR_TOO_MANY_EXITS, gameMapTest.validate());
    }

    /**
     * This case tests if the map can be reached to the exit.
     * @throws Exception
     */
    @Test
    public void validate5() throws Exception{
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
    public void validate6() throws Exception{
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
     * This case tests if the map can be saved when player is not defined its party.
     * @throws Exception
     */
    @Test
    public void validate7() throws Exception {
        Player player = new Player();
        gameMapTest.addCell(player, new Point(0, 0));

        Assert.assertEquals(GameMap.VALIDATION_ERROR_PLAYER_IS_NOT_DEFINED, gameMapTest.validate());
    }

    @Test
    public void addCell() throws Exception {


    }

    @Test
    public void removeCell() throws Exception {
        

    }
}