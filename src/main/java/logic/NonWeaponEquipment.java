package logic;


public class NonWeaponEquipment extends Equipment {
    public NonWeaponEquipment(String name) {
        super(name);
    }

    public NonWeaponEquipment(String name, String type, String enhancedAttribute, int enhancedValue) {
        super(name, type, enhancedAttribute, enhancedValue);
    }

    public NonWeaponEquipment() {
    }
}
