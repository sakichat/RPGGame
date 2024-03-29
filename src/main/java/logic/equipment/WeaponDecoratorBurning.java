package logic.equipment;

import logic.effect.Effect;
import logic.effect.EffectBurning;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of burning
 */
public class WeaponDecoratorBurning extends WeaponDecorator {
    /**
     * this method  is the constructor
     * @param decoratedWeapon DecoratorComponent
     */

    public WeaponDecoratorBurning(Weapon decoratedWeapon) {
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
    public String displayName() {
        return super.displayName() + " BUR";
    }

    /**
     * this method is to get enchantment which is added burning
     * @return String enchantment
     */

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Burning ";
    }

    /**
     * The method is to generate the effect on player.
     * @return
     */
    @Override
    protected Effect generateEffect() {
        EffectBurning effectBurning = new EffectBurning();
        effectBurning.setDamage(decoratedWeapon.getEnhancedValue());
        effectBurning.setTurns(3);
        return effectBurning;
    }
}
