package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class FreezingDecorator extends WeaponDecorator {

    public FreezingDecorator(DecoratorComponent decoratedWeapon) {
        super(decoratedWeapon);
    }

    public String getEnchantments(){
        return super.getEnchantments() + "-> Freezing ";
    }
}
