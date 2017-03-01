package map.validator;

import game.Simulation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-01.
 */
public class MapValidatorExitTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void validateExit() throws Exception {
        MapValidatorExit mapValidatorExit = new MapValidatorExit();
        mapValidatorExit.gameMap = Simulation.gameMap1();

        Assert.assertEquals(false, mapValidatorExit.validate());
    }


}