package logic.map;

import com.google.gson.annotations.Expose;
import logic.PlayRuntime;
import logic.equipment.Equipment;

import java.util.LinkedList;
import java.util.List;

/**
 * this class is the logic.Chest in the game
 * @author Li Zhen
 * @version 0.3
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
    private boolean isFull() {
        if (equipments.size() >= 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to check if the chest is empty or not.
     * @return
     */
    public boolean isEmpty(){
        if (equipments.isEmpty()) {
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
        if (!isFull()) {
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
        tryQuit();
    }

    /**
     * this method is to refresh the value of equipment accoding to the level of player
     * @param level int
     */

    public void adaptEquipments(int level){
        if (equipments != null){
            for (Equipment equipment : equipments){
                equipment.levelRefresh(level);
            }
        }
    }

    private void tryQuit(){
        if (isEmpty()) {
            PlayRuntime.currentRuntime().getMap().removeCell(this.getLocation());
        }
    }


}
