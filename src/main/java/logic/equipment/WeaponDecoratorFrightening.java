package logic.equipment;

/**
 * Created by Li Zhen on 2017-04-01.
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
