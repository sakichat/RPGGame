package logic.equipment;

/**
 * Created by Li Zhen on 2017-04-01.
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
