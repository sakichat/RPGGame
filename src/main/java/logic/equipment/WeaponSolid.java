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

    public void setRange(int range) {
        this.range = range;
    }

    /**
     * @override method
     */
    @Override
    public Weapon.Type getWeaponType() {
        return weaponType;
    }

    @Override
    public void setWeaponType(Weapon.Type weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String displayName() {
        return name + " *" + getRange();
    }

    @Override
    public Weapon getOrigin() {
        return this;
    }

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
