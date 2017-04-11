package logic.player;

import com.google.gson.annotations.Expose;
import logic.effect.Effect;
import logic.map.Cell;
import logic.map.Chest;
import logic.Dice;
import logic.equipment.Weapon;
import logic.equipment.Equipment;
import logic.turn.TurnStrategy;

import java.util.*;

/**
 *
 * This Class is player, which includes users and NPCs.
 *
 * @author Kai QI
 * @version 0.3
 *
 */
public class Player extends Cell {

    public final static String ABILITY_STR = "STR";
    public final static String ABILITY_DEX = "DEX";
    public final static String ABILITY_CON = "CON";
    public final static String ABILITY_INT = "INT";
    public final static String ABILITY_WIS = "WIS";
    public final static String ABILITY_CHA = "CHA";

    public final static String ATTRIBUTE_ARMOR_CLASS = "AC";
    public final static String ATTRIBUTE_ATTACK_BONUS = "AB";
    public final static String ATTRIBUTE_DAMAGE_BONUS = "DB";

    public final static String LEVEL_CHANGE = "level change";
    public final static String PLAYER_TYPE_CHANGE = "playerType change";
    public final static String PLAYER_PARTY_CHANGE = "playerParty change";
    public final static String ABILITY_CHANGE = "ability change";
    public final static String HP_CHANGE = "hp change";
    public final static String BACKPACK_CHANGE = "backpack change";
    public final static String EQUIPMENT_CHANGE = "equipment change";
    public final static String DEAD_CHANGE = "dead change";

    public final static String PLAYER_TYPE_BULLY = "Bully";
    public final static String PLAYER_TYPE_NIMBLE = "Nimble";
    public final static String PLAYER_TYPE_TANK = "Tank";

    public final static String PLAYER_PARTY_NOT_DEFINED = "Not Defined";
    public final static String PLAYER_PARTY_FRIENDLY = "Friendly";
    public final static String PLAYER_PARTY_HOSTILE = "Hostile";
    public final static String PLAYER_PARTY_PLAYER = "Player";

    /**
     * Abilities and methods.
     */

    @Expose
    private Map<String, Integer> abilityScores = new HashMap<>();

    /**
     * This method is used to get the ability score of object based on the given name of the ability.
     * @param abilityScoreName String
     * @return Integer
     */
    public Integer getAbilityScore(String abilityScoreName) {

        Integer score = abilityScores.get(abilityScoreName);
        return score != null ? score : 0;
    }

    /**
     * This method is used to get the total ability score of object after enhanced by equipments.
     * @param abilityScoreName String
     * @return Integer
     */
    public Integer getTotalAbilityScore(String abilityScoreName){
        return getAbilityScore(abilityScoreName) + enhancedValueOnEquipments(abilityScoreName);
    }

    /**
     * This method is used to calculate the modifiers for each ability score, based on the D20 formulas..
     * @param name String
     * @return Integer ,the value of the modifier
     */
    public Integer getAbilityModifier(String name) {
        Integer ability = getAbilityScore(name);
        if (ability != null) {
            return (int) (Math.floor(ability / 2.0 - 5));
        } else  {
            return 0;
        }
    }

    /**
     * This method is used to get the total ability modifiers of object after enhanced by equipments.
     * @param name String
     * @return Integer
     */
    public Integer getTotalAbilityModifier(String name) {
        Integer ability = getTotalAbilityScore(name);
        if (ability != null) {
            return (int) (Math.floor(ability / 2.0 - 5));
        } else  {
            return 0;
        }
    }

    /**
     * This method is used to calculate the ability scores based on the D20 formulas.
     */
    public void generateAbilities() {
        abilityScores.put(ABILITY_STR, Dice.rool(4, 6, 0));
        abilityScores.put(ABILITY_DEX, Dice.rool(4, 6, 0));
        abilityScores.put(ABILITY_CON, Dice.rool(4, 6, 0));
        abilityScores.put(ABILITY_INT, Dice.rool(4, 6, 0));
        abilityScores.put(ABILITY_WIS, Dice.rool(4, 6, 0));
        abilityScores.put(ABILITY_CHA, Dice.rool(4, 6, 0));
        setChanged();
        notifyObservers(ABILITY_CHANGE);
    }


    /**
     * The method is used to calculate the ability scores based on different fighter type.
     * @param playerType String
     */
    public void generateAbilities(String playerType) {

        List<Integer> diceResults = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            diceResults.add(Dice.rool(4, 6, 0));
        }

        diceResults.sort((o1, o2) -> {
            if (o1 > o2) {
                return -1;
            }else if(o1 == o2){
                return 0;
            }else if(o1 < o2){
                return 1;
            }
            return 0;
        });

        List<String> abilities = new LinkedList<>();
        if (playerType == PLAYER_TYPE_BULLY) {
            abilities.add(ABILITY_STR);
            abilities.add(ABILITY_CON);
            abilities.add(ABILITY_DEX);
            abilities.add(ABILITY_INT);
            abilities.add(ABILITY_CHA);
            abilities.add(ABILITY_WIS);

        } else if (playerType == PLAYER_TYPE_NIMBLE) {
            abilities.add(ABILITY_DEX);
            abilities.add(ABILITY_CON);
            abilities.add(ABILITY_STR);
            abilities.add(ABILITY_INT);
            abilities.add(ABILITY_CHA);
            abilities.add(ABILITY_WIS);

        } else if (playerType == PLAYER_TYPE_TANK) {
            abilities.add(ABILITY_CON);
            abilities.add(ABILITY_DEX);
            abilities.add(ABILITY_STR);
            abilities.add(ABILITY_INT);
            abilities.add(ABILITY_CHA);
            abilities.add(ABILITY_WIS);

        }

        for (int i = 0; i < 6; i++) {
            abilityScores.put(abilities.get(i), diceResults.get(i));
        }

        setChanged();
        notifyObservers(ABILITY_CHANGE);
    }

    /**
     * Backpack and methods.
     */

    @Expose
    private List<Equipment> backpack = new LinkedList<>();

    /**
     * This method is used to return all the equipments in the backpack.
     * @return List
     */
    public List<Equipment> equipmentsInBackpack() {
        return backpack;
    }

    /**
     * This method is used to check if the backpack is full, which means the number of the equipments is 10.
     * @return boolean
     */
    public boolean isBackpackFull() {
        if (backpack.size() >= 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to pick up an equipment when the character meet a chest.
     * @param e, the equipment the character wants to pick up.
     */
    public void pickUpEquipment(Equipment e) {
        if (! isBackpackFull()) {
            backpack.add(e);
            setChanged();
            notifyObservers(BACKPACK_CHANGE);
        }
    }

    /**
     * This method is used to drop an equipment when the character wants to drop, usually at the time the backpack is full.
     * @param e, the equipment the character wants to drop.
     */
    public void dropEquipment(Equipment e) {
        backpack.remove(e);
        setChanged();
        notifyObservers(BACKPACK_CHANGE);
    }


    /**
     * Equipments and methods.
     * The property of equipments here is means the worn equipments on the player
     */

    @Expose
    private Map<String, Equipment> equipments = new HashMap<>();

    /**
     * This method is used to get the equipment worn by the character based on the given type(slot).
     * @param type also the equipment slot
     * @return Equipment object which is in the equipment slot, aka, worn equipment.
     */
    public Equipment getEquipment(String type) {
        return equipments.get(type);
    }

    /**
     * The method is used to return the weapon player object is wearing.
     * @return
     */
    public Weapon getWeapon() {
        Equipment equipment = equipments.get(Equipment.WEAPON);
        if (equipment != null) {
            return (Weapon)equipment;
        }
        return null;
    }

    public int getRangeForAttack() {
        // TODO: 10/04/2017
        return 0;
    }
    
    /**
     * This method is used to equip the equipment on the character.
     * The equip action will replace the current one on the same slot.
     * @param e the equipment the character wants to equip, which is picked from backpack.
     */
    public void equip(Equipment e) {

        String type = e.getType();
        Equipment currentEquipment = equipments.get(type);
        if (currentEquipment != null) {
            unequip(currentEquipment);
        }
        equipments.put(type, e);
        backpack.remove(e);

        setChanged();
        notifyObservers(EQUIPMENT_CHANGE);

        setChanged();
        notifyObservers(BACKPACK_CHANGE);
    }

    /**
     * This method is used to unequip the current equipment which will be put into backpack.
     * @param e the equipment the character wants to unequip
     */
    public void unequip(Equipment e) {

        backpack.add(e);
        String type = e.getType();
        equipments.remove(type);

        setChanged();
        notifyObservers(EQUIPMENT_CHANGE);

        setChanged();
        notifyObservers(BACKPACK_CHANGE);
    }

    /**
     * This method is used to calculate the total enhanced value by all equipments based on the attribute name.
     * @param attribute the attribute which is needed.
     * @return int, the total enhanced value of the equipments.
     */
    private int enhancedValueOnEquipments(String attribute) {

        int result = 0;

        for (Equipment equipment : equipments.values()) {
            if (equipment.getEnhancedAttribute().equals(attribute)){
                result += equipment.getEnhancedValue();
            }
        }

        return result;
    }

    /**
     * The following methods are used to manage inventories.
     */

    /**
     * The method is used to get all inventories the player owned.
     * @return all the equipments in backpack or worn.
     */
    public List<Equipment> getInventories() {
        List<Equipment> inventory = new LinkedList<>();

        for (Equipment equipment : equipments.values()) {
            inventory.add(equipment);
        }

        for (Equipment equipment : backpack) {
            inventory.add(equipment);
        }

        return inventory;
    }

    /**
     * The method is used to drop an inventory.
     * @param dropEquipment the equipment which is requested to drop from inventories.
     */
    public void dropInventories(Equipment dropEquipment) {

        boolean worn = false;

        String type = dropEquipment.getType();
        if (equipments.get(type) != null) {
            worn = equipments.get(type).getName().equals(dropEquipment.getName());
        }

        if (worn) {
            unequip(dropEquipment);
        }

        dropEquipment(dropEquipment);
    }

    /**
     * Interaction methods.
     * NPCs refresh their inventories according to the player level;
     * Friendly players hand out random equipments to complete exchange;
     * Loot the chest;
     * Loot the dead NPCs.
     */

    /**
     * This method is used by NPCs to refresh the value of inventories.
     * according to the level of player.
     */
    public void inventoryLevelRefresh(){

        List<Equipment> inventories = getInventories();
        if (!inventories.isEmpty()) {
            for (Equipment equipment : inventories) {
                equipment.levelRefresh(level);
            }
        }
    }


    /**
     * The method will be called by a NPC.
     * The NPC will random pick an equipment from their inventory to hand out.
     * @param gotEquipment
     * @return The return value will be the equipment random picked up.
     */
    public Equipment randomExchange(Equipment gotEquipment) {

        List<Equipment> inventories = getInventories();
        int randomIndex = (int)(Math.random() * inventories.size());
        Equipment handOutEquipment = inventories.get(randomIndex);

        dropInventories(handOutEquipment);
        pickUpEquipment(gotEquipment);
        return handOutEquipment;
    }

    /**
     * The method is used by a player to loot a chest.
     * @param chest
     */
    public void lootChest(Chest chest) {

        int backpackEmptySize = 10 - backpack.size();
        int chestSize = chest.getEquipments().size();
        int lootSize = Math.min(backpackEmptySize, chestSize);

        for (int i = 0; i < lootSize; i++) {
            Equipment lootEquipment = chest.getEquipments().get(0);
            pickUpEquipment(lootEquipment);
            chest.dropEquipment(lootEquipment);
        }
    }

    /**
     * The method is used by a player to loot a deadNPC.
     * @param deadNPC
     */
    public void lootDeadNPC(Player deadNPC) {

        List<Equipment> inventories = deadNPC.getInventories();

        int backpackEmptySize = 10 - backpack.size();
        int inventoriesSize = inventories.size();
        int lootSize = Math.min(backpackEmptySize, inventoriesSize);

        for (int i = 0; i < lootSize; i++) {
            Equipment lootEquipment = inventories.get(0);
            pickUpEquipment(lootEquipment);
            deadNPC.dropInventories(lootEquipment);
            inventories.remove(0);
        }
    }


    /**
     * Level, name, playerType, playerParty, isDead and Getter & Setter & constructor.
     */

    @Expose
    private int level = 1;

    @Expose
    private String name;

    @Expose
    private String playerType;

    @Expose
    private String playerParty = PLAYER_PARTY_NOT_DEFINED;

    @Expose
    private boolean isDead;

    /**
     * Getter for the level.
     * @return int
     */
    public int getLevel() {
        return level;
    }

    /**
     * Setter for the level.
     */
    public void setLevel(int level) {
        this.level = level;
        generateTotalHp();
        setChanged();
        notifyObservers(LEVEL_CHANGE);
    }

    /**
     * Getter for the name.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the playerType.
     * @return
     */
    public String getPlayerType() {
        return playerType;
    }

    /**
     * Setter for the playerType.
     * @param playerType
     */
    public void setPlayerType(String playerType) {
        this.playerType = playerType;
        setChanged();
        notifyObservers(PLAYER_TYPE_CHANGE);
    }

    /**
     * Getter for the playerParty.
     * @return
     */
    public String getPlayerParty() {
        return playerParty;
    }

    /**
     * Setter for the playerParty.
     * @param playerParty
     */
    public void setPlayerParty(String playerParty) {
        this.playerParty = playerParty;
        setChanged();
        notifyObservers(PLAYER_PARTY_CHANGE);
    }

    /**
     * getter for isDead.
     */
    public boolean isDead() {
        return isDead;
    }

    /**
     * Setter for isDead
     * @param dead
     */
    public void setDead(boolean dead) {
        isDead = dead;
        setChanged();
        notifyObservers(DEAD_CHANGE);
    }

    /**
     * Constructor without parameters.
     */
    public Player() {
    }

    /**
     * Constructor with parameters, level and name.
     * @param name String
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Override the getter for the ImageName
     * @return
     */
    @Override
    public String getImageName() {
        String imageName;

        if (isDead) {
            imageName = "rip.png";
            return imageName;
        }

        HashMap<String, String> partyNames = new HashMap<>();
        partyNames.put(Player.PLAYER_PARTY_FRIENDLY, "friendly");
        partyNames.put(Player.PLAYER_PARTY_HOSTILE, "hostile");
        partyNames.put(Player.PLAYER_PARTY_PLAYER, "player");
        partyNames.put(Player.PLAYER_PARTY_NOT_DEFINED, "nd");

        HashMap<String, String> typeNames = new HashMap<>();
        typeNames.put(PLAYER_TYPE_BULLY, "bully");
        typeNames.put(PLAYER_TYPE_TANK, "tank");
        typeNames.put(PLAYER_TYPE_NIMBLE, "nimble");

        return partyNames.get(playerParty) + "_" + typeNames.get(playerType) + ".png";
    }


    /**
     * Hp and methods.
     */

    @Expose
    private int hp;

    /**
     * Getter for hp.
     * @return Integer
     */
    public int getHp() {
        return hp;
    }

    /**
     * Setter for hp.
     * @param hp int
     */
    public void setHp(int hp) {
        if (hp < 0) {
            hp = 0;
        }

        if (hp == 0) {
            dead();
        }

        this.hp = hp;

        setChanged();
        notifyObservers(HP_CHANGE);
    }

    /**
     * The method is used to minus damage from hp.
     * @param damage
     */
    public void damage(int damage) {
        setHp(getHp() - damage);
    }

    /**
     * The method is to describe the dead status;
     * @return
     */
    private void dead() {
        setDead(true);
        setImageName(getImageName());
    }

    /**
     * The declaration of property totalHp
     */
    @Expose
    private int totalHp;

    /**
     * Getter of totalHp
     * @return
     */
    public int getTotalHp() {
        return totalHp;
    }

    /**
     * Setter of totalHp
     * @param totalHp
     */
    public void setTotalHp(int totalHp) {
        this.totalHp = totalHp;
    }

    /**
     * The method is used to generate totalHp according to the D20 rule.
     * The method is called when the player object is edited or created.
     * The method also is called when the level changes.
     * The method also is called when the CON modifier changed, aka, when the type changes.
     */
    public void generateTotalHp() {
        totalHp = Dice.rool(10);

        for (int i = 0; i < level - 1; i++) {
            int hitDie = Dice.rool(10);
            int levelAdvances = hitDie + getAbilityModifier(ABILITY_CON);
            totalHp += levelAdvances > 1 ? levelAdvances : 1;
        }

        setHp(totalHp);

    }

    /**
     * Attributes calculate methods.
     */

    /**
     * This method is used to calculate the armor class value based on the D20 rules.
     * @return Integer
     */
    public int getArmorClass() {
        int dexModifier = getAbilityModifier(ABILITY_DEX);
        return 10 + dexModifier;
    }

    /**
     * This method is used to get the total armor class of object after enhanced by equipments.
     * @return Integer
     */
    public int getTotalArmorClass() {
        return getArmorClass() + enhancedValueOnEquipments(Player.ATTRIBUTE_ARMOR_CLASS);
    }


    /**
     * This method is used to calculate the attack bonus value based on the D20 rules.
     * @return Integer
     */
    public int getAttackBonus() {
        return level;
    }

    /**
     * This method is used to calculate the total attack bonus value enhanced by equipments.
     * @return Integer
     */
    public int getTotalAttackBonus() {
        // TODO: 10/04/2017
        return getAttackBonus() + enhancedValueOnEquipments(ATTRIBUTE_ATTACK_BONUS);
    }

    /**
     * This method is used to calculate the damage bonus value based on the D20 rules.
     * @return Integer
     */
    public int getDamageBonus() {
        return getAbilityModifier(ABILITY_STR);
    }

    /**
     * This method is used to calculate the total damage bonus value enhanced by equipments.
     * @return Integer
     */
    public int getTotalDamageBonus() {
        // TODO: 10/04/2017
        return getDamageBonus() + enhancedValueOnEquipments(ATTRIBUTE_DAMAGE_BONUS);
    }

    /**
     * The declaration of property strategy.
     */
    private TurnStrategy strategy;

    /**
     * Getter for strategy.
     * @return
     */
    public TurnStrategy getStrategy() {
        return strategy;
    }

    /**
     * Setter for strategy.
     * @param strategy Strategy
     */
    public void setStrategy(TurnStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * The declaration of the property effects, which used to store the effects of enchantments weapon.
     */
    private List<Effect> effects = new LinkedList<>();

    /**
     * The method is used to add effect to the player.
     * @param effect Effect
     */
    public void addEffect(Effect effect){
        effect.setOnPlayer(this);
        effects.add(effect);

    }

    /**
     * The method is used to remove effect to the player.
     * @param effect Effect
     */
    public void removeEffect(Effect effect){
        effects.remove(effect);
    }

    /**
     * Getter for the effects.
     * @return List
     */
    public List<Effect> getEffects() {
        return effects;
    }



    public void attack(Player player) {
        // TODO: 10/04/2017
    }

    // attack
    private boolean shouldDealDamage(Player player){
        // TODO: 10/04/2017
        return false;
    }

    private int rollDamage(){
        // TODO: 10/04/2017
        return 0;
    }


    /**
     * The method is override for the equals method, which is used to compare player object.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) return false;
        return this.getName().equals(((Player) obj).getName());
    }

    /**
     * The mothod is override method of hashcode calculator.
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
