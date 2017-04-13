package logic.equipment;

import logic.effect.Effect;
import logic.effect.EffectFrightening;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of frightening.
 */
public class WeaponDecoratorFrightening extends WeaponDecorator {

    /**
     * This method is used for WeaponDecoratorFrightening
     * @param decoratedWeapon
     */
    public WeaponDecoratorFrightening(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    /**
     * @override methods
     */

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

    @Override
    protected Effect generateEffect() {
        EffectFrightening effectFrightening = new EffectFrightening();
        effectFrightening.setTurns(decoratedWeapon.getEnhancedValue());
        return effectFrightening;
    }
}
