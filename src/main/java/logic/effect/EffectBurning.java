package logic.effect;


public class EffectBurning extends Effect {

    private int damage;

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    protected void affect() {
        onPlayer.damage(damage * 5);

    }

    @Override
    public String getImageName() {
        String imageName = "burning.png";
        return imageName;
    }
}
