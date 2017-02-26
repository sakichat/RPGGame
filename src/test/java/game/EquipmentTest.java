package game;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-02-26.
 */
public class EquipmentTest {
    @Test
    public void validate() throws Exception {
        Equipment equipment;

        equipment = new Equipment("", Equipment.WEAPON, Player.ABILITY_STR, 10);
        Assert.assertEquals(true, equipment.validate());

        equipment = new Equipment("", Equipment.WEAPON, null, 0);
        Assert.assertEquals(true, equipment.validate());

        equipment = new Equipment("", Equipment.WEAPON, Player.ABILITY_STR, 10);
        Assert.assertEquals(true, equipment.validate());


    }

}