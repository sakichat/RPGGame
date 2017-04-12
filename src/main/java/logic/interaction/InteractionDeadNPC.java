package logic.interaction;

import logic.equipment.Equipment;
import logic.map.Cell;
import logic.player.Player;

import java.util.List;


public class InteractionDeadNPC extends Interaction<Player> {
    @Override
    public void interact(Player target) {


        List<Equipment> inventories = target.getInventories();

        int backpackEmptySize = 10 - target.equipmentsInBackpack().size();
        int inventoriesSize = inventories.size();
        int lootSize = Math.min(backpackEmptySize, inventoriesSize);

        for (int i = 0; i < lootSize; i++) {
            Equipment lootEquipment = inventories.get(0);
            target.pickUpEquipment(lootEquipment);
            target.dropInventories(lootEquipment);
            inventories.remove(0);
        }

    }
}
