package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class FreezingDecorator extends WeaponDecorator {

    public FreezingDecorator(DecoratorComponent decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String getName() {
        return super.getName() + "/Frz";
    }

    @Override
    public DecoratorComponent getOrigin() {
        return decoratedWeapon;
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + " Freezing ";
    }
}
