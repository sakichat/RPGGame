package persistence;

import com.google.gson.Gson;
import game.Equipment;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Li Zhen
 * @version 0.1
 */
public class EquipmentFileManager {
    /**
     * this method is to create a file with path
     * @param name String
     * @return File
     */
    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "data/equipments/" + newName + ".eqp.json";
        System.out.println(newName);
        return new File(newName);

    }
    /**
     * this method is to read file to create a equipment
     * @param name String
     * @return Equipment
     */
    public static Equipment read(String name){
        File file = EquipmentFileManager.path(name);
        String equipmentName = FileManager.fileToString(file);
        Equipment equipment = new Gson().fromJson(equipmentName,Equipment.class);
        return equipment;

    }
    /**
     * this method is to save equipement to a file
     * @param equipment Equipment
     */

    public static void save(Equipment equipment){
        String name = equipment.getName();
        File file = path(name);
        Gson gson = new Gson();
        String content = gson.toJson(equipment);
        FileManager.stringToFile(content,file);

    }

    /**
     * this method is to get all the files
     * @return String[]
     */

    public static String[] allName(){
        String[] nameList;
        File file = new File("/data/equipments/");
        String[] fileName = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                return name.endsWith(".eqp.json");
            }
        });
        nameList = new String[fileName.length];
        for (int i = 0; i < fileName.length; i++){
            int number = fileName[i].indexOf(".");
            nameList[i] = FileManager.fileNameToName(fileName[i].substring(0,number));
        }
        return nameList;

    }
}
