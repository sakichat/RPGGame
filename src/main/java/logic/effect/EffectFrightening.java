package logic.effect;

import logic.PlayRuntime;
import logic.player.Player;
import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyFrightened;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class EffectFrightening extends Effect {

    /**
     * attribute
     */
    private TurnStrategy turnStrategy;
    private Player combatant = PlayRuntime.currentRuntime().getPlay().currentPlayer();

    /**
     * This method is used to attach effect on player
     */
    @Override
    protected void didAttach() {
        turnStrategy = onPlayer.getStrategy();
        onPlayer.setStrategy(new TurnStrategyFrightened());
    }

    /**
     * This method is used to detach effect from player once
     */
    @Override
    protected void willDetach() {
        onPlayer.setStrategy(turnStrategy);
    }

    /**
     * getter combatant
     * @return Player
     */
    public Player getCombatant() {
        return combatant;
    }
}
