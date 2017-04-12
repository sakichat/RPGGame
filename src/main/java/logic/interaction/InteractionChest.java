package logic.interaction;

import logic.equipment.Equipment;
import logic.map.Chest;


public class InteractionChest extends Interaction<Chest> {

    @Override
    public void interact() {
        int availableSpaceInBackpack = 10 - player.equipmentsInBackpack().size();
        int chestSize = target.getEquipments().size();
        int lootSize = Math.min(availableSpaceInBackpack, chestSize);

        for (int i = 0; i < lootSize; i++) {
            Equipment lootEquipment = target.getEquipments().get(0);
            player.pickUpEquipment(lootEquipment);
            target.dropEquipment(lootEquipment);
        }
    }

}
