package logic;

/**
 * Created by Li Zhen on 2017-03-21.
 * this is the class that build type of Tank Player
 */
public class TankBuilder extends PlayerBuilder {
    /**
     * this is the method that set type of Player
     */

    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_TANK);
    }

    /**
     * this is 
     */

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_TANK);
    }
}
