package logic.equipments;

import com.google.gson.annotations.Expose;
import logic.Player;

public class EquipmentSolid implements Equipment{

    @Expose
    protected String name;
    @Expose
    protected String type;
    @Expose
    protected String enhancedAttribute;
    @Expose
    protected int enhancedValue = 0;

    /**
     * This is the constructor
     */

    public EquipmentSolid() {

    }

    /**
     * this is the constructor to send the name
     * @param name String
     */

    public EquipmentSolid(String name) {
        this.name = name;
    }

    /**
     * This is the construtor of logic.Equipment
     * @param name String
     * @param type String
     * @param enhancedAttribute String
     * @param enhancedValue int
     */


    public EquipmentSolid(String name, String type, String enhancedAttribute, int enhancedValue) {

        this.name = name;
        this.type = type;
        this.enhancedAttribute = enhancedAttribute;
        this.enhancedValue = enhancedValue;
    }



    /**
     * This method is to validate whether the attribute can be improve according to  the logic.Equipment
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

            boolean enhancementValid = false;
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ATTACK_BONUS)
                    || enhancedAttribute.equals(Player.ATTRIBUTE_DAMAGE_BONUS)){

                if (enhancedValue >= 1 && enhancedValue <= 5){
                    isValidate = true;
                }
            }

            boolean weaponTypeValid = false;
            Weapon weapon = (Weapon) this;
            String weaponType = weapon.getWeaponType();
            int weaponRange = weapon.getRange();
            if (weaponType.equals(WEAPON_TYPE_MELEE)) {
                weaponTypeValid = weaponRange == 1;
            } else if (weaponType.equals(WEAPON_TYPE_RANGED)) {
                weaponTypeValid = weaponRange > 1;
            }

            isValidate = enhancementValid && weaponTypeValid;
        }


        return isValidate;
    }


    /**
     * this method is to get name of logic.Equipment
     * @return name String
     */

    public String getName() {
        return name;
    }

    /**
     * this method is to set name of logic.Equipment
     * @param name String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * this method is to get type of logic.Equipment
     * @return type String
     */

    public String getType() {
        return type;
    }

    /**
     * this method is to set type of logic.Equipment
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

    /**
     * this method is to refresh the value of equipment accoding to the level of player
     * @param level int
     */

    public void levelRefresh(int level) {
        if (level >= 1 && level <= 4){
            this.setEnhancedValue(1);
        }else if (level >= 5 && level <= 8){
            this.setEnhancedValue(2);
        }else if (level >= 9 && level <= 12){
            this.setEnhancedValue(3);
        }else if (level >= 13 && level <= 16){
            this.setEnhancedValue(4);
        }else if (level >= 17){
            this.setEnhancedValue(5);
        }
    }

    /**
     * this method is to show the Equipment
     * @return String
     */

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", enhancedAttribute='" + enhancedAttribute + '\'' +
                ", enhancedValue=" + enhancedValue +
                '}';
    }

    public String displayName(){
        return name;
    }

}
