package logic.effect;


import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyFrozen;

public class EffectFreezing extends Effect {
    private TurnStrategy turnStrategy = onPlayer.getStrategy();


    @Override
    protected void didAttach() {
        turnStrategy = onPlayer.getStrategy();
        onPlayer.setStrategy(new TurnStrategyFrozen());
    }

    @Override
    protected void willDetach() {
        onPlayer.setStrategy(turnStrategy);

    }
}
