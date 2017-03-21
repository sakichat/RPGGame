package ui.panel;

import logic.Equipment;

/**
 * @author Kai QI
 * @version 0.2
 *
 * This class is for InventoryDelegate interface.
 *
 */
public interface InventoryDelegate {

    /**
     * The method is the abstract method needed to be implemented by the implemented class.
     * @param inventoryPanel
     * @param equipment
     */
    void inventoryExchangePerformAction(InventoryPanel inventoryPanel, Equipment equipment);
}
