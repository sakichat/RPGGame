package logic.player;

/**
 * this is the class that command the different builders of currentPlayer
 * @author Li Zhen
 * @version 0.3
 */
public class PlayerExplorer {

    private PlayerBuilder playerBuilder;

    /**
     * this is the method that  set builder of currentPlayer
     * @param playerBuilder PlayerBuilder
     */
    public void setPlayerBuilder(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    /**
     * this is the method that construct the currentPlayer via plyerName and level
     * @param playerName String
     * @param level int
     */

    public void constructPlayer(String playerName, int level){
        playerBuilder.createNewPlayer(playerName);
        playerBuilder.setPlayerProductlevel(level);
        playerBuilder.setPlayerType();
        playerBuilder.generateAbilities();
    }

    /**
     * this is the method that can get Player
     * @return Player
     */

    public Player getPlayer(){
        return playerBuilder.getPlayerProduct();
    }
}
