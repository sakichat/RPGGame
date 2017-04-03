package logic.decorator;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class BurningDecorator extends WeaponDecorator {

    public BurningDecorator(DecoratorComponent decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String getName() {
        return super.getName() + "/B";
    }

    @Override
    public DecoratorComponent getOrigin() {
        return decoratedWeapon;
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + " Burning ";
    }
}
