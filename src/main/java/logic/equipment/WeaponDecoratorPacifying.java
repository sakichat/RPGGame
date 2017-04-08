package logic.equipment;

import logic.effect.Effect;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 * This class is to add enchantment of pacifying.
 */
public class WeaponDecoratorPacifying extends WeaponDecorator {

    public WeaponDecoratorPacifying(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String displayName() {
        return super.displayName() + " P";
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    @Override
    public String enchantmentsChainText(){
        return super.enchantmentsChainText() + " Pacifying ";
    }

    @Override
    protected Effect generateEffect() {
        // TODO: 08/04/2017
        return null;
    }
}
