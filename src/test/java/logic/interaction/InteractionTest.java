package logic.interaction;

import logic.equipment.Equipment;
import logic.equipment.EquipmentFactory;
import logic.map.Chest;
import logic.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-04-12.
 */
public class InteractionTest {
    private Player player;
    private Interaction interaction;
    private Chest chest;
    private Player friendlyNPC;
    private Player hostileNPC;
    private Player deadNPC;
    @Before
    public void setUp() throws Exception {
        player = new Player();
        player.generateAbilities();

        EquipmentFactory equipmentFactory = new EquipmentFactory();

        Equipment equipmentArmorAC1   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,1);
        Equipment equipmentArmorAC3   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,3);
        Equipment equipmentArmorAC5   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,5);
        Equipment equipmentHelmetInt3 = equipmentFactory.newEquipment("A", Equipment.HELMET,Player.ABILITY_INT,3);
        Equipment equipmentHelmetWis5 = equipmentFactory.newEquipment("A", Equipment.HELMET,Player.ABILITY_WIS,5);
        Equipment equipmentHelmetAC2  = equipmentFactory.newEquipment("A", Equipment.HELMET,Player.ATTRIBUTE_ARMOR_CLASS,2);
        Equipment equipmentShieldAC3  = equipmentFactory.newEquipment("A", Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,3);
        Equipment equipmentShieldAC4  = equipmentFactory.newEquipment("A", Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,4);
        Equipment equipmentShieldAC5  = equipmentFactory.newEquipment("A", Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,5);
        Equipment equipmentBeltCon3   = equipmentFactory.newEquipment("A", Equipment.BELT,  Player.ABILITY_CON,3);
        //Items below are pre-defined items.
        Equipment equipmentBeltStr4   = equipmentFactory.newEquipment("A", Equipment.BELT,  Player.ABILITY_STR,4);
        Equipment equipmentBootsAC3   = equipmentFactory.newEquipment("A", Equipment.BOOTS, Player.ATTRIBUTE_ARMOR_CLASS, 3);
        Equipment equipmentRingCon3   = equipmentFactory.newEquipment("A", Equipment.RING,  Player.ABILITY_CON, 3);
        Equipment equipmentWeaponAB5  = equipmentFactory.newEquipment("A", Equipment.WEAPON,Player.ATTRIBUTE_ATTACK_BONUS, 5);

        chest = new Chest();
        chest.addEquipment(equipmentArmorAC1);
        chest.addEquipment(equipmentArmorAC3);
        chest.addEquipment(equipmentArmorAC5);
    }


    @Test
    public void interactChest() throws Exception {
        InteractionFactory interactionFactory = new InteractionFactory();
        int pre = player.equipmentsInBackpack().size();
        int chestSize = chest.getEquipments().size();

        Interaction interaction = interactionFactory.interaction(player, chest);
        interaction.interact();

        int now = player.equipmentsInBackpack().size();



        System.out.println(pre+" "+chestSize+" "+now);
        Assert.assertTrue(pre + chestSize == now);

    }

}