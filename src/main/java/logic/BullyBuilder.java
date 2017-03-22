package logic;

/**
 * Created by lizhen on 2017-03-21.
 * this is the class that build  type Bully
 *@version 0.2
 */
public class BullyBuilder extends PlayerBuilder {
    /**
     * this is the method to set type of player
     */
    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_BULLY);

    }

    /**
     * this is the method to generate ability of player
     */

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_BULLY);
    }

}
