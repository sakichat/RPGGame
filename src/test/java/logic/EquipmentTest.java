package logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-02-26.
 * @author GU_HAN
 * @version 0.2
 *
 * This class is to test the class of Equipment.
 */
public class EquipmentTest {
    Equipment equipment;

    /**
     * This case tests if a weapon can be correctly created.
     * @throws Exception
     */
    @Test
    public void validateWeapon() throws Exception {
        equipment = new Equipment("", Equipment.WEAPON, Player.ATTRIBUTE_ARMOR_CLASS, 3);
        Assert.assertEquals(false, equipment.validate());

        equipment = new Equipment("", Equipment.WEAPON, Player.ABILITY_STR, 6);
        Assert.assertEquals(false, equipment.validate());

        equipment = new Equipment("", Equipment.WEAPON, Player.ATTRIBUTE_DAMAGE_BONUS, 2);
        Assert.assertEquals(true, equipment.validate());
    }

    /**
     * This case tests if the shield can be correctly created.
     * @throws Exception
     */
    @Test
    public void validateShield() throws Exception {
        equipment = new Equipment("", Equipment.SHIELD, Player.ATTRIBUTE_ATTACK_BONUS, 5);
        Assert.assertEquals(false, equipment.validate());

        equipment = new Equipment("", Equipment.SHIELD, Player.ATTRIBUTE_ARMOR_CLASS, 5);
        Assert.assertEquals(true, equipment.validate());
    }

    /**
     * This case tests the normal equipment-creation.
     * @throws Exception
     */
    @Test
    public void validateBoots() throws Exception{
        equipment = new Equipment("", Equipment.BOOTS, Player.ABILITY_DEX, 1);
        Assert.assertEquals(true, equipment.validate());
    }
}