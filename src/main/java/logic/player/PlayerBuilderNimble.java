package logic.player;

/**
 * this is the class to build typle of Nimble Player
 * @author Li Zhen
 * @version 0.3
 */
public class PlayerBuilderNimble extends PlayerBuilder {
    /**
     * this is the method to set type of Player
     */
    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_NIMBLE);
    }

    /**
     * this is the method to set type of Player
     */

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_NIMBLE);
    }

}
