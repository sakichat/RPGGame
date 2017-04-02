package logic.decorator;

/**
 * Created by Li Zhen on 2017-04-01.
 */
public class PacifyingDecorator extends WeaponDecorator {

    public PacifyingDecorator(Weapon weapon) {
        super(weapon);
    }

    @Override
    public String getEnchantments(){
        return super.getEnchantments() + "-> Pacifying ";
    }
}
