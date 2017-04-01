package logic.decorator;

/**
 * Created by thereaghostflash on 2017-04-01.
 */
public class frighteningDecorator extends WeaponDecorator {

    public frighteningDecorator(Weapon weapon) {
        super(weapon);
    }

    public String getEnchantments(){
        return weapon.getEnchantments() + "Frightening ";
    }
}
