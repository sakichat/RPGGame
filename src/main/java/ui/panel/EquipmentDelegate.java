package ui.panel;

import logic.Equipment;

/**
 * Created by thereaghostflash on 2017-02-27.
 * this is the EquipmentDelegate implements
 */
public interface EquipmentDelegate {
    /**
     * this method is to give the two patameters
     * @param selectorPanel EquipmentSelectorPanel
     * @param equipment Equipment
     */
    void equipmentSelectorPerformAction(EquipmentSelectorPanel selectorPanel, Equipment equipment);

}
