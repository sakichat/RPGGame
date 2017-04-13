package logic.equipment;


import org.apache.commons.lang3.text.WordUtils;
import logic.player.Player;

/**
 * @author Kai QI
 * @version 0.3
 * The class is an interface of Weapon, which extends Equipment.
 * This class equals to the Component Class in the Decorators model.
 */
public interface Weapon extends Equipment{

    enum Type{
        MELEE, RANGED;
        public String display() {
            return WordUtils.capitalizeFully(name());
        }
    }

    /**
     * Some abstract methods which are implemented by the implement classes.
     */

    /**
     * Getter & Setter for the properties range and weaponType.
     */
    int getRange();
    void setRange(int range);
    Type getWeaponType();
    void setWeaponType(Type weaponType);

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

    /**
     * abstract method, which is used to show the affection on player who wear it.
     * @param target
     */
    void attach(Player target);
}
