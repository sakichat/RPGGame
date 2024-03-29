package logic.player;

import com.google.gson.annotations.Expose;
import logic.Logger;
import logic.Play;
import logic.PlayRuntime;
import logic.animation.*;
import logic.effect.Effect;
import logic.interaction.Interaction;
import logic.interaction.InteractionFactory;
import logic.map.*;
import logic.Dice;
import logic.equipment.Weapon;
import logic.equipment.Equipment;
import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyAggressive;
import logic.turn.TurnStrategyFriendly;
import logic.turn.TurnThread;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This Class is currentPlayer, which includes users and NPCs.
 * @author Kai QI
 * @version 0.3
 */
public class Player extends Cell {

    //  =======================================================================
    //  Section - Constructor
    //  =======================================================================

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

    //  =======================================================================
    //  Section - Basic
    //  =======================================================================

    /**
     * The property of name
     */
    @Expose
    private String name;

    /**
     * The property of playerType
     */
    @Expose
    private String playerType;

    public final static String PLAYER_TYPE_BULLY        = "Bully";
    public final static String PLAYER_TYPE_NIMBLE       = "Nimble";
    public final static String PLAYER_TYPE_TANK         = "Tank";

    /**
     * The property of playerParty
     */
    @Expose
    private String playerParty = PLAYER_PARTY_NOT_DEFINED;

    public final static String PLAYER_PARTY_NOT_DEFINED = "Not Defined";
    public final static String PLAYER_PARTY_FRIENDLY    = "Friendly";
    public final static String PLAYER_PARTY_HOSTILE     = "Hostile";
    public final static String PLAYER_PARTY_MAIN        = "Main";

    /**
     * Getter for the name.
     * @return name
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
     * @return playerType
     */
    public String getPlayerType() {
        return playerType;
    }

    /**
     * Setter for the playerType.
     * @param playerType String
     */
    public void setPlayerType(String playerType) {
        this.playerType = playerType;
        setChanged();
        notifyObservers(Update.PLAYER_TYPE);
    }

    /**
     * Getter for the playerParty.
     * @return playerParty
     */
    public String getPlayerParty() {
        return playerParty;
    }

    /**
     * Setter for the playerParty.
     * @param playerParty String
     */
    public void setPlayerParty(String playerParty) {
        this.playerParty = playerParty;
        setChanged();
        notifyObservers(Update.PLAYER_PARTY);
    }

    //  =======================================================================
    //  Section - HP
    //  =======================================================================

    /**
     * The declaration of property hp
     */
    @Expose
    private int hp;

    /**
     * The declaration of property totalHp
     */
    @Expose
    private int totalHp;

    /**
     * The method is used to generate totalHp according to the D20 rule.
     * The method is called when the currentPlayer object is edited or created.
     * The method also is called when the level changes.
     * The method also is called when the CON modifier changed, aka, when the type changes.
     */
    public void generateTotalHp() {
        totalHp = Dice.roll(10);

        for (int i = 0; i < level - 1; i++) {
            int hitDie = Dice.roll(10);
            int levelAdvances = hitDie + getAbilityModifier(ABILITY_CON);
            totalHp += levelAdvances > 1 ? levelAdvances : 1;
        }

        setHp(totalHp);
    }

    /**
     * The method is used to minus damage from hp.
     * @param damage int
     */
    public void damage(int damage) {
        if (playerParty.equals(PLAYER_PARTY_FRIENDLY)){
            playerParty = PLAYER_PARTY_HOSTILE;
            this.setStrategy(new TurnStrategyAggressive());
        }
        setHp(getHp() - damage);
    }

    private void didDead(){
        effects.forEach(e -> e.setRemoveFlag(true));
        PlayRuntime playRuntime = PlayRuntime.currentRuntime();
        if (this == playRuntime.getMainPlayer()){
            playRuntime.stop();
            playRuntime.toFinish("Dead");
        }
    }

    /**
     * The method isDead
     * @return boolean
     */
    public boolean isDead() {
        return hp == 0;
    }

    /**
     * The method isAlive
     * @return boolean
     */
    public boolean isAlive(){
        return !isDead();
    }

    /**
     * Getter for hp.
     * @return int
     */
    public int getHp() {
        return hp;
    }

    /**
     * Setter for hp.
     * @param hp int
     */
    public void setHp(int hp) {

        if (hp <= 0) {
            hp = 0;
            didDead();
        }

        this.hp = hp;

        setChanged();
        notifyObservers(Update.HP);
    }


    /**
     * Getter of totalHp
     * @return int
     */
    public int getTotalHp() {
        return totalHp;
    }

    /**
     * Setter of totalHp
     * @param totalHp int
     */
    public void setTotalHp(int totalHp) {
        this.totalHp = totalHp;
    }

    //  =======================================================================
    //  Section - Level
    //  =======================================================================

    /**
     * The declaration of property level
     */
    @Expose
    private int level = 1;

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
        notifyObservers(Update.LEVEL);
    }

    //  =======================================================================
    //  Section - Abilities
    //  =======================================================================
    /**
     * The declaration of static properties
     */
    public final static String ABILITY_STR = "STR";
    public final static String ABILITY_DEX = "DEX";
    public final static String ABILITY_CON = "CON";
    public final static String ABILITY_INT = "INT";
    public final static String ABILITY_WIS = "WIS";
    public final static String ABILITY_CHA = "CHA";

    public final static String ATTRIBUTE_ARMOR_CLASS    = "AC";
    public final static String ATTRIBUTE_ATTACK_BONUS   = "AB";
    public final static String ATTRIBUTE_DAMAGE_BONUS   = "DB";

    public final static class Update {
        public final static String LEVEL        = "level change";
        public final static String PLAYER_TYPE  = "playerType change";
        public final static String PLAYER_PARTY = "playerParty change";
        public final static String ABILITY      = "ability change";
        public final static String HP           = "hp change";
        public final static String BACKPACK     = "backpack change";
        public final static String EQUIPMENT    = "equipment change";
        public final static String ALIVE        = "dead change";
    }

    /**
     * The property of abilityScores
     */
    @Expose
    private Map<String, Integer> abilityScores = new HashMap<>();

    /**
     * This method is used to calculate the ability scores based on the D20 formulas.
     */
    public void generateAbilities() {
        abilityScores.put(ABILITY_STR, Dice.roll(4, 6, 0));
        abilityScores.put(ABILITY_DEX, Dice.roll(4, 6, 0));
        abilityScores.put(ABILITY_CON, Dice.roll(4, 6, 0));
        abilityScores.put(ABILITY_INT, Dice.roll(4, 6, 0));
        abilityScores.put(ABILITY_WIS, Dice.roll(4, 6, 0));
        abilityScores.put(ABILITY_CHA, Dice.roll(4, 6, 0));
        setChanged();
        notifyObservers(Update.ABILITY);
    }

    /**
     * The method is used to calculate the ability scores based on different fighter type.
     * @param playerType String
     */
    public void generateAbilities(String playerType) {

        List<Integer> diceResults = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            diceResults.add(Dice.roll(4, 6, 0));
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
        notifyObservers(Update.ABILITY);
    }

    /**
     * This method is used to get the total armor class of object after enhanced by equipments.
     * @return Integer
     */
    public int getTotalArmorClass() {
        int dexModi = getAbilityModifier(ABILITY_DEX);
        int ac = enhancedValueOnEquipments(Player.ATTRIBUTE_ARMOR_CLASS);
        int result = 10 + dexModi + ac;
        String message = String.format("total AC : AC basic %d, AC bonus %d, DEX modi %d -> %d", 10, ac, dexModi, result);
        Logger.getInstance().log(message);
        return result;
    }


    /**
     * This method is used to calculate the total attack bonus value enhanced by equipments.
     * @return Integer
     */
    public int getTotalAttackBonus() {
        if (this.getWeapon() != null) {
            if (this.getWeapon().getWeaponType() == Weapon.Type.MELEE){
                return enhancedValueOnEquipments(ATTRIBUTE_ATTACK_BONUS) + getAbilityModifier(ABILITY_STR);
            } else {
                return enhancedValueOnEquipments(ATTRIBUTE_ATTACK_BONUS) + getAbilityModifier(ABILITY_STR)
                        + this.getWeapon().getRange();
            }
        }
        return 0;
    }


    /**
     * This method is used to calculate the total damage bonus value enhanced by equipments.
     * @return Integer
     */
    public int getTotalDamageBonus() {
        if (this.getWeapon() != null) {
            if (this.getWeapon().getWeaponType() == Weapon.Type.MELEE){
                return getAbilityModifier(ABILITY_STR);
            }
            return 0;
        }

        return 0;
    }

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

    //  =======================================================================
    //  Section - Backpack
    //  =======================================================================

    /**
     * The declaration of property backpack
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
            notifyObservers(Update.BACKPACK);
        }
    }

    /**
     * This method is used to drop an equipment when the character wants to drop, usually at the time the backpack is full.
     * @param e, the equipment the character wants to drop.
     */
    public void dropEquipment(Equipment e) {
        backpack.remove(e);
        setChanged();
        notifyObservers(Update.BACKPACK);
        tryQuit();
    }

    /**
     * The method tryQuit
     */
    private void tryQuit() {
        if (isDead() && getInventories().size() == 0) {
            PlayRuntime.currentRuntime().getMap().removeCell(getLocation());
        }
    }

    
    //  =======================================================================
    //  Section - Inventory
    //  =======================================================================

    /**
     * The method is used to get all inventories the currentPlayer owned.
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

    //  =======================================================================
    //  Section - Equipment Common
    //  =======================================================================

    /**
     * The declaration of property equipments
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
     * The method is used to return the weapon currentPlayer object is wearing.
     * @return Weapon
     */
    public Weapon getWeapon() {
        Equipment equipment = equipments.get(Equipment.WEAPON);
        if (equipment != null) {
            return (Weapon)equipment;
        }
        return null;
    }

    /**
     * This method is used to return weapon's range.
     * @return Integer
     */
    public int getRangeForAttack() {
        Weapon weapon = this.getWeapon();
        if (weapon != null) {
            return weapon.getRange();
        } else {
            return 1;
        }
    }

    /**
     * This method is used to return movement's range
     * @return Integer
     */
    public int getRangeForMove(){
        return 3;
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
        notifyObservers(Update.EQUIPMENT);

        setChanged();
        notifyObservers(Update.BACKPACK);
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
        notifyObservers(Update.EQUIPMENT);

        setChanged();
        notifyObservers(Update.BACKPACK);
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
     * This method is used by NPCs to refresh the value of inventories.
     * according to the level of currentPlayer.
     * @param level
     */
    public void adaptEquipments(int level){
        setLevel(level);
        List<Equipment> inventories = getInventories();
        for (Equipment equipment : inventories) {
            equipment.adapt(level);
        }
    }

    /**
     * The method of availableSpotsInBackpack
     * @return int
     */
    public int availableSpotsInBackpack(){
        int availableSpaceInBackpack = 10 - equipmentsInBackpack().size();
        return  availableSpaceInBackpack;
    }


    //  =======================================================================
    //  Section - Effects
    //  =======================================================================

    /**
     * The declaration of the property effects, which used to store the effects of enchantments weapon.
     */
    @Expose
    private List<Effect> effects = new LinkedList<>();

    /**
     * The method is used to add effect to the currentPlayer.
     * @param effect Effect
     */
    public void addEffect(Effect effect){
        effect.setOnPlayer(this);
        if (effect.getTurns() > 0) {
            effects.add(effect);
        }
    }

    /**
     * The method is used to remove effect to the currentPlayer.
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


    //  =======================================================================
    //  Section - Attack
    //  =======================================================================


    /**
     * This method if used for attack
     * @param player
     */
    public void attack(Player player) {

        if (shouldDealDamage(player)) {
            int damage = generateDamage();
            Logger.getInstance().log(this + " deal " + damage + " damage to " + player);
            player.damage(damage);
            Weapon weapon = this.getWeapon();
            if (weapon != null) {
                weapon.attach(player);
            }
        } else {
            Logger.getInstance().log("The attack is blocked.");
        }
    }
    /**
     * This method is used to judge whether currentPlayer do the damage
     * @param targetPlayer
     * @return Boolean
     */
    protected boolean shouldDealDamage(Player targetPlayer){
        int attackRoll = generateAttackRoll();
        int armorClass = targetPlayer.getTotalArmorClass();
        boolean result = attackRoll > armorClass;
        if (!result && this == PlayRuntime.currentRuntime().getMainPlayer()){
            Logger.getInstance().log("The main player's attack never be blocked");
            result = true;
        }
        return result;
    }

    /**
     * This method is to create attack roll.
     * @return
     */
    int generateAttackRoll(){
        int roll = Dice.roll(20);
        int attackBonus = getTotalAttackBonus();
        int result = roll + attackBonus;
        String message = String.format("attack roll : roll %d, AB %d -> %d", roll, attackBonus, result);
        Logger.getInstance().log(message);
        return result;
    }

    /**
     * This method is to create damage
     * @return
     */
    int generateDamage(){

        int roll = Dice.roll(8);
        int damageBonus = getTotalDamageBonus();
        int result = roll + damageBonus;
        if (result < 1) {
            result = 1;
        }
        String message = String.format("damage roll : roll %d, DB %d -> %d", roll, damageBonus, result);
        Logger.getInstance().log(message);
        return result;
    }


    //  =======================================================================
    //  Section - Turn Strategy
    //  =======================================================================
    
    /**
     * The declaration of property strategy.
     */

    @Expose
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
        strategy.setPlayer(this);

        PlayRuntime playRuntime = PlayRuntime.currentRuntime();
        if (strategy instanceof TurnStrategyFriendly &&
                this == playRuntime.getMainPlayer()){
            playRuntime.stop();
            playRuntime.toFinish("Mad");
        }
    }

    /**
     * The method of turn, which is the whole action in a turn.
     */
    public void turn(){

        PlayRuntime playRuntime = PlayRuntime.currentRuntime();

        turnEffect();
        if (isDead()){
            return;
        }
        if (playRuntime.isStopped()){
            return;
        }

        turnMove();
        if (playRuntime.isStopped()){
            return;
        }

        turnAttack();
        if (playRuntime.isStopped()){
            return;
        }

        turnInteract();
        if (playRuntime.isStopped()){
            return;
        }
    }


    /**
     * The method of turnEffect
     */
    private void turnEffect() {

        effects = effects.stream()
                .filter(e -> !e.isRemoveFlag())
                .collect(Collectors.toList());

        //  effects
        for (Effect effect : effects) {
            effect.turn();
            TurnThread.pause(TurnThread.PAUSE_NORMAL);
        }

        effects = effects.stream()
                .filter(e -> !e.isRemoveFlag())
                .collect(Collectors.toList());
    }

    /**
     * The method of turnMove
     */
    private void turnMove() {
        GameMap map = PlayRuntime.currentRuntime().getMap();
        GameMapGraph graph = map.getGraph();

        //  show range
        new AnimationDisplayRange()
                .setLocations(graph.pointsInRange(location, getRangeForMove()))
                .setRangeIndicationMode(Play.RangeIndicationMode.MOVE)
                .animate();

        //  select target
        Path path = strategy.preferredMovingPath();
        Logger.getInstance().log("wants to move by " + path);

        if (path.stay()) {
            new AnimationLog().setMessage("Moving Skiped").animate();
            new AnimationHideRange().animate();
            return;
        }

        Point targetLocation = path.getLastLocation();
        Logger.getInstance().log("is moving to " + targetLocation);

        //  show target
        new AnimationDisplayTarget()
                .setTarget(targetLocation)
                .animate();

        //  move animation
        Movement movement = path.getMovement(3);
        Logger.getInstance().log("got its move " + movement);
        new AnimationMove()
                .setMovement(movement)
                .animate();

        //  fade animation
        new AnimationHideRange().animate();
        new AnimationHideTarget().animate();

        PlayRuntime.currentRuntime().getPlay().updateCurrent();
    }

    /**
     * The method turnAttack
     */
    private void turnAttack() {


        GameMap map = PlayRuntime.currentRuntime().getMap();
        GameMapGraph graph = map.getGraph();
        graph.ignoreAll();

        //  show range
        List<Point> pointsInRange = graph.pointsInRange(location, getRangeForAttack());

        new AnimationDisplayRange()
                .setLocations(pointsInRange)
                .setRangeIndicationMode(Play.RangeIndicationMode.ATTACK)
                .animate();


        //  check attack
        List<Point> points = strategy.attackTargetsInNear();
        if (points.size() == 0) {
            new AnimationLog().setMessage("Attack Skiped").animate();
            new AnimationHideRange().animate();
            return;
        }


        //  select target
        Point targetLocation = strategy.preferredAttackingLocation();

        if (targetLocation == null){
            new AnimationLog().setMessage("Attack Skiped").animate();
            new AnimationHideRange().animate();
            return;
        }

        //  show target
        new AnimationDisplayTarget()
                .setTarget(targetLocation)
                .animate();

        //  attack
        Player targetPlayer = (Player) map.getCell(targetLocation);
        Logger.getInstance().log(this + " is going to attack " + targetPlayer);
        attack(targetPlayer);


        new AnimationHideRange().animate();
        new AnimationHideTarget().animate();
    }

    /**
     * The method turnInteract
     */
    private void turnInteract() {

        GameMap map = PlayRuntime.currentRuntime().getMap();
        GameMapGraph graph = map.getGraph();
        graph.ignoreAll();

        //  show range
        List<Point> pointsInRange = graph.pointsInRange(location, 1);

        new AnimationDisplayRange()
                .setLocations(pointsInRange)
                .setRangeIndicationMode(Play.RangeIndicationMode.INTERACT)
                .animate();

        //  check interact
        List<Point> points = strategy.interactTargetsInNear();

        if (points.size() == 0) {
            new AnimationLog().setMessage("Interaction Skipped").animate();
            new AnimationHideRange().animate();
            return;
        }

        //  select target
        Point targetLocation = strategy.preferredInteractionLocation();

        if (targetLocation == null){
            new AnimationLog().setMessage("Interaction Skipped").animate();
            new AnimationHideRange().animate();
            return;
        }

        //  show target
        new AnimationDisplayTarget()
                .setTarget(targetLocation)
                .animate();

        //  attack
        Cell target = map.getCell(targetLocation);
        InteractionFactory interactionFactory = new InteractionFactory();
        Interaction interaction = interactionFactory.interaction(this, target);

        if (interaction != null) {
            interaction.interact();
        }

        new AnimationHideRange().animate();
        new AnimationHideTarget().animate();
    }

    //  =======================================================================
    //  Section - Display
    //  =======================================================================

    /**
     * Override the getter for the ImageName
     * @return imageName
     */
    @Override
    public String getImageName() {
        String imageName;

        if (isDead()) {
            imageName = "rip.png";
            return imageName;
        }

        HashMap<String, String> partyNames = new HashMap<>();
        partyNames.put(Player.PLAYER_PARTY_FRIENDLY, "friendly");
        partyNames.put(Player.PLAYER_PARTY_HOSTILE, "hostile");
        partyNames.put(Player.PLAYER_PARTY_MAIN, "player");
        partyNames.put(Player.PLAYER_PARTY_NOT_DEFINED, "nd");

        HashMap<String, String> typeNames = new HashMap<>();
        typeNames.put(PLAYER_TYPE_BULLY, "bully");
        typeNames.put(PLAYER_TYPE_TANK, "tank");
        typeNames.put(PLAYER_TYPE_NIMBLE, "nimble");

        return partyNames.get(playerParty) + "_" + typeNames.get(playerType) + ".png";
    }



    //  =======================================================================
    //  Section - Event
    //  =======================================================================

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

    //  =======================================================================
    //  Section - Object
    //  =======================================================================

    /**
     * The override method of toString
     * @return
     */
    @Override
    public String toString() {
        return "Player " + name + "(" + playerParty + ")@" + location;
    }

    /**
     * The method is override for the equals method, which is used to compare currentPlayer object.
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

    //  =======================================================================
    //  Section - Other
    //  =======================================================================







}
