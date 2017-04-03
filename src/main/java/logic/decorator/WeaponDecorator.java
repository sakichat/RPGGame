package logic.decorator;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public abstract class WeaponDecorator extends DecoratorComponent {

    protected final DecoratorComponent decoratedWeapon;

    public WeaponDecorator(DecoratorComponent decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    @Override
    public String getName() {
        return decoratedWeapon.getName();
    }

    @Override
    public DecoratorComponent getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    @Override
    public String getEnchantments(){
        return decoratedWeapon.getEnchantments();
    }
}
