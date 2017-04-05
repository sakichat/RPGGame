package logic.equipments;

/**
 * Created by Li Zhen on 2017-04-01.
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
}
