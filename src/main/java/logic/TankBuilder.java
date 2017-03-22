package logic;

/**
 * Created by Li Zhen on 2017-03-21.
 * this is the class that build type of 
 */
public class TankBuilder extends PlayerBuilder {

    @Override
    void setPlayerType() {
        playerProduct.setPlayerType(Player.PLAYER_TYPE_TANK);
    }

    @Override
    void generateAbilities() {
        playerProduct.generateAbilities(Player.PLAYER_TYPE_TANK);
    }
}
