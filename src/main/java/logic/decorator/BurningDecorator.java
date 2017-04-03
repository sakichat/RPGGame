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

    /**
     * this method is to get name
     * @return name String
     */

    @Override
    public String getName() {
        return super.getName() + "/B";
    }

    /**
     * this method is to get origin
     * @return DecoratorComponent
     */

    @Override
    public DecoratorComponent getOrigin() {
        return decoratedWeapon;
    }

    /**
     * this method is to get enchantment which is added burning
     * @return String enchantment
     */

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + " Burning ";
    }
}
