package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persistence.CampaignFileManager;

/**
 * Created by GU_HAN on 2017-02-26.
 * @author GU_HAN
 * @version 0.2
 *
 * This class tests wearing items correctly influence the character's abilities, character cannot wear more than
 * one item of each kind, and looting a chest.
 */
public class PlayerTest {
    /**
     * These parameters is pre-defined attributes for every method in this test class to use.
     */
    private Player player;
    private Equipment equipmentArmorAC1;
    private Equipment equipmentArmorAC3;
    private Equipment equipmentArmorAC5;
    private Equipment equipmentHelmetInt3;
    private Equipment equipmentHelmetWis5;
    private Equipment equipmentHelmetAC2;
    private Equipment equipmentShieldAC3;
    private Equipment equipmentShieldAC4;
    private Equipment equipmentShieldAC5;
    private Equipment equipmentBeltCon3;
    private Equipment equipmentBeltStr4;
    private Equipment equipmentBeltCon5;
    private Equipment equipmentBootsAC3;
    private Equipment equipmentRingCon3;
    private Equipment equipmentWeaponAB5;
    private Chest chest;

    /**
     * This method is for initializing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        player = new Player();
        player.generateAbilities();

        equipmentArmorAC1 = new Equipment("Light Leather"    ,Equipment.ARMOR,Player.ATTRIBUTE_ARMOR_CLASS,1);
        equipmentArmorAC3 = new Equipment("Quilted Leather"  ,Equipment.ARMOR,Player.ATTRIBUTE_ARMOR_CLASS,3);
        equipmentArmorAC5 = new Equipment("Arming Coat"      ,Equipment.ARMOR,Player.ATTRIBUTE_ARMOR_CLASS,5);
        equipmentHelmetInt3 = new Equipment("Might of Dread",Equipment.HELMET,Player.ABILITY_INT,3);
        equipmentHelmetWis5 = new Equipment("Coif of Delusions",Equipment.HELMET,Player.ABILITY_WIS,5);
        equipmentHelmetAC2 = new Equipment("Dawn of Insanity",Equipment.HELMET,Player.ATTRIBUTE_ARMOR_CLASS,2);
        equipmentShieldAC3 = new Equipment("Oathkeeper",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,3);
        equipmentShieldAC4 = new Equipment("Ghostwalker",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,4);
        equipmentShieldAC5 = new Equipment("Sierra",Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,5);
        equipmentBeltCon3 = new Equipment("Linen Sash",Equipment.BELT,Player.ABILITY_CON,3);
        //Items below are pre-defined items.
        equipmentBeltStr4 = new Equipment("Loyal Wool Sash",Equipment.BELT,Player.ABILITY_STR,4);
        equipmentBeltCon5 = new Equipment("Cord of Beginnings",Equipment.BELT,Player.ABILITY_CON,5);
        equipmentBootsAC3 = new Equipment("Steel Walkers", Equipment.BOOTS, Player.ATTRIBUTE_ARMOR_CLASS, 3);
        equipmentRingCon3 = new Equipment("Alythess Pyrogenics", Equipment.RING, Player.ABILITY_CON, 3);
        equipmentWeaponAB5 = new Equipment("Ashbringer", Equipment.WEAPON, Player.ATTRIBUTE_ATTACK_BONUS, 5);

        player.pickUpEquipment(equipmentArmorAC1);
        player.pickUpEquipment(equipmentArmorAC3);
        player.pickUpEquipment(equipmentArmorAC5);
        player.pickUpEquipment(equipmentHelmetInt3);
        player.pickUpEquipment(equipmentHelmetWis5);
        player.pickUpEquipment(equipmentHelmetAC2);
        player.pickUpEquipment(equipmentShieldAC3);
        player.pickUpEquipment(equipmentShieldAC4);
        player.pickUpEquipment(equipmentShieldAC5);
        player.pickUpEquipment(equipmentBeltCon3);

        chest = new Chest();
        chest.addEquipment(equipmentShieldAC3);
        chest.addEquipment(equipmentBootsAC3);
        chest.addEquipment(equipmentRingCon3);
        chest.addEquipment(equipmentWeaponAB5);
    }



    /**
     * This case tests if the wearing items can correctly influence character's abilities.
     * @throws Exception
     */
    @Test
    public void equip() throws Exception {
        int preInt = player.getTotalAbilityScore(Player.ABILITY_INT);
        int preStr = player.getTotalAbilityScore(Player.ABILITY_STR);
        int preDex = player.getTotalAbilityScore(Player.ABILITY_DEX);
        int preCon = player.getTotalAbilityScore(Player.ABILITY_CON);
        int preWis = player.getTotalAbilityScore(Player.ABILITY_WIS);
        int preCha = player.getTotalAbilityScore(Player.ABILITY_CHA);
        int preAC  = player.getArmorClass();
        int preAB  = player.getAttackBonus();
        int preDB  = player.getDamageBonus();

        player.equip(equipmentHelmetInt3);

        int nowInt = player.getTotalAbilityScore(Player.ABILITY_INT);
        int nowStr = player.getTotalAbilityScore(Player.ABILITY_STR);
        int nowDex = player.getTotalAbilityScore(Player.ABILITY_DEX);
        int nowCon = player.getTotalAbilityScore(Player.ABILITY_CON);
        int nowWis = player.getTotalAbilityScore(Player.ABILITY_WIS);
        int nowCha = player.getTotalAbilityScore(Player.ABILITY_CHA);
        int nowAC  = player.getArmorClass();
        int nowAB  = player.getAttackBonus();
        int nowDB  = player.getDamageBonus();

        Assert.assertTrue(preInt == nowInt - equipmentHelmetInt3.getEnhancedValue());

        Assert.assertTrue(preStr == nowStr);

        Assert.assertTrue(preDex == nowDex);

        Assert.assertTrue(preCon == nowCon);

        Assert.assertTrue(preWis == nowWis);

        Assert.assertTrue(preCha == nowCha);

        Assert.assertTrue(preAC  == nowAC);

        Assert.assertTrue(preAB  == nowAB);

        Assert.assertTrue(preDB  == nowDB);
    }

    /**
     * This case tests if player can wear more than one item of each kind, wihch means
     * if the player will drop previous item if he already wears one of the same category.
     * @throws Exception
     */
    @Test
    public void equip2() throws Exception {
        int pre = player.getTotalArmorClass();
        player.equip(equipmentArmorAC1);
        player.equip(equipmentArmorAC3);
        int now = player.getTotalArmorClass();
        player.equip(equipmentArmorAC5);
        int after = player.getTotalArmorClass();

        Assert.assertTrue(pre == now   - equipmentArmorAC3.getEnhancedValue());
        Assert.assertTrue(pre == after - equipmentArmorAC5.getEnhancedValue());
    }

    /**
     * This case tests if player can drop unexisting items.
     * @throws Exception
     */
    @Test
    public void testNonExistingEquipmentDrop() throws Exception {
        player.dropEquipment(equipmentArmorAC1);
        player.dropEquipment(equipmentBeltStr4);

        Assert.assertEquals(9, player.equipmentsInBackpack().size());
    }

    /**
     * This case tests if player can still pick up items when backpack is full.
     * @throws Exception
     */
    @Test
    public void testFullBackPack() throws Exception {
        player.pickUpEquipment(equipmentBeltStr4);
        boolean nowBackpack = player.equipmentsInBackpack().contains(equipmentBeltStr4);

        Assert.assertEquals(false, nowBackpack);
    }

    /**
     * This case tests if the player will correctly loot the chest, which means the player will get
     * the item in the chest to his backpack.
     * @throws Exception
     */
    @Test
    public void testLooting() throws Exception {
        player.dropEquipment(equipmentArmorAC1);
        player.dropEquipment(equipmentArmorAC3);
        player.dropEquipment(equipmentArmorAC5);
        player.dropEquipment(equipmentHelmetInt3);
        player.dropEquipment(equipmentHelmetWis5);
        player.dropEquipment(equipmentHelmetAC2);
        player.dropEquipment(equipmentShieldAC3);
        player.dropEquipment(equipmentShieldAC4);

        int chestSize = chest.getEquipments().size();
        int previousSize = player.equipmentsInBackpack().size();
        player.lootChest(chest);
        int nowSize = player.equipmentsInBackpack().size();
        boolean containItem = player.equipmentsInBackpack().contains(equipmentBootsAC3);

        Assert.assertEquals(nowSize, previousSize + chestSize);
        Assert.assertEquals(true, containItem);
    }

    /**
     * This case tests if the player's operation of looting will make his backpack overloaded.
     * Besides, the chest will keep the left items as well.
     * @throws Exception
     */
    @Test
    public void testFullLooting() throws Exception {
        player.dropEquipment(equipmentArmorAC1);
        player.dropEquipment(equipmentArmorAC3);
        int previousChestSize = chest.getEquipments().size();
        int previousPlayerBackpackSize = player.equipmentsInBackpack().size();
        player.lootChest(chest);
        int nowChestSize = chest.getEquipments().size();

        Assert.assertEquals(true, player.isBackpackFull());
        Assert.assertEquals(nowChestSize, previousChestSize - (10 - previousPlayerBackpackSize));
    }

    @Test
    public void testGenerateAbilities() throws Exception {
        player.generateAbilities(Player.PLAYER_TYPE_BULLY);
        int playerStr = player.getAbilityScore(Player.ABILITY_STR);
        int playerCon = player.getAbilityScore(Player.ABILITY_CON);
        int playerDex = player.getAbilityScore(Player.ABILITY_DEX);
        int playerInt = player.getAbilityScore(Player.ABILITY_INT);
        int playerCha = player.getAbilityScore(Player.ABILITY_CHA);
        int playerWis = player.getAbilityScore(Player.ABILITY_WIS);

        System.out.println(playerStr + " " + playerCon + " " + playerDex + " " + playerInt + " " + playerCha + " " + playerWis);


        Assert.assertEquals(true, playerStr >= playerCon);
        Assert.assertEquals(true, playerCon >= playerDex);
        Assert.assertEquals(true, playerDex >= playerInt);
        Assert.assertEquals(true, playerInt >= playerCha);
        Assert.assertEquals(true, playerCha >= playerWis);
    }

    /**
     * This case tests if the cell will become null after looting the chest to empty.
     * @throws Exception
     */
    @Test
    public void testAfterLooting() throws Exception {
        player.dropEquipment(equipmentArmorAC1);
        player.dropEquipment(equipmentArmorAC3);
        player.dropEquipment(equipmentArmorAC5);
        player.dropEquipment(equipmentHelmetInt3);
        player.dropEquipment(equipmentHelmetWis5);
        player.dropEquipment(equipmentHelmetAC2);
        player.dropEquipment(equipmentShieldAC3);
        player.dropEquipment(equipmentShieldAC4);
        player.dropEquipment(equipmentShieldAC5);
        player.dropEquipment(equipmentBeltCon3);

        Campaign campaign = CampaignFileManager.read("testcampaign");

        Play play = new Play();
        play.setCampaign(campaign);
        play.setPlayer(player);
        play.resolveMap();
        play.setDirection(Point.DIRECTION_DOWN);
        play.move();
        play.move();
        play.setDirection(Point.DIRECTION_RIGHT);
        Point chestLocation = play.getTartget().getLocation();

        play.getPlayer().lootChest((Chest)(play.getTartget()));
        play.refreshChest();

        Assert.assertEquals(null, play.getCurrentMap().getCell(chestLocation));
    }
}