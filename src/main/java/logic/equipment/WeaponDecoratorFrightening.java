package logic.equipment;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of frightening.
 */
public class WeaponDecoratorFrightening extends WeaponDecorator {

    public WeaponDecoratorFrightening(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String displayName() {
        return super.displayName() + " Frt";
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Frightening ";
    }
}
