package logic.equipment;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of freezing
 */
public class WeaponDecoratorFreezing extends WeaponDecorator {

    public WeaponDecoratorFreezing(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String displayName () {
        return super.displayName() + " Frz";
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Freezing ";
    }
}
