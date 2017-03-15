package demo.ui;

import logic.Simulation;
import ui.panel.EquipmentPanel;
import ui.panel.InventoryPanel;

import javax.swing.*;

/**
 * @author Qi Xia
 */
public class EquipmentPanelDemo extends JFrame{
    public static void main(String[] args) {
        EquipmentPanelDemo window = new EquipmentPanelDemo();
        window.setSize(500, 400);
        window.setLayout(null);
        window.setVisible(true);
    }

    public EquipmentPanelDemo(){
        EquipmentPanel equipmentPanel = new EquipmentPanel();
//        equipmentPanel.setChest(Simulation.chest);
        equipmentPanel.setLocation(0,0);
        this.add(equipmentPanel);
    }
}
