package demo.file;

import game.Equipment;
import persistence.EquipmentFileManager;

/**
 * Created by thereaghostflash on 2017-02-27.
 */
public class EquipmentFileDemo {
    public static void main(String[] args) {
        Equipment equipment = new Equipment("s b","HELMET","AC",3);
        EquipmentFileManager.save(equipment);
    }

}
