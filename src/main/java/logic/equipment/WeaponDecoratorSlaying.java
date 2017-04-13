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
     * @override methods
     */
    @Override
    public String displayName() {
        return super.displayName() + " SLA";
    }

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Slaying ";
    }

    @Override
    protected Effect generateEffect() {
        return new EffectSlaying();
    }
}
