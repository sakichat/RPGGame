package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class FrighteningDecorator extends WeaponDecorator {

    public FrighteningDecorator(DecoratorComponent decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String getName() {
        return super.getName() + "/Frt";
    }

    @Override
    public DecoratorComponent getOrigin() {
        return decoratedWeapon;
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + " Frightening ";
    }
}
