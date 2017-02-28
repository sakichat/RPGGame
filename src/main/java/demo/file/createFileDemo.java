package demo.file;

import game.Equipment;
import game.Simulation;
import persistence.EquipmentFileManager;
import persistence.FileManager;

import java.util.List;

/**
 * Created by thereaghostflash on 2017-02-28.
 */
public class createFileDemo {
    public static void main(String[] args) {
        List<Equipment> equipmentsList = Simulation.getEquipments();
        for (Equipment equipment : equipmentsList){
            EquipmentFileManager.save(equipment);
        }
    }
}
