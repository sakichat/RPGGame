package logic.effect;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class EffectSlaying extends Effect {

    /**
     * This method is used to attach effect on player
     */
    @Override
    protected void didAttach() {
        onPlayer.damage(onPlayer.getHp());
    }
}
