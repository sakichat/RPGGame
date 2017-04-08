package logic.equipment;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of burning
 */
public class WeaponDecoratorBurning extends WeaponDecorator {
    /**
     * this method  is the constructor
     * @param decoratedWeapon DecoratorComponent
     */

    public WeaponDecoratorBurning(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    /**
     * this method is to get name
     * @return name String
     */

    @Override
    public String displayName() {
        return super.displayName() + " B";
    }

    /**
     * this method is to get origin
     * @return DecoratorComponent
     */

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    /**
     * this method is to get enchantment which is added burning
     * @return String enchantment
     */

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Burning ";
    }
}
