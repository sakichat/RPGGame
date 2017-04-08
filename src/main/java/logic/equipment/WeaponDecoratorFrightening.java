package logic.equipment;

import logic.effect.Effect;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of frightening.
 */
public class WeaponDecoratorFrightening extends WeaponDecorator {

    public WeaponDecoratorFrightening(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

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
        // TODO: 08/04/2017
        return null;
    }
}
