package logic.equipment;

import logic.effect.Effect;
import logic.effect.EffectBurning;
import logic.effect.EffectSlaying;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of slaying.
 */
public class WeaponDecoratorSlaying extends WeaponDecorator {

    /**
     * This method is used for WeaponDecoratorSlaying
     * @param decoratedWeapon
     */
    public WeaponDecoratorSlaying(Weapon decoratedWeapon) {
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
        return super.displayName() + " SLA";
    }

    /**
     * this method is to get enchantment which is added burning
     * @return String enchantment
     */

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Slaying ";
    }

    /**
     * The method is to generate the effect on player.
     * @return
     */

    @Override
    protected Effect generateEffect() {
        return new EffectSlaying();
    }
}
