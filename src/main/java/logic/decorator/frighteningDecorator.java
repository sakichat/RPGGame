package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class FrighteningDecorator extends WeaponDecorator {

    public FrighteningDecorator(Weapon weapon) {
        super(weapon);
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + "-> Frightening ";
    }
}
