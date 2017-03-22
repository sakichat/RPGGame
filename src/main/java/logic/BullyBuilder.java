package logic;

/**
 * Created by lizhen on 2017-03-21.
 *
 */
public class BullyBuilder extends PlayerBuilder {
    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_BULLY);

    }

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_BULLY);
    }

}
