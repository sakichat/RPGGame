package logic.equipment;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of pacifying.
 */
public class WeaponDecoratorPacifying extends WeaponDecorator {

    public WeaponDecoratorPacifying(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String displayName() {
        return super.displayName() + " P";
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Pacifying ";
    }
}
