package logic;

/**
 * Created by Li Zhen on 2017-03-21.
 * this is the class to build typle of 
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
