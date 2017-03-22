package ui.panel;

import logic.Equipment;

/**
 * @author Li Zhen
 * @version 0.1
 * this is the EquipmentDelegate interface
 */
public interface EquipmentDelegate {
    /**
     * this method is to give the two patameters
     * @param selectorPanel EquipmentSelectorPanel
     * @param equipment Equipment
     */
    void equipmentSelectorPerformAction(EquipmentSelectorPanel selectorPanel, Equipment equipment);

}
