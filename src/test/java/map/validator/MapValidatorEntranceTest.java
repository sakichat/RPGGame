package map.validator;

import game.Simulation;
import map.Entrance;
import map.GameMap;
import map.Point;
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
     * This method tests if the map has only one entrance.
     */
    @Test
    public void validateEnrance() throws Exception{
        MapValidatorEntrance mapValidatorEntrance = new MapValidatorEntrance();
        mapValidatorEntrance.gameMap = Simulation.gameMap1();

        Assert.assertEquals(true, mapValidatorEntrance.validate());
    }

    /*
     * This method tests if the map have two entrances.
     */
    @Test
    public void validateEntrance() throws Exception{
        GameMap gameMap2 = Simulation.gameMap1();
        Point point = new Point(0, 0);
        Entrance entrance = new Entrance();
        gameMap2.addCell(entrance, point);

        MapValidatorEntrance mapValidatorEntrance = new MapValidatorEntrance();
        mapValidatorEntrance.gameMap = gameMap2;

        Assert.assertEquals(false, mapValidatorEntrance);

    }

}