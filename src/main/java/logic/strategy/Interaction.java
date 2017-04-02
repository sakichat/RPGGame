package logic.strategy;

/**
 * Created by Kai QI on 2017/4/2.
 */
public class Interaction {

    private PlayerStrategy playerStrategy;

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    public void executeStrategy() {
        this.playerStrategy.turn();
    }
}
