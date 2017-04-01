package logic.decorator;

/**
 * @author Li ZHEN
 */
public abstract class WeaponDecorator {
    protected Weapon weapon;

    public WeaponDecorator(Weapon weapon) {
        this.weapon = weapon;
    }

    public WeaponDecorator() {
    }

    public String getEnchantments(){
        return weapon.getEnchantments();
    }
}
