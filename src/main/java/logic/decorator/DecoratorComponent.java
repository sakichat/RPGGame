package logic.decorator;

import logic.Equipment;

/**
 * @author Kai QI
 * @version 0.3
 */
public abstract class DecoratorComponent extends Equipment{

    public abstract String getEnchantments();
    public abstract String getName();
    public abstract DecoratorComponent getOrigin();

}
