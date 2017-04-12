package logic.equipment;

import com.google.gson.annotations.Expose;
import logic.player.Player;

/**
 * @author Kai QI
 * @version 0.3
 * The class is the solid class of the Equipment, which implement the interface of Equipment.
 */

public class EquipmentSolid implements Equipment{

    /**
     * The declarations of properties of name, type, enhancedAttribute and enhancedValue.
     */
    @Expose
    protected String name;
    @Expose
    protected String type;
    @Expose
    protected String enhancedAttribute;
    @Expose
    protected int enhancedValue = 0;

    /**
     * This is the constructor without paremeter.
     */
    public EquipmentSolid() {

    }

    /**
     * this is the constructor with the parameter of name.
     * @param name String
     */

    public EquipmentSolid(String name) {
        this.name = name;
    }

    /**
     * This is the constructor with all the three parameters.
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
     * This method is to validate whether the attribute can be improve according to the requirements.
     * @return isValidate boolean
     */
    public boolean validate(){

        boolean enhancedValueValidate = false;
        if (enhancedValue >= 1 && enhancedValue <=5) {
            enhancedValueValidate = true;
        }

        boolean enhancedAttributeValidate = false;
        if (type.equals(HELMET)){
            if (enhancedAttribute.equals(Player.ABILITY_INT)
                    || enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)
                    || enhancedAttribute.equals(Player.ABILITY_WIS)){
                enhancedAttributeValidate = true;
            }
        }else if (type.equals(ARMOR)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)){
                enhancedAttributeValidate = true;
            }
        }else if (type.equals(SHIELD)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)){
                enhancedAttributeValidate = true;
            }
        }else if (type.equals(RING)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)
                    || enhancedAttribute.equals(Player.ABILITY_STR)
                    || enhancedAttribute.equals(Player.ABILITY_CON)
                    || enhancedAttribute.equals(Player.ABILITY_WIS)
                    || enhancedAttribute.equals(Player.ABILITY_CHA)){
                enhancedAttributeValidate = true;
            }
        }else if (type.equals(BELT)){
            if (enhancedAttribute.equals(Player.ABILITY_CON)
                    || enhancedAttribute.equals(Player.ABILITY_STR)){
                enhancedAttributeValidate = true;
            }
        }else if (type.equals(BOOTS)){
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ARMOR_CLASS)
                    || enhancedAttribute.equals(Player.ABILITY_DEX)){
                enhancedAttributeValidate = true;
            }
        }else if (type.equals(WEAPON)){

            boolean weaponEnhancedAttributeValid = false;
            if (enhancedAttribute.equals(Player.ATTRIBUTE_ATTACK_BONUS)
                    || enhancedAttribute.equals(Player.ATTRIBUTE_DAMAGE_BONUS)){
                weaponEnhancedAttributeValid = true;
            }

            boolean weaponTypeValid = false;
            EquipmentFactory equipmentFactory = new EquipmentFactory();
            Weapon weapon = equipmentFactory.equipmentToWeapon(this);
            Weapon.Type weaponType = weapon.getWeaponType();
            int weaponRange = weapon.getRange();
            if (weaponType.equals(Weapon.Type.MELEE)) {
                weaponTypeValid = weaponRange == 1;
            } else if (weaponType.equals(Weapon.Type.RANGED)) {
                weaponTypeValid = weaponRange > 1;
            }
            System.out.println("weaponTypeValid = " + weaponTypeValid);

            enhancedAttributeValidate = weaponEnhancedAttributeValid && weaponTypeValid;
        }

        boolean isValidate = enhancedValueValidate && enhancedAttributeValidate;

        return isValidate;
    }


    /**
     * Getter for the property name.
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the property name.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the property type.
     * @return type String
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for the property type.
     * @param type String
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for the property enhancedAttribute.
     * @return enhancedAttribute String
     */
    public String getEnhancedAttribute() {
        return enhancedAttribute;
    }

    /**
     * Setter for the property enhancedAttribute.
     * @param enhancedAttribute String
     */
    public void setEnhancedAttribute(String enhancedAttribute) {
        this.enhancedAttribute = enhancedAttribute;
    }

    /**
     * Getter for the property enhancedValue.
     * @return enhancedValue int
     */
    public int getEnhancedValue() {
        return enhancedValue;
    }

    /**
     * Setter for the property enhancedValue.
     * @param enhancedValue int
     */
    public void setEnhancedValue(int enhancedValue) {
        this.enhancedValue = enhancedValue;
    }

    /**
     * this method is to refresh the value of equipment according to the level of player
     * @param level int
     */
    public void adapt(int level) {
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

    /**
     * The method is override the abstract method in Equipment interface.
     * It is used to show the name of equipment in UI.
     * @return String, the displayName of equipment.
     */
    @Override
    public String displayName(){
        return name;
    }
}
