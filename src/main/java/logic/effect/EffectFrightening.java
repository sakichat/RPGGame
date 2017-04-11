package logic.effect;


import logic.Play;
import logic.player.Player;
import logic.turn.TurnStrategy;
import logic.turn.TurnStrategyFrightened;

public class EffectFrightening extends Effect {
    private TurnStrategy turnStrategy;
    private Player combatant = Play.getCurrentPlay().getPlayer();

    @Override
    protected void didAttach() {
        turnStrategy = onPlayer.getStrategy();
        onPlayer.setStrategy(new TurnStrategyFrightened());
    }

    @Override
    protected void willDetach() {
        onPlayer.setStrategy(turnStrategy);
    }
}
