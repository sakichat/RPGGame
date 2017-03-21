package logic;

/**
 * Created by thereaghostflash on 2017-03-21.
 */
public class NimbleBuilder extends PlayerBuilder {
    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_NIMBLE);
    }

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_NIMBLE);
    }

}
