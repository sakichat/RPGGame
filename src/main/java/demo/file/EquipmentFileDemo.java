package demo.file;

import logic.Equipment;
import logic.Player;
import persistence.EquipmentFileManager;

/**
 * Created by thereaghostflash on 2017-02-27.
 */
public class EquipmentFileDemo {
    public static void main(String[] args) {
        Equipment equipment = new Equipment("s b",Equipment.HELMET, Player.ATTRIBUTE_ARMOR_CLASS,3);
        EquipmentFileManager.save(equipment);
        Equipment equipment1 = EquipmentFileManager.read("s b");
        System.out.println(equipment1);
    }

}