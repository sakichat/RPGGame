package logic.effect;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class EffectSlaying extends Effect {

    @Override
    protected void didAttach() {
        onPlayer.damage(onPlayer.getHp());
    }
}
