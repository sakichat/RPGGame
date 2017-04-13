package logic.interaction;

import logic.Play;
import logic.PlayRuntime;
import logic.equipment.Equipment;
import logic.equipment.EquipmentFactory;
import logic.map.Chest;
import logic.map.Point;
import logic.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persistence.MapFileManager;

/**
 * Created by GU_HAN on 2017-04-12.
 */
public class InteractionTest {
    private Player player;
    private Player player2;
    private Interaction interaction;
    private Chest chest;
    private Player friendlyNPC;
    private Player hostileNPC;
    private Player deadNPC;
    @Before
    public void setUp() throws Exception {
        player = new Player();
        player2 = new Player();

        EquipmentFactory equipmentFactory = new EquipmentFactory();

        Equipment equipmentArmorAC1   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,1);
        Equipment equipmentArmorAC3   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,3);
        Equipment equipmentArmorAC5   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,5);
        Equipment equipmentBeltCon3   = equipmentFactory.newEquipment("A", Equipment.BELT,  Player.ABILITY_CON,3);

        player2.pickUpEquipment(equipmentArmorAC1);
        player2.pickUpEquipment(equipmentArmorAC3);
        player2.pickUpEquipment(equipmentArmorAC5);
        player2.pickUpEquipment(equipmentBeltCon3);

        Play play = new Play();
        play.setCurrentMap(MapFileManager.read("testmap1"));
        PlayRuntime.currentRuntime().setPlay(play);
        chest = (Chest)PlayRuntime.currentRuntime().getMap().getCell(new Point(1, 3));

    }

    /**
     * This method tests looting a chest.
     * @throws Exception
     */
    @Test
    public void interactChest() throws Exception {

        int pre = player.equipmentsInBackpack().size();
        int chestSize = chest.getEquipments().size();

        InteractionFactory interactionFactory = new InteractionFactory();
        Interaction interaction = interactionFactory.interaction(player, chest);
        interaction.interact();

        int now = player.equipmentsInBackpack().size();

        Assert.assertTrue(pre + chestSize == now);
    }

    /**
     * This method tests looting a chest when the player has many items in backpack.
     * @throws Exception
     */
    @Test
    public void interactChest2() throws Exception {

        int pre = player2.equipmentsInBackpack().size();
        int chestSize = chest.getEquipments().size();

        InteractionFactory interactionFactory = new InteractionFactory();
        Interaction interaction = interactionFactory.interaction(player2, chest);
        interaction.interact();

        int now = player2.equipmentsInBackpack().size();
        int nowChestSize = chest.getEquipments().size();


        Assert.assertTrue(now == 10);
        Assert.assertTrue(nowChestSize == pre + chestSize -10);
    }
}