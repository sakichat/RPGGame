package demo.ui;

import logic.Simulation;
import ui.panel.EquipmentPanel;

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
        EquipmentPanel equipmentPanel = new EquipmentPanel();
        equipmentPanel.setPlayer(Simulation.newPlayer());
        equipmentPanel.setLocation(0, 0);
        this.add(equipmentPanel);
    }
}
