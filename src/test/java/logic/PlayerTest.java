package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persistence.MapFileManager;
import persistence.PlayerFileManager;

/**
 * Created by GU_HAN on 2017-02-26.
 * @author GU_HAN
 * @version 0.2
 *
 * This class is basically for class of player's tests.
 */
public class PlayerTest {
    private Player player;
    private Equipment equipment1;
    private Equipment equipment2;
    private Equipment equipment3;
    private Equipment equipment4;
    private Equipment equipment5;
    private Equipment equipment6;
    private Equipment equipment7;
    private Equipment equipment8;
    private Equipment equipment9;
    private Equipment equipment10;
    private Equipment equipment11;
    private Equipment equipment12;
    private Equipment equipment13;
    private Equipment equipment14;
    private Equipment equipment15;
    private Equipment equipment16;
    private Equipment equipment17;
    private Equipment equipment18;
    private Equipment equipment19;
    private Equipment equipment20;
    private Equipment equipment21;
    private Equipment equipment22;
    private Equipment equipment23;

    /**
     * This method set up first few steps before the actual tests.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        player = new Player();
        player.generateAbilities();

        equipment1 = new Equipment("Light Leather",Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,1);

        equipment2 = new Equipment("Quilted Leather",Equipment.ARMOR,Player.ATTRIBUTE_ARMOR_CLASS,3);

        equipment3 = new Equipment("Arming Coat",Equipment.ARMOR,Player.ATTRIBUTE_ARMOR_CLASS,5);

        equipment4 = new Equipment("Might of Dread",Equipment.HELMET,Player.ABILITY_INT,3);

        equipment5 = new Equipment("Coif of Delusions",Equipment.HELMET,Player.ABILITY_WIS,5);

        equipment6 = new Equipment("Dawn of Insanity",Equipment.HELMET,Player.ATTRIBUTE_ARMOR_CLASS,2);

        equipment7 = new Equipment("Oathkeeper",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,3);

        equipment8 = new Equipment("Ghostwalker",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,4);

        equipment9 = new Equipment("Sierra",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,5);

        equipment10 = new Equipment("Linen Sash",Equipment.BELT,Player.ABILITY_CON,3);

        equipment11 = new Equipment("Loyal Wool Sash",Equipment.BELT,Player.ABILITY_STR,4);

        equipment12 = new Equipment("Cord of Beginnings",Equipment.BELT,Player.ABILITY_CON,5);

        equipment13 = new Equipment("Steel Walkers",Equipment.BOOTS,Player.ATTRIBUTE_ARMOR_CLASS,3);

        equipment14 = new Equipment("Bronze Warboots",Equipment.BOOTS,Player.ABILITY_DEX,4);

        equipment15 = new Equipment("Bone Stompers",Equipment.BOOTS,Player.ABILITY_DEX,5);

        equipment16 = new Equipment("Ashbringer",Equipment.WEAPON,Player.ATTRIBUTE_ATTACK_BONUS,5);

        equipment17 = new Equipment("Axe of Cenarius",Equipment.WEAPON,Player.ATTRIBUTE_DAMAGE_BONUS,5);

        equipment18 = new Equipment("Bloodhoof Runespear",Equipment.WEAPON,Player.ATTRIBUTE_DAMAGE_BONUS,5);

        equipment19 = new Equipment("Phyrix's Embrace",Equipment.RING,Player.ATTRIBUTE_ARMOR_CLASS,2);

        equipment20 = new Equipment("Sephuz's Secret",Equipment.RING,Player.ABILITY_STR,2);

        equipment21 = new Equipment("Alythess's Pyrogenics",Equipment.RING,Player.ABILITY_CON,3);

        equipment22 = new Equipment("Chatoyant Signet",Equipment.RING,Player.ABILITY_WIS,5);

        equipment23 = new Equipment("Dual Determination",Equipment.RING, Player.ABILITY_CHA,5);

        player.pickUpEquipment(equipment1);
        player.pickUpEquipment(equipment2);
        player.pickUpEquipment(equipment3);
        player.pickUpEquipment(equipment4);
        player.pickUpEquipment(equipment5);
        player.pickUpEquipment(equipment6);
        player.pickUpEquipment(equipment7);
        player.pickUpEquipment(equipment8);
        player.pickUpEquipment(equipment9);
        player.pickUpEquipment(equipment10);
    }

    /**
     * This method test if it is empty in the backpack.
     * @throws Exception
     */
    @Test
    public void testEmptyBackpack() throws Exception {
        player.dropEquipment(equipment1);
        player.dropEquipment(equipment2);
        player.dropEquipment(equipment3);
        player.dropEquipment(equipment4);
        player.dropEquipment(equipment5);
        player.dropEquipment(equipment6);
        player.dropEquipment(equipment7);
        player.dropEquipment(equipment8);
        player.dropEquipment(equipment9);
        player.dropEquipment(equipment10);

        Assert.assertEquals(true, player.equipmentsInBackpack().isEmpty());
    }

    /**
     * This method test if it is already empty in the backpack, can we still drop items.
     * @throws Exception
     */
    @Test
    public void testEmptyBackpack2() throws Exception {
        player.dropEquipment(equipment1);
        player.dropEquipment(equipment2);
        player.dropEquipment(equipment3);
        player.dropEquipment(equipment4);
        player.dropEquipment(equipment5);
        player.dropEquipment(equipment6);
        player.dropEquipment(equipment7);
        player.dropEquipment(equipment8);
        player.dropEquipment(equipment9);
        player.dropEquipment(equipment10);

        player.dropEquipment(equipment1);
        Assert.assertEquals(0, player.equipmentsInBackpack().size());
    }

    /**
     * This case tests if the wearing items can change the attributes.
     * @throws Exception
     */
    @Test
    public void testItemReflectAbilities() throws Exception {
        int pre = player.getTotalAbilityScore(Player.ABILITY_INT);
        player.equip(equipment4);
        int now = player.getTotalAbilityScore(Player.ABILITY_INT);

        Assert.assertEquals(pre, now - equipment4.getEnhancedValue());
    }

    /**
     * This method tests if player can drop unexisting items.
     * @throws Exception
     */
    @Test
    public void testUnexistingEquipmentDrop() throws Exception {
        player.dropEquipment(equipment1);
        player.dropEquipment(equipment11);
        Assert.assertEquals(9, player.equipmentsInBackpack().size());
    }

    /**
     * This method tests if player can still pick up items when backpack is full.
     * @throws Exception
     */
    @Test
    public void testFullBackPack() throws Exception {


        player.pickUpEquipment(equipment11);
        boolean nowBackpack = player.equipmentsInBackpack().contains(equipment11);

        Assert.assertEquals(false, nowBackpack);
    }

    /**
     * This method tests if player can wear more than one item of the same category.
     * @throws Exception
     */
    @Test
    public void testOneItemOfEachKind() throws Exception {
        int pre = player.getTotalAbilityScore(Player.ABILITY_CON);
        player.equip(equipment10);
        player.pickUpEquipment(equipment12);
        player.equip(equipment12);
        int now = player.getTotalAbilityScore(Player.ABILITY_CON);

        Assert.assertEquals(pre, now - equipment12.getEnhancedValue());
    }

    /**
     * This method test if the player will correctly loot the chest.
     * @throws Exception
     */
    @Test
    public void testLooting() throws Exception {
        Player testPlayer = PlayerFileManager.read("asheley");
        Equipment a = testPlayer.equipmentsInBackpack().get(0);
        int previousSize = testPlayer.equipmentsInBackpack().size();

        Chest testChest = (Chest)(MapFileManager.read("saege bay").getCell(new Point(1, 5)));
        Equipment a1 = testChest.getEquipments().get(0);

        testPlayer.lootChest(testChest);

        Assert.assertEquals(a1, testPlayer.equipmentsInBackpack().get(previousSize));

    }

    /**
     * This method is to test if the player will successfully loot the chest.
     * @throws Exception
     */
    @Test
    public void testNotLooting() throws Exception {
        Player testPlayer = player;
        int previousSize = testPlayer.equipmentsInBackpack().size();
        Equipment a = testPlayer.equipmentsInBackpack().get(previousSize - 1);

        Chest testChest = (Chest)(MapFileManager.read("saege bay").getCell(new Point(1, 5)));
        Equipment a1 = testChest.getEquipments().get(0);

        testPlayer.lootChest(testChest);

        Assert.assertEquals(false, a1 == testPlayer.equipmentsInBackpack().get(previousSize - 1));

    }

}