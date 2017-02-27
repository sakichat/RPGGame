package game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-02-26.
 * @author GU_HAN
 * @version 1.0.0
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

    /*
     * This method set up first few steps before the actual tests.
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

        equipment23 = new Equipment("Dual Determination",Equipment.RING,Player.ABILITY_CHA,5);

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

    /*
     * This method test if it is empty in the backpack.
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

    /*
     * This method test if it is already empty in the backpack, can we still drop items.
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

    /*
     * This method tests if the item worn in player can change the attribute.
     */
    @Test
    public void testItemReflectAbilities() throws Exception {
        int pre = player.getTotalAbilityScore(Player.ABILITY_INT);
        player.equip(equipment4);
        int now = player.getTotalAbilityScore(Player.ABILITY_INT);

        Assert.assertEquals(pre, now - 3);
    }

    /*
     * This method tests if player can drop unexisting items.
     */
    @Test
    public void testUnexistingEquipmentDrop() throws Exception {
        player.dropEquipment(equipment1);
        player.dropEquipment(equipment11);
        Assert.assertEquals(9, player.equipmentsInBackpack().size());
    }

    /*
     * This method tests if player can still pick up items when backpack is full.
     */
    @Test
    public void testFullBackPack() throws Exception {


        player.pickUpEquipment(equipment11);
        boolean nowBackpack = player.equipmentsInBackpack().contains(equipment11);

        Assert.assertEquals(false, nowBackpack);
    }

    /*
     * This method tests if player can pick up some items unqualified.
     */
    @Test
    public void testPickupUnqualifiedEquipment() throws Exception {
        Equipment unqualifiedEquipment = new Equipment("", null, Player.ABILITY_STR, 4);
        int previousStr = player.getTotalAbilityScore(Player.ABILITY_STR);
        int nowStr;
        player.dropEquipment(equipment1);
        player.pickUpEquipment(unqualifiedEquipment);
        player.equip(unqualifiedEquipment);
        nowStr = player.getTotalAbilityScore(Player.ABILITY_STR);

        Assert.assertEquals(previousStr, nowStr);
    }

    /*
     * This methods test if player can put unqualified items in backpack.
     */
    @Test
    public void testUnqualifiedEquipPickup() throws Exception {
        Equipment unqualifiedEquipment = new Equipment("", null, Player.ABILITY_STR, 4);
        player.dropEquipment(equipment1);
        player.pickUpEquipment(unqualifiedEquipment);
        boolean containIt = player.equipmentsInBackpack().contains(unqualifiedEquipment);

        Assert.assertEquals(false, containIt);
    }

    /*
     * This method tests if player can wear more than one item of the same category.
     */
    @Test
    public void testOneItemOfEachKind() throws Exception {
        int pre = player.getTotalAbilityScore(Player.ABILITY_CON);
        player.equip(equipment10);
        player.pickUpEquipment(equipment12);
        player.equip(equipment12);
        int now = player.getTotalAbilityScore(Player.ABILITY_CON);

        Assert.assertEquals(pre, now - 5);
    }

    /*
     * This method tests the ordinary cases when picking up and dropping.
     */
    @Test
    public void test() throws Exception {
        int pre = player.getTotalAbilityScore(Player.ABILITY_STR);
        player.dropEquipment(equipment4);
        player.dropEquipment(equipment1);
        player.pickUpEquipment(equipment20);
        player.pickUpEquipment(equipment21);
        int now = player.getTotalAbilityScore(Player.ABILITY_STR);

        Assert.assertEquals(pre, now);
    }



}