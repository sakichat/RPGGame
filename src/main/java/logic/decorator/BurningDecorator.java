package logic.decorator;

/**
 * @author Li ZHEN
 * @version 0.3
 * this class is to add enchantment of burning
 */
public class BurningDecorator extends WeaponDecorator {
    /**
     * this method  is the constructor
     * @param decoratedWeapon DecoratorComponent
     */

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
