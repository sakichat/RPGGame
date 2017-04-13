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

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    /**
     * this method is to get name
     * @return name String
     */

    @Override
    public String displayName() {
        return super.displayName() + " FRI";
    }

    /**
     * this method is to get enchantment which is added burning
     * @return String enchantment
     */

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Frightening ";
    }

    /**
     * The method is to generate the effect on player.
     * @return
     */

    @Override
    protected Effect generateEffect() {
        EffectFrightening effectFrightening = new EffectFrightening();
        effectFrightening.setTurns(decoratedWeapon.getEnhancedValue());
        return effectFrightening;
    }
}
