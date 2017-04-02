package logic.decorator;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public abstract class WeaponDecorator implements Component{

    protected Weapon weapon;

    public WeaponDecorator(Weapon weapon) {
        this.weapon = weapon;
    }
//
//    public WeaponDecorator() {
//    }

    @Override
    public String getEnchantments(){
        return weapon.getEnchantments();
    }
}
