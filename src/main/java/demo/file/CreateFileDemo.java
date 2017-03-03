package demo.file;

import logic.Equipment;
import logic.Simulation;
import persistence.EquipmentFileManager;

import java.util.List;

/**
 * Created by thereaghostflash on 2017-02-28.
 */
public class CreateFileDemo {
    public static void main(String[] args) {
        List<Equipment> equipmentsList = Simulation.getEquipments();
        for (Equipment equipment : equipmentsList){
            EquipmentFileManager.save(equipment);
        }
    }
}
