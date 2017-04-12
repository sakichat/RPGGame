package logic.interaction;

import logic.equipment.Equipment;
import logic.map.Chest;


public class InteractionChest extends Interaction<Chest> {

    @Override
    public void interact() {
        int availableSpaceInBackpack = player.availableSpotsInBackpack();
        int chestSize = target.getEquipments().size();
        int lootSize = Math.min(availableSpaceInBackpack, chestSize);

        for (int i = 0; i < lootSize; i++) {
            Equipment lootEquipment = target.getEquipments().get(i);
            player.pickUpEquipment(lootEquipment);
            target.dropEquipment(lootEquipment);
        }
    }

}
