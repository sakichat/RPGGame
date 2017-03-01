package map.validator;

import game.Simulation;
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

    @Test
    public void validateEnrance() throws Exception{
        MapValidatorEntrance mapValidatorEntrance = new MapValidatorEntrance();
        mapValidatorEntrance.gameMap = Simulation.gameMap1();

        Assert.assertEquals(false, mapValidatorEntrance.validate());
    }

}