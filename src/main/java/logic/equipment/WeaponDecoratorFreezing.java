package logic.equipment;

import logic.effect.Effect;
import logic.effect.EffectFreezing;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of freezing
 */
public class WeaponDecoratorFreezing extends WeaponDecorator {

    /**
     * This method is WeaponDecoratorFreezing
     * @param decoratedWeapon
     */
    public WeaponDecoratorFreezing(Weapon decoratedWeapon) {
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
    public String displayName () {
        return super.displayName() + " FRZ";
    }

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Freezing ";
    }

    @Override
    protected Effect generateEffect() {
        EffectFreezing effectFreezing = new EffectFreezing();
        effectFreezing.setTurns(decoratedWeapon.getEnhancedValue());
        return effectFreezing;
    }
}
