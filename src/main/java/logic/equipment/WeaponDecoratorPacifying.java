package logic.equipment;

import logic.effect.Effect;
import logic.effect.EffectPacifying;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of pacifying.
 */
public class WeaponDecoratorPacifying extends WeaponDecorator {

    /**
     * This method is used to WeaponDecoratorPacifying
     * @param decoratedWeapon
     */
    public WeaponDecoratorPacifying(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    /**
     * @override methods
     */
    @Override
    public String displayName() {
        return super.displayName() + " PAC";
    }

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Pacifying ";
    }

    @Override
    protected Effect generateEffect() {
        return new EffectPacifying();
    }
}
