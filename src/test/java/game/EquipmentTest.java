package game;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-02-26.
 */
public class EquipmentTest {
    @Test
    public void validateWeapon() throws Exception {
        Equipment equipment;

        equipment = new Equipment("", Equipment.WEAPON, Player.ATTRIBUTE_ARMOR_CLASS, 3);
        Assert.assertEquals(false, equipment.validate());

        equipment = new Equipment("", Equipment.WEAPON, Player.ABILITY_STR, 6);
        Assert.assertEquals(false, equipment.validate());


    }

    @Test
    public void validateShield() throws Exception {
        Equipment equipment;


        equipment = new Equipment("", Equipment.SHIELD, Player.ATTRIBUTE_ARMOR_CLASS, 5);
        Assert.assertEquals(true, equipment.validate());

        equipment = new Equipment("", Equipment.SHIELD, Player.ATTRIBUTE_ATTACK_BONUS, 5);
        Assert.assertEquals(false, equipment.validate());

    }


    @Test
    public void validateEmpty() throws Exception {
        Equipment equipment;

        equipment = new Equipment("", Equipment.WEAPON, null, 0);
        Assert.assertEquals(false, equipment.validate());

    }

}