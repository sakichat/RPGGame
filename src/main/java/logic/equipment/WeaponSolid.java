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
    private String weaponType;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
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
