package game;

import map.Cell;

/**
 * this class is the game.Chest in the game
 * @author Li Zhen
 * @version 0.1
 */
public class Chest extends Cell{
    private Equipment equipment;

    /**
     * this method is to get equipment in the chest
     * @return equipment game.Equipment
     */

    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * this method is to set equipment in the chest
     * @param equipment game.Equipment
     */


    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
