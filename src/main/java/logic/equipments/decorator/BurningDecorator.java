package logic.equipments.decorator;

import logic.equipments.Weapon;

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

    public BurningDecorator(Weapon decoratedWeapon) {
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
        return decoratedWeapon;
    }

    /**
     * this method is to get enchantment which is added burning
     * @return String enchantment
     */

    @Override
    public String enhancementsChainText(){
        return super.enhancementsChainText() + " Burning ";
    }
}
