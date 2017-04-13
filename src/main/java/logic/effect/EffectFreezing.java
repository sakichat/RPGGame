package logic.effect;


import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyFrozen;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class EffectFreezing extends Effect {
    /**
     * attribute
     */
    private TurnStrategy turnStrategy;

    /**
     * This method is used to attach effect on player
     */
    @Override
    protected void didAttach() {
        turnStrategy = onPlayer.getStrategy();
        onPlayer.setStrategy(new TurnStrategyFrozen());
    }

    /**
     * This method is used to detach effect once
     */
    @Override
    protected void willDetach() {
        onPlayer.setStrategy(turnStrategy);

    }

    /**
     * This method is used to get imageName
     * @return
     */
    @Override
    public String getImageName() {
        String imageName = "freezing.png";
        return imageName;
    }
}
