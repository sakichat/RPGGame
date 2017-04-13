package logic.effect;


import logic.turn.TurnStrategyFriendly;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class EffectPacifying extends Effect {

    /**
     * This method is used to attach effect on player
     */
    @Override
    protected void didAttach() {
        onPlayer.setStrategy(new TurnStrategyFriendly());
    }
}
