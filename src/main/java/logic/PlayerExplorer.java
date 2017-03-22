package logic;

/**
 * Created by Li Zhen on 2017-03-21.
 * this is the class that command the different builders of player
 */
public class PlayerExplorer {

    private PlayerBuilder playerBuilder;

    /**
     * this is the method that  set builder of player
     * @param playerBuilder PlayerBuilder
     */
    public void setPlayerBuilder(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    /**
     * this is the method that construct the player via plyerName and level
     * @param playerName String
     * @param level int
     */

    public void constructPlyar(String playerName, int level){
        playerBuilder.createNewPlayer(playerName);
        playerBuilder.setPlayerProductlevel(level);
        playerBuilder.setPlayerType();
        playerBuilder.generateAbilities();
    }

    /**
     * this is the method 
     * @return
     */

    public Player getPlayer(){
        return playerBuilder.getPlayerProduct();
    }
}
