package logic;

/**
 * Created by thereaghostflash on 2017-03-21.
 */
public class PlayerExplorer {

    private PlayerBuilder playerBuilder;

    public void setPlayerBuilder(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    public void constructPlyar(String playerName, int level){
        playerBuilder.createNewPlayer(playerName);
        playerBuilder.setPlayerProductlevel(level);
        playerBuilder.setPlayerType();
        playerBuilder.generateAbilities();
    }

    public Player getPlayer(){
        return playerBuilder.getPlayerProduct();
    }
}