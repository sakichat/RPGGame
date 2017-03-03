package ui.panel;

import game.Equipment;
import game.Player;

/**
 * Created by thereaghostflash on 2017-02-28.
 * this is the PlayerDelegate implements
 */
public interface PlayerDelegate {
    /**
     * this method is to give the two patameters
     * @param playerSelectorPanel PlayerSelectorPanel
     * @param player Player
     */
    void playerSelectorPerformAction(PlayerSelectorPanel playerSelectorPanel, Player player);

}
