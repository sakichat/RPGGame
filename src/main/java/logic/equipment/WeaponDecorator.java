package logic.equipment;

import com.google.gson.annotations.Expose;
import logic.effect.Effect;
import logic.player.Player;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public abstract class WeaponDecorator implements Weapon {

    /**
     * attribute
     */
    @Expose
    protected Weapon decoratedWeapon;

    protected abstract Effect generateEffect();

    /**
     * This method is used to decoratedWeapon
     * @param decoratedWeapon
     */
    public WeaponDecorator(Weapon decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    /**
     * This method is used to validate
     * @return Boolean
     */
    @Override
    public boolean validate() {
        return decoratedWeapon.validate();
    }

    /**
     * this method is to get name
     * @override getter and setter
     * @return String  name of decoratedWeapon
     */

    @Override
    public String getName() {
        return decoratedWeapon.getName();
    }

    /**
     * this method is to set name of decoratedWeapon
     * @param name String
     */

    @Override
    public void setName(String name) {
        decoratedWeapon.setName(name);
    }

    /**
     * this method is to get type of decoratedWeapon
     * @return String type of decoratedWeapon
     */

    @Override
    public String getType() {
        return decoratedWeapon.getType();
    }

    /**
     * this method is to set type of decoratedWeapon
     * @param type String
     */

    @Override
    public void setType(String type) {
        decoratedWeapon.setType(type);
    }

    /**
     * this method is to get enhancedattribute of decoratedWeapon
     * @return String enchancedAttribute of decoratedWeapon
     */

    @Override
    public String getEnhancedAttribute() {
        return decoratedWeapon.getEnhancedAttribute();
    }

    /**
     * this method is to set enchancedAttribute of decoratedWeapon
     * @param enhancedAttribute String
     */

    @Override
    public void setEnhancedAttribute(String enhancedAttribute) {
        decoratedWeapon.setEnhancedAttribute(enhancedAttribute);
    }

    /**
     * this method is to get enhancedValue of decoratedWeapon
     * @return int enhanedValue of decoratedWeapon
     */

    @Override
    public int getEnhancedValue() {
        return decoratedWeapon.getEnhancedValue();
    }

    /**
     * this method is to set enhancedValue of decoratedWeapon
     * @param enhancedValue int
     */

    @Override
    public void setEnhancedValue(int enhancedValue) {
        decoratedWeapon.setEnhancedValue(enhancedValue);
    }

    /**
     * this method is to adapt the level o player
     * @param level int
     */

    @Override
    public void adapt(int level) {
        decoratedWeapon.adapt(level);
    }

    /**
     * this method is to get displayName of decoratedWeapon
     * @return String displayName of decoratedWeapon
     */

    @Override
    public String displayName() {
        return decoratedWeapon.displayName();
    }

    /**
     * this method is to get range of decoratedWeapon
     * @return int range of decoratedWeapon
     */

    @Override
    public int getRange() {
        return decoratedWeapon.getRange();
    }

    /**
     * this method is to set range of decoratedWeapon
     * @param range int
     */

    @Override
    public void setRange(int range) {
        decoratedWeapon.setRange(range);
    }

    /**
     * this method is to get type of weapon
     * @return type of weapon
     */

    @Override
    public Type getWeaponType() {
        return decoratedWeapon.getWeaponType();
    }

    /**
     * this method is to set type of Weapon
     * @param weaponType Type
     */

    @Override
    public void setWeaponType(Type weaponType) {
        decoratedWeapon.setWeaponType(weaponType);
    }

    /**
     * this method is to get origin
     * @return Weapon origin
     */

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    /**
     * this method is to get enchantmentsChainText of weapon
     * @return String enchantmentsChainText of weapon
     */

    @Override
    public String enchantmentsChainText(){
        return decoratedWeapon.enchantmentsChainText();
    }

    /**
     * this method is to attach the effect
     * @param target Player
     */



    @Override
    public void attach(Player target) {
        target.addEffect(generateEffect());
        decoratedWeapon.attach(target);
    }
}
