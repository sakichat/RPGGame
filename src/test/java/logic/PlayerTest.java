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
    private Chest chest;

    /**
     * This method is for initializing.
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
        equipment13 = new Equipment("Steel Walkers", Equipment.BOOTS, Player.ATTRIBUTE_ARMOR_CLASS, 3);
        equipment14 = new Equipment("Alythess Pyrogenics", Equipment.RING, Player.ABILITY_CON, 3);
        equipment15 = new Equipment("Ashbringer", Equipment.WEAPON, Player.ATTRIBUTE_ATTACK_BONUS, 5);

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

        chest = new Chest();
        chest.addEquipment(equipment7);
        chest.addEquipment(equipment13);
        chest.addEquipment(equipment14);
        chest.addEquipment(equipment15);
    }

    /**
     * This case tests if it is empty in the backpack after dropping all the items.
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
     * This case tests if it is already empty in the backpack, can the player still drop items.
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
     * This case tests if the wearing items can influence character's abilities.
     * @throws Exception
     */
    @Test
    public void testItemEnhancedAbilities() throws Exception {
        int pre = player.getTotalAbilityScore(Player.ABILITY_INT);
        player.equip(equipment4);
        int now = player.getTotalAbilityScore(Player.ABILITY_INT);

        Assert.assertEquals(pre, now - equipment4.getEnhancedValue());
    }

    /**
     * This case tests if player can drop unexisting items.
     * @throws Exception
     */
    @Test
    public void testNonExistingEquipmentDrop() throws Exception {
        player.dropEquipment(equipment1);
        player.dropEquipment(equipment11);

        Assert.assertEquals(9, player.equipmentsInBackpack().size());
    }

    /**
     * This case tests if player can still pick up items when backpack is full.
     * @throws Exception
     */
    @Test
    public void testFullBackPack() throws Exception {
        player.pickUpEquipment(equipment11);
        boolean nowBackpack = player.equipmentsInBackpack().contains(equipment11);

        Assert.assertEquals(false, nowBackpack);
    }

    /**
     * This case tests if player can wear more than one item of each kind, wihch means
     * if the player will drop previous item if he already wears one of the same category.
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
     * This case tests if the player will correctly loot the chest, which means the player will get
     * the item in the chest to his backpack.
     * @throws Exception
     */
    @Test
    public void testLooting() throws Exception {
        player.dropEquipment(equipment1);
        player.dropEquipment(equipment2);
        player.dropEquipment(equipment3);
        player.dropEquipment(equipment4);
        player.dropEquipment(equipment5);
        player.dropEquipment(equipment6);
        player.dropEquipment(equipment7);
        player.dropEquipment(equipment8);

        int chestSize = chest.getEquipments().size();
        int previousSize = player.equipmentsInBackpack().size();
        player.lootChest(chest);
        int nowSize = player.equipmentsInBackpack().size();
        boolean containItem = player.equipmentsInBackpack().contains(equipment13);

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
        player.dropEquipment(equipment1);
        player.dropEquipment(equipment2);
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