package logic.effect;

import logic.Logger;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class EffectBurning extends Effect {

    /**
     * attribute
     */
    private int damage;

    /**
     * setter
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * This method is used to set damage
     */
    @Override
    protected void affect() {
        int damage = this.damage * 5;
        Logger.getInstance().log(this + " deal " + damage + " damage");
        onPlayer.damage(damage);

    }

    /**
     * This method is used to get imageName
     * @return
     */
    @Override
    public String getImageName() {
        String imageName = "burning.png";
        return imageName;
    }
}
