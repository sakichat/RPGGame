package logic.equipments;

import com.google.gson.annotations.Expose;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class WeaponSolid extends EquipmentSolid implements Weapon{

    @Expose
    private int range;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
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
    public String enhancementsChainText(){
        return "";
    }

}
