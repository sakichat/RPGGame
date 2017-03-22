package logic;

/**
 * Created by Li Zhen on 2017-03-21.
 * this is the class that build type of Tank Player
 * @version 0.2
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
     * this is the method that generate ability
     */

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_TANK);
    }
}
