package logic.decorator;

/**
 * Created by thereaghostflash on 2017-04-01.
 */
public class pacifyingDecorator extends WeaponDecorator {
    public pacifyingDecorator(Weapon weapon) {
        super(weapon);
    }

    public String getEnchantments(){
        return weapon.getEnchantments() + "Pacifying ";
    }
}
