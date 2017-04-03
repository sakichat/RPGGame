package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class PacifyingDecorator extends WeaponDecorator {

    public PacifyingDecorator(DecoratorComponent decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String getName() {
        return super.getName() + "/P";
    }

    @Override
    public DecoratorComponent getOrigin() {
        return decoratedWeapon;
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + " Pacifying ";
    }
}
