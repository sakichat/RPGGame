package logic.decorator;

/**
 * Created by thereaghostflash on 2017-04-01.
 */
public class SlayingDecorator extends WeaponDecorator {

    public SlayingDecorator(Weapon weapon) {
        super(weapon);
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + "Slaying ";
    }
}
