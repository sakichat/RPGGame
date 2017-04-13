package logic.player;

import logic.equipment.Equipment;
import logic.equipment.EquipmentFactory;
import logic.equipment.Weapon;
import logic.equipment.WeaponDecoratorBurning;
import logic.map.Chest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author GU_HAN
 * @version 0.3
 *
 * This class tests wearing items correctly influence the character's abilities, character cannot wear more than
 * one item of each kind, and looting a chest.
 */
public class PlayerTest {
    /**
     * These parameters is pre-defined attributes for every method in this test class to use.
     */
    private Player player;
    private Player targetPlayer;
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
    private Equipment equipmentBootsAC3;
    private Equipment equipmentRingCon3;
    private Equipment equipmentWeaponAB5;
    private Weapon    weaponDB3Range2;
    private Chest chest;

    /**
     * This method is for initializing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        player = new Player();
        player.generateAbilities();

        targetPlayer = new Player();
        targetPlayer.generateAbilities();

        EquipmentFactory equipmentFactory = new EquipmentFactory();

        equipmentArmorAC1   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,1);
        equipmentArmorAC3   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,3);
        equipmentArmorAC5   = equipmentFactory.newEquipment("A", Equipment.ARMOR, Player.ATTRIBUTE_ARMOR_CLASS,5);
        equipmentHelmetInt3 = equipmentFactory.newEquipment("A", Equipment.HELMET,Player.ABILITY_INT,3);
        equipmentHelmetWis5 = equipmentFactory.newEquipment("A", Equipment.HELMET,Player.ABILITY_WIS,5);
        equipmentHelmetAC2  = equipmentFactory.newEquipment("A", Equipment.HELMET,Player.ATTRIBUTE_ARMOR_CLASS,2);
        equipmentShieldAC3  = equipmentFactory.newEquipment("A", Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,3);
        equipmentShieldAC4  = equipmentFactory.newEquipment("A", Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,4);
        equipmentShieldAC5  = equipmentFactory.newEquipment("A", Equipment.SHIELD,Player.ATTRIBUTE_ARMOR_CLASS,5);
        equipmentBeltCon3   = equipmentFactory.newEquipment("A", Equipment.BELT,  Player.ABILITY_CON,3);
        //Items below are pre-defined items.
        equipmentBeltStr4   = equipmentFactory.newEquipment("A", Equipment.BELT,  Player.ABILITY_STR,4);
        equipmentBootsAC3   = equipmentFactory.newEquipment("A", Equipment.BOOTS, Player.ATTRIBUTE_ARMOR_CLASS, 3);
        equipmentRingCon3   = equipmentFactory.newEquipment("A", Equipment.RING,  Player.ABILITY_CON, 3);
        equipmentWeaponAB5  = equipmentFactory.newEquipment("A", Equipment.WEAPON,Player.ATTRIBUTE_ATTACK_BONUS, 5);

        weaponDB3Range2 = equipmentFactory.newWeapon();
        weaponDB3Range2.setType(Equipment.WEAPON);
        weaponDB3Range2.setEnhancedValue(3);
        weaponDB3Range2.setEnhancedAttribute(Player.ATTRIBUTE_DAMAGE_BONUS);
        weaponDB3Range2.setRange(2);
        weaponDB3Range2.setWeaponType(Weapon.Type.RANGED);

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
    public void equip1() throws Exception {
        int preInt = player.getTotalAbilityScore(Player.ABILITY_INT);
        int preStr = player.getTotalAbilityScore(Player.ABILITY_STR);
        int preDex = player.getTotalAbilityScore(Player.ABILITY_DEX);
        int preCon = player.getTotalAbilityScore(Player.ABILITY_CON);
        int preWis = player.getTotalAbilityScore(Player.ABILITY_WIS);
        int preCha = player.getTotalAbilityScore(Player.ABILITY_CHA);
        int dexModifier1 = player.getAbilityModifier(Player.ABILITY_DEX);

        player.equip(equipmentHelmetInt3);

        int nowInt = player.getTotalAbilityScore(Player.ABILITY_INT);
        int nowStr = player.getTotalAbilityScore(Player.ABILITY_STR);
        int nowDex = player.getTotalAbilityScore(Player.ABILITY_DEX);
        int nowCon = player.getTotalAbilityScore(Player.ABILITY_CON);
        int nowWis = player.getTotalAbilityScore(Player.ABILITY_WIS);
        int nowCha = player.getTotalAbilityScore(Player.ABILITY_CHA);
        int dexModifier = player.getAbilityModifier(Player.ABILITY_DEX);

        Assert.assertTrue(preInt == nowInt - equipmentHelmetInt3.getEnhancedValue());
        Assert.assertTrue(preStr == nowStr);
        Assert.assertTrue(preDex == nowDex);
        Assert.assertTrue(preCon == nowCon);
        Assert.assertTrue(preWis == nowWis);
        Assert.assertTrue(preCha == nowCha);

    }

    /**
     * This case tests if currentPlayer can wear more than one item of each kind, wihch means
     * if the currentPlayer will drop previous item if he already wears one of the same category.
     * @throws Exception
     */
    @Test
    public void equip2() throws Exception {
        int pre   = player.getTotalArmorClass();

        player.equip(equipmentArmorAC1);
        player.equip(equipmentArmorAC3);

        int now   = player.getTotalArmorClass();

        player.equip(equipmentArmorAC5);

        int after = player.getTotalArmorClass();

        Assert.assertTrue(pre == now   - equipmentArmorAC3.getEnhancedValue());
        Assert.assertTrue(pre == after - equipmentArmorAC5.getEnhancedValue());
    }

    /**
     * This case tests if the currentPlayer will correctly loot the chest, which means the currentPlayer will get
     * the item in the chest to his backpack.
     * @throws Exception
     */
    @Test
    public void lootChest1() throws Exception {
//        currentPlayer.dropEquipment(equipmentArmorAC3);
//        currentPlayer.dropEquipment(equipmentArmorAC5);
//        currentPlayer.dropEquipment(equipmentHelmetInt3);
//        currentPlayer.dropEquipment(equipmentHelmetWis5);
//        currentPlayer.dropEquipment(equipmentHelmetAC2);
//        currentPlayer.dropEquipment(equipmentShieldAC3);
//        currentPlayer.dropEquipment(equipmentShieldAC4);
//
//        int chestSize    = chest.getEquipments().size();
//        int previousSize = currentPlayer.equipmentsInBackpack().size();
//
//        currentPlayer.lootChest(chest);
//
//        int nowSize         = currentPlayer.equipmentsInBackpack().size();
//        boolean containItem = currentPlayer.equipmentsInBackpack().contains(equipmentBootsAC3);
//
//        Assert.assertEquals(nowSize, previousSize + chestSize);
//        Assert.assertTrue(containItem);
    }

    /**
     * This case tests if the currentPlayer will correctly loot the chest, which means the currentPlayer's backpack
     * will get as much as equipments as it can. Besides, the chest will keep the left items as well.
     * @throws Exception
     */
    @Test
    public void lootChest2() throws Exception {
//        currentPlayer.dropEquipment(equipmentArmorAC1);
//        currentPlayer.dropEquipment(equipmentArmorAC3);
//        int previousChestSize = chest.getEquipments().size();
//        int previousPlayerBackpackSize = currentPlayer.equipmentsInBackpack().size();
//
//        currentPlayer.lootChest(chest);
//
//        int nowChestSize = chest.getEquipments().size();
//
//        Assert.assertTrue(currentPlayer.isBackpackFull());
//        Assert.assertEquals(nowChestSize, previousChestSize - (10 - previousPlayerBackpackSize));
    }

    /**
     * This case tests if the generateAbilities method will correctly set up currentPlayer's abilities.
     * @throws Exception
     */
    @Test
    public void generateAbilities() throws Exception {

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
     * This case tests pickUpEquipment method when the backpack is full.
     * @throws Exception
     */
    @Test
    public void pickUpEquipment1() throws Exception {
        boolean preBackpack = player.equipmentsInBackpack().contains(equipmentBeltStr4);

        player.pickUpEquipment(equipmentBeltStr4);

        boolean nowBackpack = player.equipmentsInBackpack().contains(equipmentBeltStr4);

        Assert.assertTrue(!preBackpack);
        Assert.assertTrue(!nowBackpack);
    }

    /**
     * This case tests pickUpEquipment method can operate correctly.
     * @throws Exception
     */
    @Test
    public void pickUpEquipment2() throws Exception {
        player.dropEquipment(equipmentArmorAC1);
        boolean preBackpack = player.equipmentsInBackpack().contains(equipmentArmorAC1);

        player.pickUpEquipment(equipmentArmorAC1);

        boolean nowBackpack = player.equipmentsInBackpack().contains(equipmentArmorAC1);

        Assert.assertTrue(!preBackpack);
        Assert.assertTrue( nowBackpack);
    }

    /**
     * This case tests dropEquipments will work correctly.
     * @throws Exception
     */
    @Test
    public void dropEquipments() throws Exception {
        boolean preBackpack = player.equipmentsInBackpack().contains(equipmentArmorAC1);

        player.dropEquipment(equipmentArmorAC1);

        boolean nowBackpack = player.equipmentsInBackpack().contains(equipmentArmorAC1);

        Assert.assertTrue( preBackpack);
        Assert.assertTrue(!nowBackpack);
    }

    /**
     * This method tests the weapon's special effects in combat using the Decorator pattern.
     * @throws Exception
     */
    @Test
    public void specialEffect() throws Exception {
        player.dropEquipment(equipmentArmorAC1);

        WeaponDecoratorBurning weaponDecoratorBurning = new WeaponDecoratorBurning(weaponDB3Range2);

        player.pickUpEquipment(weaponDecoratorBurning);
        player.equip(weaponDecoratorBurning);
    }

    /**
     * This case tests an attack is using all the correct attack modifiers.
     * @throws Exception
     */
    @Test
    public void attack1() throws Exception {
        int attackRoll = player.generateAttackRoll();
        int attackRoll2 = player.generateAttackRoll();
        int attackRoll3 = player.generateAttackRoll();
        int attackRoll4 = player.generateAttackRoll();
        int attackRoll5 = player.generateAttackRoll();

        Assert.assertTrue(attackRoll <= 39 && attackRoll >= -5);
        Assert.assertTrue(attackRoll2 <= 39 && attackRoll2 >= -5);
        Assert.assertTrue(attackRoll3 <= 39 && attackRoll3 >= -5);
        Assert.assertTrue(attackRoll4 <= 39 && attackRoll4 >= -5);
        Assert.assertTrue(attackRoll5 <= 39 && attackRoll5 >= -5);
    }

    /**
     * This case tests an attack hits if the attack roll is greater than the armor class of the target.
     * @throws Exception
     */
    @Test
    public void attack2() throws Exception {
        Player player1 = new Player();

        while(player1.getAbilityScore(Player.ABILITY_STR) != 24){
            player1.generateAbilities();
        }

        EquipmentFactory equipmentFactory = new EquipmentFactory();

        Weapon weapon = equipmentFactory.newWeapon();
        weapon.setType(Equipment.WEAPON);
        weapon.setEnhancedValue(5);
        weapon.setEnhancedAttribute(Player.ATTRIBUTE_ATTACK_BONUS);
        weapon.setRange(5);
        weapon.setWeaponType(Weapon.Type.RANGED);
        player1.pickUpEquipment(weapon);
        player1.equip(weapon);

        Player player2 = new Player();

        boolean canAttack = player1.shouldDealDamage(player2);

        Assert.assertTrue(canAttack);
    }

    @Test
    public void notAttack() throws Exception {
        Player player1 = new Player();
        Player player2 = new Player();

        while(player2.getAbilityScore(Player.ABILITY_DEX) != 24){
            player2.generateAbilities();
        }

        player2.pickUpEquipment(equipmentArmorAC5);
        player2.equip(equipmentArmorAC5);
        player2.pickUpEquipment(equipmentBootsAC3);
        player2.equip(equipmentBootsAC3);
        player2.pickUpEquipment(equipmentHelmetAC2);
        player2.equip(equipmentHelmetAC2);



        boolean canNotAttack = !player1.shouldDealDamage(player2);

        Assert.assertTrue(canNotAttack);

    }

    /**
     * This case tests the damage inflicted is using the right damage modifiers.
     * @throws Exception
     */
    @Test
    public void damage() throws Exception {
        int damage = player.generateDamage();
        int damage2 = player.generateDamage();
        int damage3 = player.generateDamage();
        int damage4 = player.generateDamage();
        int damage5 = player.generateDamage();

        Assert.assertTrue(damage <= 20 && damage >= 1);
        Assert.assertTrue(damage2 <= 20 && damage2 >= 1);
        Assert.assertTrue(damage3 <= 20 && damage3 >= 1);
        Assert.assertTrue(damage4 <= 20 && damage4 >= 1);
        Assert.assertTrue(damage5 <= 20 && damage5 >= 1);
    }
}