package logic;

import com.google.gson.annotations.Expose;

/**
 * this class is the logic.Chest in the game
 * @author Li Zhen
 * @version 0.1
 */
public class Chest extends Cell{

    @Expose
    private Equipment equipment;

    /**
     * this method is to get equipment in the chest
     * @return equipment logic.Equipment
     */

    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * this method is to set equipment in the chest
     * @param equipment logic.Equipment
     */


    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * this is the constructor to set name of image
     */
    public Chest() {
        imageName = "chest.png";
    }
}
