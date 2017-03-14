package demo.ui;

import logic.Simulation;
import ui.panel.InventoryPanel;

import javax.swing.*;

/**
 * @author Qi Xia
 */
public class BackpackPanelDemo extends JFrame{
    public static void main(String[] args) {
        BackpackPanelDemo window = new BackpackPanelDemo();
        window.setSize(500, 400);
        window.setLayout(null);
        window.setVisible(true);
    }

    public BackpackPanelDemo(){
        InventoryPanel inventoryPanel = new InventoryPanel();
        inventoryPanel.setPlayer(Simulation.newPlayer());
        inventoryPanel.setLocation(0, 0);
        this.add(inventoryPanel);
    }
}
