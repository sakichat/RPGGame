package logic;

/**
 * Created by thereaghostflash on 2017-03-21.
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
