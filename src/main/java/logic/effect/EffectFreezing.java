package logic.effect;


import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyFrozen;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class EffectFreezing extends Effect {
    private TurnStrategy turnStrategy;

    @Override
    protected void didAttach() {
        turnStrategy = onPlayer.getStrategy();
        onPlayer.setStrategy(new TurnStrategyFrozen());
    }

    @Override
    protected void willDetach() {
        onPlayer.setStrategy(turnStrategy);

    }

    @Override
    public String getImageName() {
        String imageName = "freezing.png";
        return imageName;
    }
}
