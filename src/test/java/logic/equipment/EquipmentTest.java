package logic.equipment;

import logic.map.GameMap;
import logic.map.GameMapGraph;
import logic.map.Point;
import logic.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by GU_HAN on 2017-02-26.
 * @author GU_HAN
 * @version 0.3
 *
 * This class is to test the class of Equipment.
 */
public class EquipmentTest {
    /**
     * This parameter is the pre-defined equipment.
     */
    Equipment equipment;

    /**
     * This case tests if a weapon can be correctly created.
     * @throws Exception
     */
    @Test
    public void validateWeapon() throws Exception {
        EquipmentFactory equipmentFactory = new EquipmentFactory();

        Weapon weapon = equipmentFactory.newWeapon();
        weapon.setType(Equipment.WEAPON);
        weapon.setEnhancedValue(3);
        weapon.setEnhancedAttribute(Player.ATTRIBUTE_ARMOR_CLASS);
        weapon.setRange(2);
        weapon.setWeaponType(Weapon.Type.RANGED);

        Assert.assertTrue(!weapon.validate());


        weapon = equipmentFactory.newWeapon();
        weapon.setType(Equipment.WEAPON);
        weapon.setEnhancedAttribute(Player.ABILITY_STR);
        weapon.setEnhancedValue(1);
        weapon.setRange(1);
        weapon.setWeaponType(Weapon.Type.RANGED);

        Assert.assertTrue(!weapon.validate());


        weapon = equipmentFactory.newWeapon();
        weapon.setType(Equipment.WEAPON);
        weapon.setEnhancedAttribute(Player.ATTRIBUTE_DAMAGE_BONUS);
        weapon.setEnhancedValue(2);
        weapon.setRange(1);
        weapon.setWeaponType(Weapon.Type.MELEE);

        Assert.assertTrue(weapon.validate());
    }

    /**
     * This case tests if the shield can be correctly created.
     * @throws Exception
     */
    @Test
    public void validateShield() throws Exception {
        EquipmentFactory equipmentFactory = new EquipmentFactory();

        equipment = equipmentFactory.newEquipment("", Equipment.SHIELD, Player.ATTRIBUTE_ATTACK_BONUS, 5);
        Assert.assertEquals(false, equipment.validate());

        equipment = equipmentFactory.newEquipment("", Equipment.SHIELD, Player.ATTRIBUTE_ARMOR_CLASS, 5);
        Assert.assertEquals(true, equipment.validate());
    }

    /**
     * This case tests the normal equipment-creation.
     * @throws Exception
     */
    @Test
    public void validateBoots() throws Exception{
        EquipmentFactory equipmentFactory = new EquipmentFactory();

        equipment = equipmentFactory.newEquipment("", Equipment.BOOTS, Player.ABILITY_DEX, 1);
        Assert.assertEquals(true, equipment.validate());
    }

    /**
     * This method tests the decorator.
     * @throws Exception
     */
    @Test
    public void decoratorTest() throws Exception{
        EquipmentFactory equipmentFactory = new EquipmentFactory();

        Weapon weapon = equipmentFactory.newWeapon();
        weapon.setType(Equipment.WEAPON);
        String pre = weapon.enchantmentsChainText();
        WeaponDecoratorBurning weaponDecoratorBurning = new WeaponDecoratorBurning(weapon);
        String now = weaponDecoratorBurning.enchantmentsChainText();
        System.out.println(now);
        Assert.assertTrue(now.endsWith(pre+ " Burning "));
    }

    /**
     * This method tests the range.
     * @throws Exception
     */
    @Test
    public void rangeWeapon() throws Exception {

        Player player1 = new Player();
        Player player2 = new Player();

        EquipmentFactory equipmentFactory = new EquipmentFactory();

        Weapon weapon = equipmentFactory.newWeapon();
        weapon.setType(Equipment.WEAPON);
        weapon.setEnhancedValue(3);
        weapon.setEnhancedAttribute(Player.ATTRIBUTE_ARMOR_CLASS);
        weapon.setRange(3);
        weapon.setWeaponType(Weapon.Type.RANGED);

        player1.pickUpEquipment(weapon);
        player1.equip(weapon);
//        player1.attack(player2);

        GameMap gameMap = new GameMap();
        gameMap.setWidth(5);
        gameMap.setHeight(5);
        gameMap.addCell(player1, new Point(0, 0));
        gameMap.addCell(player2, new Point(0, 2));

        GameMapGraph gameMapGraph = gameMap.getGraph();
        gameMapGraph.ignoreAll();
        List<Point> points = gameMapGraph.pointsInRange(player1.getLocation(), player1.getRangeForAttack());

//        points = points.stream()
//                .filter(p -> couldAttack(p))
//                .collect(Collectors.toList());
//        List<Point> points = new TurnStrategyAggressive().attackTargetsInNear();

        if (points.size() == 0) {
            return;
        }



//        GameMap gameMap = PlayRuntime.currentRuntime().getMap().addCell();

        Assert.assertTrue(weapon.getRange() == 3);
    }
}