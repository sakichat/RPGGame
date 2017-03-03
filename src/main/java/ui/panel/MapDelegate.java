package ui.panel;

import logic.GameMap;

/**
 * Created by thereaghostflash on 2017-03-02.
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
