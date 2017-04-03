package logic.equipments.decorator;

import logic.equipments.Weapon;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class FrighteningDecorator extends WeaponDecorator {

    public FrighteningDecorator(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String displayName() {
        return super.displayName() + " Frt";
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon;
    }

    @Override
    public String enhancementsChainText(){
        return super.enhancementsChainText() + " Frightening ";
    }
}
