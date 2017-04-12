package logic.interaction;

import logic.equipment.Equipment;
import logic.player.Player;

import java.util.List;


public class InteractionDeadNPC extends Interaction<Player> {
    @Override
    public void interact() {

        List<Equipment> inventories = target.getInventories();

        int availableSpaceInBackpack = player.availableSpotsInBackpack();
        int inventoriesSize = inventories.size();
        int lootSize = Math.min(availableSpaceInBackpack, inventoriesSize);

        for (int i = 0; i < lootSize; i++) {
            Equipment lootEquipment = inventories.get(0);
            player.pickUpEquipment(lootEquipment);
            target.dropInventories(lootEquipment);
//            inventories.remove(0);
        }

    }

}
