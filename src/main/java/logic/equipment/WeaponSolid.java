package logic.equipment;

import com.google.gson.annotations.Expose;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class WeaponSolid extends EquipmentSolid implements Weapon{

    /**
     * attributes
     */
    @Expose
    private int range;

    @Expose
    private Weapon.Type weaponType;

    /**
     * getter and setter
     */
    public int getRange() {
        return range;
    }

    /**
     * this is to set range
     * @param range int
     */

    public void setRange(int range) {
        this.range = range;
    }

    /**
     * this method is to get weaponType
     * @override method
     * @return Weapon of Type
     */
    @Override
    public Weapon.Type getWeaponType() {
        return weaponType;
    }

    /**
     * this method is to set type of Weapon
     * @param weaponType Weapon.Type
     */
    @Override
    public void setWeaponType(Weapon.Type weaponType) {
        this.weaponType = weaponType;
    }

    /**
     * this method is to get displayName
     * @return String
     */

    @Override
    public String displayName() {
        return name + " *" + getRange();
    }

    /**
     * this method is to get origin
     * @return Weapon
     */

    @Override
    public Weapon getOrigin() {
        return this;
    }

    /**
     * this method is to get enchantmentsChainText
     * @return String
     */

    @Override
    public String enchantmentsChainText(){
        return "";
    }

    /**
     * @override attach method
     * @param target
     */
    @Override
    public void attach(Player target) {
    }
}
