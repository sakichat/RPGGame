package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class freezingDecorator extends WeaponDecorator {

    public freezingDecorator(Weapon weapon) {
        super(weapon);
    }

    public String getEnchantments(){
        return super.getEnchantments() + "Freezing ";
    }
}
