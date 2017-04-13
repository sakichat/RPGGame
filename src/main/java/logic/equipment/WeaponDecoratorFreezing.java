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

    /**
     * this method is to get origin
     * @return DecoratorComponent
     */
    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    /**
     * this method is to get name
     * @return name String
     */
    @Override
    public String displayName () {
        return super.displayName() + " FRZ";
    }

    /**
     * this method is to get enchantment which is added burning
     * @return String enchantment
     */

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Freezing ";
    }

    /**
     * The method is to generate the effect on player.
     * @return
     */

    @Override
    protected Effect generateEffect() {
        EffectFreezing effectFreezing = new EffectFreezing();
        effectFreezing.setTurns(decoratedWeapon.getEnhancedValue());
        return effectFreezing;
    }
}
