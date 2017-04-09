package logic.equipment;

import logic.effect.Effect;
import logic.effect.EffectFreezing;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of freezing
 */
public class WeaponDecoratorFreezing extends WeaponDecorator {

    public WeaponDecoratorFreezing(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String displayName () {
        return super.displayName() + " Frz";
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
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
