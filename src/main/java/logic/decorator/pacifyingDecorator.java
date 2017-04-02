package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class pacifyingDecorator extends WeaponDecorator {

    public pacifyingDecorator(Weapon weapon) {
        super(weapon);
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + "Pacifying ";
    }
}
