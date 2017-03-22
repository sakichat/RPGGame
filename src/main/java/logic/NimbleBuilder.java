package logic;

/**
 * Created by Li Zhen on 2017-03-21.
 * this is the class to build typle of Nimble Player
 */
public class NimbleBuilder extends PlayerBuilder {
    /**
     * this is the method to set type of 
     */
    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_NIMBLE);
    }

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_NIMBLE);
    }

}
