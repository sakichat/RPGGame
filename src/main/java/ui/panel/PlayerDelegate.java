package ui.panel;

import logic.Player;

/**
 * @author Li Zhen
 * @version 0.1
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
