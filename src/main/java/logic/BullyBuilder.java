package logic;

/**
 * Created by lizhen on 2017-03-21.
 *@version 0.2
 */
public class BullyBuilder extends PlayerBuilder {
    /**
     * this is
     */
    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_BULLY);

    }

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_BULLY);
    }

}
