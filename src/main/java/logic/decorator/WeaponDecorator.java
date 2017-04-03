package logic.decorator;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public abstract class WeaponDecorator implements DecoratorComponent {

    protected final DecoratorComponent decoratedWeapon;

    public WeaponDecorator(DecoratorComponent decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    @Override
    public String getEnchantments(){
        return decoratedWeapon.getEnchantments();
    }
}
