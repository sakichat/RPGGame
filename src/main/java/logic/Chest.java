package logic;

import com.google.gson.annotations.Expose;

import java.util.LinkedList;
import java.util.List;

/**
 * this class is the logic.Chest in the game
 * @author Li Zhen
 * @version 0.1
 */
public class Chest extends Cell{

    @Expose
    private List<Equipment> equipments = new LinkedList<>();

    /**
     * this method is to get equipments in the chest
     * @return equipment logic.Equipment
     */

    public List<Equipment> getEquipments() {
        return equipments;
    }

    /**
     * this method is to set equipment in the chest
     * @param equipments logic.Equipment
     */

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    /**
     * this method is set the name of image
     */
    public Chest() {
        imageName = "chest.png";
    }

    /**
     * This method is used to check if the chest is full or not.
     * @return
     */
    private boolean isChestFull() {
        if (equipments.size() >= 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Static final variable which is used to notify observers.
     */
    public static final String CHEST_CHANGE = "Chest change";

    /**
     * This method is used to add equipments to chest.
     * @param e
     */
    public void addEquipment(Equipment e) {
        if (!isChestFull()) {
            equipments.add(e);
            setChanged();
            notifyObservers(CHEST_CHANGE);
        }
    }

    /**
     * This method is used to drop equipments from chest.
     * @param e
     */
    public void dropEquipment(Equipment e) {
        equipments.remove(e);
        setChanged();
        notifyObservers(CHEST_CHANGE);
    }

    /**
     * this method is to refresh the value of equipment accoding to the level of player
     * @param level int
     */

    public void refreshChest(int level){
        if (equipments != null){
            for (Equipment equipment : equipments){
                equipment.levelRefresh(level);
            }
        }
    }

    /**
     * this method is to return a equipment randomly
     * @return
     */

    public Equipment randomEquipment(){
        int number = (int)(Math.random() * equipments.size());
        return equipments.get(number);
    }

}
