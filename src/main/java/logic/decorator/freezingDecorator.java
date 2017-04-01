package logic.decorator;

/**
 * Created by thereaghostflash on 2017-04-01.
 */
public class freezingDecorator extends WeaponDecorator {
    public freezingDecorator(Weapon weapon) {
        super(weapon);
    }

    public String getEnchantments(){
        return weapon.getEnchantments() + "Freezing ";
    }
}
