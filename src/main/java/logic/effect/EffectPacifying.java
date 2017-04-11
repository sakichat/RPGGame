package logic.effect;


import logic.turn.TurnStrategyFriendly;

public class EffectPacifying extends Effect {

    @Override
    protected void didAttach() {
        onPlayer.setStrategy(new TurnStrategyFriendly());
    }
}
