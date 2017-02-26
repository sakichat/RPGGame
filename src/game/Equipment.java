package game;

/**
 * This class is the equitment
 * @author Li Zhen
 * @version 1.0
 */

public class Equipment {

    public final static String HELMET = "Helmet";
    public final static String ARMOR = "Armor";
    public final static String SHIELD = "Shield";
    public final static String RING = "Ring";
    public final static String BELT = "Belt";
    public final static String BOOTS = "Boots";
    public final static String WEAPON = "Weapon";


    private String name;
    private String type;
    private String enhancedAttribute;
    private int enhancedValue;

    public Equipment(String name) {
        this.name = name;
    }

    /**
     * This is the construtor of game.Equipment
     * @param name String
     * @param type String
     * @param enhancedAttribute String
     * @param enhancedValue int
     */


    public Equipment(String name, String type, String enhancedAttribute, int enhancedValue) {

        this.name = name;
        this.type = type;
        this.enhancedAttribute = enhancedAttribute;
        this.enhancedValue = enhancedValue;
    }

    /**
     * This method is to validate whether the attribute can be improve according to  the game.Equipment
     * @return isValidate boolean
     */

    public boolean validate(){

        boolean isValidate = false;

        if (type.equals(HELMET)){
            if (enhancedAttribute.equals(Player.ABILITY_INT)
                    || enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)
                    || enhancedAttribute.equals(Player.ABILITY_WIS)){
                if (enhancedValue >= 1 && enhancedValue <= 5){
                    isValidate = true;
                }
            }
        }else if (type.equals(ARMOR)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)){
                if (enhancedValue >= 1 && enhancedValue <= 5){
                    isValidate = true;
                }
            }
        }else if (type.equals(SHIELD)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)){
                if (enhancedValue >= 1 && enhancedValue <= 5){
                    isValidate = true;
                }
            }
        }else if (type.equals(RING)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)
                    || enhancedAttribute.equals(Player.ABILITY_STR)
                    || enhancedAttribute.equals(Player.ABILITY_CON)
                    || enhancedAttribute.equals(Player.ABILITY_WIS)
                    || enhancedAttribute.equals(Player.ABILITY_CHA)){
                if (enhancedValue >= 1 && enhancedValue <= 5){
                    isValidate = true;
                }
            }
        }else if (type.equals(BELT)){
            if (enhancedAttribute.equals(Player.ABILITY_CON)
                    || enhancedAttribute.equals(Player.ABILITY_STR)){
                if (enhancedValue >= 1 && enhancedValue <= 5){
                    isValidate = true;
                }
            }
        }else if (type.equals(BOOTS)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)
                    || enhancedAttribute.equals(Player.ABILITY_DEX)){
                isValidate = true;
            }
        }else if (type.equals(WEAPON)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ATTACK_BONUS)
                    || enhancedAttribute.equals(Player.ATTRIBUTE_DAMAGE_BONUS)){

                if (enhancedValue >= 1 && enhancedValue <= 5){
                    isValidate = true;
                }
            }
        }


        return isValidate;
    }

    /**
     * This is the constructor
     */


    public Equipment() {

    }

    /**
     * this method is to get name of game.Equipment
     * @return name String
     */

    public String getName() {
        return name;
    }

    /**
     * this method is to set name of game.Equipment
     * @param name String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * this method is to get type of game.Equipment
     * @return type String
     */

    public String getType() {
        return type;
    }

    /**
     * this method is to set type of game.Equipment
     * @param type String
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * this method is to get enhancedAttribute
     * @return enhancedAttribute String
     */

    public String getEnhancedAttribute() {
        return enhancedAttribute;
    }

    /**
     * this method is to set getEnhancedAttribute
     * @param enhancedAttribute String
     */

    public void setEnhancedAttribute(String enhancedAttribute) {
        this.enhancedAttribute = enhancedAttribute;
    }

    /**
     * this method is to get enhancedValue
     * @return enhancedValue int
     */

    public int getEnhancedValue() {
        return enhancedValue;
    }

    /**
     * this method is to set enhancedValue
     * @param enhancedValue int
     */

    public void setEnhancedValue(int enhancedValue) {
        this.enhancedValue = enhancedValue;
    }

}
