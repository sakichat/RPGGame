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
     * this method is to get name
     * @return name String
     */

    @Override
    public String displayName() {
        return super.displayName() + " PAC";
    }

    /**
     * this method is to get enchantment which is added burning
     * @return String enchantment
     */

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Pacifying ";
    }

    /**
     * The method is to generate the effect on player.
     * @return
     */

    @Override
    protected Effect generateEffect() {
        return new EffectPacifying();
    }
}
