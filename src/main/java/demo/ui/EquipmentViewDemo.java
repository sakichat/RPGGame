package demo.ui;

import game.Equipment;
import game.Player;
import ui.view.EquipmentView;

import javax.swing.*;

/**
 * @author Qi Xia
 */
public class EquipmentViewDemo extends JFrame{
    public static void main(String[] args) {
        EquipmentViewDemo window = new EquipmentViewDemo();
        window.setSize(450, 50);
        window.setLayout(null);
        window.setVisible(true);
    }

    public EquipmentViewDemo(){
        EquipmentView equipmentView = new EquipmentView();
        equipmentView.setLocation(0, 50);
        this.add(equipmentView);

        Equipment equipment = new Equipment();
        equipment.setName("haha");
        equipment.setType(Equipment.BOOTS);
        equipment.setEnhancedAttribute(Player.ATTRIBUTE_ARMOR_CLASS);
        equipment.setEnhancedValue(2);
        equipmentView.setEquipment(equipment);
    }
}
