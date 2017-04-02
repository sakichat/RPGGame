package logic.decorator;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class BurningDecorator extends WeaponDecorator {

    public BurningDecorator(Weapon weapon) {
        super(weapon);
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + "-> Burning ";
    }
}
