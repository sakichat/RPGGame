package logic.equipment;


/**
 * @author Kai QI
 * @version 0.3
 *
 * This class is a factory of Equipment and Weapon class,
 * also includes the methods used to convert objects.
 */
public class EquipmentFactory {

    /**
     * This method is to build a new equipment object.
     * @param name String
     * @return a new Equipment
     */
    public Equipment newEquipment(String name){
        return new EquipmentSolid(name);
    }

    /**
     * The method is to build a new equipment object with more parameters.
     * @param name String
     * @param type String
     * @param enhancedAttribute String
     * @param enhancedValue int
     * @return a new equipment
     */
    public Equipment newEquipment(String name, String type, String enhancedAttribute, int enhancedValue){
        return new EquipmentSolid(name, type, enhancedAttribute, enhancedValue);
    }

    /**
     * The method is used to build a new weapon object
     * @return a new weapon
     */
    public Weapon newWeapon(){
        return new WeaponSolid();
    }

    /**
     * The method is used to convert an equipment object to a weapon object, if the type is Weapon.
     * @param equipment Equipment
     * @return a weapon object
     */
    public Weapon equipmentToWeapon(Equipment equipment){

        WeaponSolid weapon = new WeaponSolid();
        weapon.setName(equipment.getName());
        weapon.setType(equipment.getType());
        weapon.setEnhancedAttribute(equipment.getEnhancedAttribute());
        weapon.setEnhancedValue(equipment.getEnhancedValue());
        if (equipment instanceof Weapon) {
            weapon.setWeaponType(((Weapon) equipment).getWeaponType());
            weapon.setRange(((Weapon)equipment).getRange());
        }
        return weapon;

    }

    /**
     * The method is used to convert a weapon object to an equipment object, if the type is Weapon.
     * @param weapon Weapon
     * @return an equipment object
     */
    public Equipment WeaponToEquipment(Weapon weapon){

        EquipmentSolid equipment = new EquipmentSolid();
        equipment.setName(weapon.getName());
        equipment.setType(weapon.getType());
        equipment.setEnhancedAttribute(weapon.getEnhancedAttribute());
        equipment.setEnhancedValue(weapon.getEnhancedValue());
        return equipment;
    }
}