package logic.decorator;

import logic.Equipment;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class Weapon extends Equipment implements Component{

    private int range;

//    public Weapon(String name) {
//        super(name);
//    }
//
//    public Weapon(String name, String type, String enhancedAttribute, int enhancedValue) {
//        super(name, type, enhancedAttribute, enhancedValue);
//    }
//
//    public Weapon() {
//    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String getEnchantments(){
        return "";
    }

}
