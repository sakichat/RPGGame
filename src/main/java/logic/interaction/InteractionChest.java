package logic.interaction;

import logic.equipment.Equipment;
import logic.map.Chest;

/**
 * @author Kai QI
 * @version 0.3
 * The class is a subclass of Interaction, which is used to interact with Chest
 */
public class InteractionChest extends Interaction<Chest> {

    /**
     * override the interact method in superclass
     * this method is to interact with chest
     */
    @Override
    public void interact() {
        int availableSpaceInBackpack = player.availableSpotsInBackpack();
        int chestSize = target.getEquipments().size();
        int lootSize = Math.min(availableSpaceInBackpack, chestSize);

        for (int i = 0; i < lootSize; i++) {
            Equipment lootEquipment = target.getEquipments().get(0);
            player.pickUpEquipment(lootEquipment);
            target.dropEquipment(lootEquipment);
        }
    }

}
