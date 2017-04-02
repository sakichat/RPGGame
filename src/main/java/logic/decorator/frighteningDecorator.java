package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class frighteningDecorator extends WeaponDecorator {

    public frighteningDecorator(Weapon weapon) {
        super(weapon);
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + "Frightening ";
    }
}
