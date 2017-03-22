package logic;

/**
 * Created by Li Zhen on 2017-03-21.
 * this class is a abstract class to build the player
 */
public abstract class PlayerBuilder {
    protected Player playerProduct;

    /**
     *this method is to get Player
     *
     * @return Player
     */
    public Player getPlayerProduct() {
        return playerProduct;
    }

    /**
     * this method is to createPlayer
     * @param playerName String
     */

    public void createNewPlayer(String playerName){
        playerProduct = new Player(playerName);
    }

    /**
     * this method is to set player 
     * @param playerProductlevel
     */

    public void setPlayerProductlevel(int playerProductlevel){
        playerProduct.setLevel(playerProductlevel);
    }

    abstract void setPlayerType();
    abstract void generateAbilities();

}
