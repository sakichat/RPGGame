package logic.effect;


public class EffectSlaying extends Effect {

    @Override
    protected void didAttach() {
        onPlayer.damage(onPlayer.getHp());
    }
}
