package logic;

import com.google.gson.annotations.Expose;

import java.util.*;

/**
 *
 * This Class is character, which includes users and NPCs.
 *
 * @author Kai QI
 * @version 0.1
 *
 */
public class Player extends Cell{

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
     * @param name String
     * @return Integer
     */
    public Integer getAbilityScore(String name) {

        Integer score = abilityScores.get(name);
        return score != null ? score : 0;
    }

    /**
     * This method is used to get the total ability score of object after enhanced by equipments.
     * @param name String
     * @return Integer
     */
    public Integer getTotalAbilityScore(String name){
        return getAbilityScore(name) + enhancedValueOnEquipments(name);
    }

    /**
     * This method is used to calculate the modifiers for each ability score, based on the D20 formulas..
     * @param name String
     * @return Integer
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

    public void generateAbilities(String playerType) {

        List<Integer> diceResults = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            diceResults.add(Dice.rool(4, 6, 0));
        }

        diceResults.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 >= o2) {
                    return o1;
                }
                return o2;
            }
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

    public void backpackLevelRefresh(int level) {
        //甄理
    }



    /**
     * Equipments and methods.
     */

    @Expose
    private Map<String, Equipment> equipments = new HashMap<>();

    /**
     * This method is used to get the equipment worn by the character based on the given type(slot).
     * @param type also the equipment slot
     * @return logic.Equipment
     */
    public Equipment getEquipment(String type) {
        return equipments.get(type);
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
     * The method is used to refresh the equipments worn by a player when its level goes up.
     * @param level
     */
    public void equipmentsLevelRefresh(int level) {
        for (Equipment equipment : equipments.values()) {
            equipment.levelRefresh(level);
        }
    }

    /**
     * Inventory operations.
     */

    private List<Equipment> getInventories() {
        return new LinkedList<Equipment>();
    }


    /**
     * Level, name, playerType, playerParty, isDead and Getter & Setter & constructor.
     */

    @Expose
    private int level;

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
        notifyObservers(PLAYER_PARTY_CHANGE);
    }

    /**
     * getter foe isDead.
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
        notifyObservers(DEAD_CHANGE);
    }

//    /**
//     * initialization block
//     */
//    {
//    }

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
        this.hp = hp;
        setChanged();
        notifyObservers(HP_CHANGE);
    }

    public String playerImageName(String playerType, String playerParty) {

        if (isDead) {
            return "rip.png";
        }

        if (playerType == PLAYER_TYPE_BULLY) {
            if (playerParty == PLAYER_PARTY_PLAYER){
                imageName = "player_bully.png";

            } else if (playerParty == PLAYER_PARTY_FRIENDLY) {
                imageName = "friendly_bully.png";

            } else if (playerParty == PLAYER_PARTY_HOSTILE) {
                imageName = "hostile_bully.png";

            }
        } else if (playerType == PLAYER_TYPE_NIMBLE) {
            if (playerParty == PLAYER_PARTY_PLAYER){
                imageName = "player_nimble.png";

            } else if (playerParty == PLAYER_PARTY_FRIENDLY) {
                imageName = "friendly_nimble.png";

            } else if (playerParty == PLAYER_PARTY_HOSTILE) {
                imageName = "hostile_nimble.png";

            }
        } else if (playerType == PLAYER_TYPE_TANK) {
            if (playerParty == PLAYER_PARTY_PLAYER){
                imageName = "player_tank.png";

            } else if (playerParty == PLAYER_PARTY_FRIENDLY) {
                imageName = "friendly_tank.png";

            } else if (playerParty == PLAYER_PARTY_HOSTILE) {
                imageName = "hostile_tank.png";

            }
        }

        return imageName;
    }

    /**
     * This method is used to calculate the hp value based on the D20 rules.
     */
    public void generateHp() {

        hp = Dice.rool(10);

        for (int i = 0; i < level - 1; i++) {
            int hitDie = Dice.rool(10);
            int levelAdvances = hitDie + getAbilityModifier(ABILITY_CON);
            hp += levelAdvances > 1 ? levelAdvances : 1;
        }

        setChanged();
        notifyObservers(HP_CHANGE);
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
        int strModifier = getAbilityModifier(ABILITY_STR);
        return level + strModifier;
    }

    /**
     * This method is used to calculate the total attack bonus value enhanced by equipments.
     * @return Integer
     */
    public int getTotalAttackBonus() {
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
        return getDamageBonus() + enhancedValueOnEquipments(ATTRIBUTE_DAMAGE_BONUS);
    }

    /**
     * The method is to
     * @return
     */
    public void dead() {
        setDead(true);
    }


    /**
     * this method is to refresh the value of equipment accoding to the level of player
     */

    public void refreshEquipment(int level){
        if(!equipments.isEmpty()){
            for (String equipment : equipments.keySet()){
                equipments.get(equipment).levelRefresh(level);
            }
        }
        if (!backpack.isEmpty()){
            for (Equipment equipment : backpack){
                equipment.levelRefresh(level);
            }
        }
    }

    /**
     * this method is to interact with the chest
     * @param outEquipment Equipment
     * @param inEquipment Equipment
     */
    public void exchangeEquipment(Equipment outEquipment, Equipment inEquipment){
        boolean onBody = false;
        boolean onBackpack = false;
        for (String equipment : equipments.keySet()){
            if (outEquipment.getName().equals(equipments.get(equipment).getName())){
                onBody = true;
            }
        }
        if (!onBody){
            for (Equipment equipment : backpack){
                if (outEquipment.getName().equals(equipment.getName())){
                    onBackpack = true;
                }
            }
        }
        if (onBody){
            this.unequip(outEquipment);
        }else if (onBackpack){
            this.dropEquipment(outEquipment);
        }
        this.pickUpEquipment(inEquipment);
    }


}
