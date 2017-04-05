package logic.equipments;

/**
 * @author Kai QI
 * @version 0.3
 */
public interface Weapon extends Equipment{

    int getRange();
    void setRange(int range);
    String getWeaponType();
    void setWeaponType(String weaponType);

    Weapon getOrigin();
    String enchantmentsChainText();
}
