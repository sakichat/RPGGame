package logic.map;

import logic.player.Player;
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
public class GameMapTest {
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

        gameMap.addCell(new Exit()    , new Point(1, 1));
        gameMap.addCell(new Entrance(), new Point(3, 3));

        gameMapTest = gameMap;
    }

    /**
     * This case tests if the map has no entrance.
     * @throws Exception
     */
    @Test
    public void validate1() throws Exception{
        gameMapTest.removeCell(new Point(3, 3));

        String noEntrance = gameMapTest.validate();

        Assert.assertTrue(GameMap.VALIDATION_ERROR_NO_ENTRANCE == noEntrance);
    }

    /**
     * This case tests if the map can have more than one entrance.
     * @throws Exception
     */
    @Test
    public void validate2() throws Exception{
        gameMapTest.addCell(new Entrance(), new Point(0, 0));

        String multiEntrance = gameMapTest.validate();

        Assert.assertTrue(GameMap.VALIDATION_ERROR_TOO_MANY_ENTRANCES == multiEntrance);
    }

    /**
     * This case tests if the map has no exits.
     * @throws Exception
     */
    @Test
    public void validate3() throws Exception{
        gameMapTest.removeCell(new Point(1, 1));

        String noExit = gameMapTest.validate();

        Assert.assertTrue(GameMap.VALIDATION_ERROR_NO_EXIT == noExit);
    }

    /**
     * This case tests if the map has more than one exit.
     * @throws Exception
     */
    @Test
    public void validate4() throws Exception{
        gameMapTest.addCell(new Exit(), new Point(0, 1));

        String multiExit = gameMapTest.validate();

        Assert.assertTrue(GameMap.VALIDATION_ERROR_TOO_MANY_EXITS == multiExit);
    }

    /**
     * This case tests if the map can be reached to the exit.
     * @throws Exception
     */
    @Test
    public void validate5() throws Exception{
        gameMapTest.addCell(new Obstacle(), new Point(0, 0));
        gameMapTest.addCell(new Obstacle(), new Point(2, 2));

        String reachable = gameMapTest.validate();
        System.out.println(reachable);

        Assert.assertTrue(GameMap.VALIDATION_SUCCESS == gameMapTest.validate());
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

        gameMapTest.addCell(new Obstacle(), new Point(2, 3));
        gameMapTest.addCell(new Obstacle(), new Point(3, 2));
        gameMapTest.addCell(new Obstacle(), new Point(3, 4));

        Assert.assertEquals(GameMap.VALIDATION_ERROR_EXIT_IS_NOT_REACHABLE, gameMapTest.validate());
    }

    /**
     * This case tests if the map can be saved when currentPlayer is not defined its party.
     * @throws Exception
     */
    @Test
    public void validate7() throws Exception {
        gameMapTest.addCell(new Player(), new Point(0, 0));

        Assert.assertEquals(GameMap.VALIDATION_ERROR_PLAYER_IS_NOT_DEFINED, gameMapTest.validate());
    }
}