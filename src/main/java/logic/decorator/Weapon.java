package logic.decorator;

import logic.Equipment;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class Weapon extends Equipment {
    private int range;
    private int enchantmentBonus;

    public Weapon(String name) {
        super(name);
    }

    public Weapon(String name, String type, String enhancedAttribute, int enhancedValue) {
        super(name, type, enhancedAttribute, enhancedValue);
    }

    public Weapon() {
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getEnchantmentBonus() {
        return enchantmentBonus;
    }

    public void setEnchantmentBonus(int enchantmentBonus) {
        this.enchantmentBonus = enchantmentBonus;
    }

    public String getEnchantments(){
        return "";
    }

}
