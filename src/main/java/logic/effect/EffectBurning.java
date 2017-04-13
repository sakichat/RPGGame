package logic.effect;

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
        onPlayer.damage(damage * 5);

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
