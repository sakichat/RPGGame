package logic.effect;


import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyFrozen;

public class EffectFreezing extends Effect {
    private TurnStrategy turnStrategy = onPlayer.getStrategy();


    @Override
    protected void didAttach() {
        // TODO: 08/04/2017
        onPlayer.setStrategy(new TurnStrategyFrozen());
    }

    @Override
    protected void willDetach() {
        // TODO: 08/04/2017
        onPlayer.setStrategy(turnStrategy);

    }
}
