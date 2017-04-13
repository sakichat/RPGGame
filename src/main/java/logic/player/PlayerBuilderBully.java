package logic.player;

/**
 * this is the class that build  type  of Bully currentPlayer
 * @author Li Zhen
 *@version 0.2
 */
public class PlayerBuilderBully extends PlayerBuilder {
    /**
     * this is the method to set type of currentPlayer
     */
    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_BULLY);

    }

    /**
     * this is the method to generate ability of currentPlayer
     * 
     */

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_BULLY);
    }

}
