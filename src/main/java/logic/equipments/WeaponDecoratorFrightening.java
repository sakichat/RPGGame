package logic.equipments;

/**
 * Created by Li Zhen on 2017-04-01.
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
        return decoratedWeapon;
    }

    @Override
    public String enhancementsChainText(){
        return super.enhancementsChainText() + " Frightening ";
    }
}
