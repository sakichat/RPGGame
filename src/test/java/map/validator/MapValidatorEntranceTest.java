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
        mapValidatorEntrance.setGameMap(Simulation.gameMap1());

        Assert.assertEquals(true, mapValidatorEntrance.validate());
    }

    /*
     * This method tests if the map have two entrances.
     */
    @Test
    public void validateEntrance2() throws Exception{
        GameMap gameMap2 = Simulation.gameMap1();
        Point point = new Point(0, 0);
        Entrance entrance = new Entrance();
        gameMap2.addCell(entrance, point);

        MapValidatorEntrance mapValidatorEntrance = new MapValidatorEntrance();
        mapValidatorEntrance.setGameMap(gameMap2);

        Assert.assertEquals(false, mapValidatorEntrance.validate());

    }

//    @Test
//    public void validateEntrance3() throws Exception{
//        Point point = new Point(3, 3);
//        GameMap gameMap2 = Simulation.gameMap1();
//        gameMap2.removeCell(point);
//
//        MapValidatorEntrance mapValidatorEntrance = new MapValidatorEntrance();
//        mapValidatorEntrance.setGameMap(gameMap2);
//
//        Assert.assertEquals(false, mapValidatorEntrance.validate());
//    }

}