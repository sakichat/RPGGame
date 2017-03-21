package logic;

/**
 * Created by thereaghostflash on 2017-03-21.
 */
public abstract class PlayerBuilder {
    protected Player playerProduct;

    public Player getPlayerProduct() {
        return playerProduct;
    }

    public void createNewPlayer(String playerName){
        playerProduct = new Player(playerName);
    }

    public void setPlayerProductlevel(int playerProductlevel){
        playerProduct.setLevel(playerProductlevel);
    }

    abstract void setPlayerType();
    abstract void generateAbilities();

}
