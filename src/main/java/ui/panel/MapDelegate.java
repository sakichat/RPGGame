package ui.panel;

import logic.GameMap;

/**
 * @author Li Zhen
 * @version 0.1
 * this is the MapDelegate implements
 */
public interface MapDelegate {
    /**
     * this method is to give the two patameters
     * @param mapSelectorPanel MapSelectorPanel
     * @param gameMap GameMap
     */
    void mapSelectorPerformAction(MapSelectorPanel mapSelectorPanel, GameMap gameMap);

}
