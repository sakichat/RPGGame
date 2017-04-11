package logic.effect;


import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyFrozen;

public class EffectFreezing extends Effect {
    private TurnStrategy turnStrategy;

    @Override
    public String getImageName() {
        String imageName = "freezing.png";
        return imageName;
    }

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
