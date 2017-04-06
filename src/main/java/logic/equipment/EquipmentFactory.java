package logic.equipment;


public class EquipmentFactory {

    public Equipment newEquipment(String name){
        return new EquipmentSolid(name);
    }

    public Equipment newEquipment(String name, String type, String enhancedAttribute, int enhancedValue){
        return new EquipmentSolid(name, type, enhancedAttribute, enhancedValue);
    }

    public Weapon newWeapon(){
        return new WeaponSolid();
//        throw new RuntimeException("Code Not Finished Yet");
    }

    public Weapon equipmentToWeapon(Equipment equipment){

        WeaponSolid weapon = new WeaponSolid();
        weapon.setName(equipment.getName());
        weapon.setType(equipment.getType());
        weapon.setEnhancedAttribute(equipment.getEnhancedAttribute());
        weapon.setEnhancedValue(equipment.getEnhancedValue());
        return weapon;

    }

    public Equipment WeaponToEquipment(Weapon weapon){

        EquipmentSolid equipment = new EquipmentSolid();
        equipment.setName(weapon.getName());
        equipment.setType(weapon.getType());
        equipment.setEnhancedAttribute(weapon.getEnhancedAttribute());
        equipment.setEnhancedValue(weapon.getEnhancedValue());
        return equipment;
//        throw new RuntimeException("Code Not Finished Yet");
    }
}