package logic.equipment;

/**
 * @author Kai QI
 * @version 0.3
 * The class is an interface of Weapon, which extends Equipment.
 * This class equals to the Component Class in the Decorators model.
 */
public interface Weapon extends Equipment{

    /**
     * Some abstract methods which are implemented by the implement classes.
     */

    /**
     * Getter & Setter for the properties range and weaponType.
     */
    int getRange();
    void setRange(int range);
    String getWeaponType();
    void setWeaponType(String weaponType);

    /**
     * The two methods below are main methods in decorator pattern.
     */

    /**
     * The method is used to get the original object which is decorated.
     * @return Weapon, the original object
     */
    Weapon getOrigin();

    /**
     * The method is used to complete the decorator function, enchantment addition.
     * @return String, the decorator information is stored in the String.
     */
    String enchantmentsChainText();
}
