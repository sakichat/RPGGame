package demo.ui;

import ui.panel.EquipmentSelectorPanel;

import javax.swing.*;

/**
 * Created by thereaghostflash on 2017-02-25.
 */
public class EquipmentSelectorDemo {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(600,600);
        EquipmentSelectorPanel equipmentSelectorPanel = new EquipmentSelectorPanel();
        equipmentSelectorPanel.setLocation(0,0);
        jFrame.add(equipmentSelectorPanel);

    }

}
