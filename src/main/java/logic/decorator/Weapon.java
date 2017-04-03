package logic.decorator;

import com.google.gson.annotations.Expose;
import logic.Equipment;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class Weapon extends DecoratorComponent {

    @Expose
    private int range;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String getName() {
        return "R" + getRange() + "*" + name;
    }

    @Override
    public DecoratorComponent getOrigin() {
        return this;
    }

    @Override
    public String getEnchantments(){
        return "";
    }

}
