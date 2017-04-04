package logic.equipments;

import com.google.gson.annotations.Expose;
import logic.equipments.Weapon;

/**
 * @author Li ZHEN
 * @version 0.3
 */
public class WeaponDecorator implements Weapon {

    @Expose
    protected Weapon decoratedWeapon;

    public WeaponDecorator(Weapon decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    @Override
    public boolean validate() {
        return decoratedWeapon.validate();
    }

    @Override
    public String getName() {
        return decoratedWeapon.getName();
    }

    @Override
    public void setName(String name) {
        decoratedWeapon.setName(name);
    }

    @Override
    public String getType() {
        return decoratedWeapon.getType();
    }

    @Override
    public void setType(String type) {
        decoratedWeapon.setType(type);
    }

    @Override
    public String getEnhancedAttribute() {
        return decoratedWeapon.getEnhancedAttribute();
    }

    @Override
    public void setEnhancedAttribute(String enhancedAttribute) {
        decoratedWeapon.setEnhancedAttribute(enhancedAttribute);
    }

    @Override
    public int getEnhancedValue() {
        return decoratedWeapon.getEnhancedValue();
    }

    @Override
    public void setEnhancedValue(int enhancedValue) {
        decoratedWeapon.setEnhancedValue(enhancedValue);
    }

    @Override
    public void levelRefresh(int level) {
        decoratedWeapon.levelRefresh(level);
    }

    @Override
    public String displayName() {
        return decoratedWeapon.displayName();
    }

    @Override
    public int getRange() {
        return decoratedWeapon.getRange();
    }

    @Override
    public void setRange(int range) {
        decoratedWeapon.setRange(range);
    }

    @Override
    public Weapon getOrigin() {
        return decoratedWeapon.getOrigin();
    }

    @Override
    public String enhancementsChainText(){
        return decoratedWeapon.enhancementsChainText();
    }




}
