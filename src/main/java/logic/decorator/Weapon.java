package logic.decorator;

import com.google.gson.annotations.Expose;
import logic.Equipment;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class Weapon extends Equipment implements DecoratorComponent {

    @Expose
    private int range;

    @Expose
    private String specialEnchantments;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getSpecialEnchantments() {
        return specialEnchantments;
    }

    public void setSpecialEnchantments(String specialEnchantments) {
        this.specialEnchantments = specialEnchantments;
    }

    @Override
    public String getEnchantments(){
        return "";
    }

}
