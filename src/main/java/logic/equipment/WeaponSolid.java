package logic.equipment;

import com.google.gson.annotations.Expose;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class WeaponSolid extends EquipmentSolid implements Weapon{

    @Expose
    private int range;
    @Expose
    private Weapon.Type weaponType;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

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
        return "R" + getRange() + "*" + name;
    }

    @Override
    public Weapon getOrigin() {
        return this;
    }

    @Override
    public String enchantmentsChainText(){
        return "";
    }

    @Override
    public void attach(Player target) {
        // do nothing
    }
}
