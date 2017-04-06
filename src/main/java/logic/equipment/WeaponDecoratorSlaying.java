package logic.equipment;

/**
 * Created by thereaghostflash on 2017-04-01.
 */
public class WeaponDecoratorSlaying extends WeaponDecorator {

    public WeaponDecoratorSlaying(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String displayName() {
        return super.displayName() + " S";
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Slaying ";
    }
}