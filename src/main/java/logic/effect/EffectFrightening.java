package logic.effect;


import logic.PlayRuntime;
import logic.player.Player;
import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyFrightened;

public class EffectFrightening extends Effect {
    private TurnStrategy turnStrategy;
    private Player combatant = PlayRuntime.currentRuntime().getMainPlayer();

    @Override
    protected void didAttach() {
        turnStrategy = onPlayer.getStrategy();
        onPlayer.setStrategy(new TurnStrategyFrightened());
    }

    @Override
    protected void willDetach() {
        onPlayer.setStrategy(turnStrategy);
    }

    public Player getCombatant() {
        return combatant;
    }
}
