package persistence;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import logic.equipments.Equipment;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Zhen
 * @version 0.2
 *
 * this class is to manage the files of equipments
 */
public class EquipmentFileManager {
    /**
     * this is to get file
     * @return File
     */

    public static File folderPath(){
        return new File("data/equipments");
    }

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
        String content = FileManager.fileToString(file);
        Gson gson = FileManager.defaultGson();
        Equipment equipment = gson.fromJson(content,EquipmentWrapper.class).getEquipment();
        return equipment;

    }
    /**
     * this method is to save equipement to a file
     * @param equipment Equipment
     */

    public static void save(Equipment equipment){
        String name = equipment.getName();
        File file = path(name);
        Gson gson = FileManager.defaultGson();
        String content = gson.toJson(new EquipmentWrapper(equipment));
        FileManager.stringToFile(content,file);

    }

    /**
     * this method is to get all the files
     * @return String[]
     */

    public static List<String> allNames(){
        File folder = new File("data/equipments/");
        
        String[] fileNames = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".eqp.json");
            }
        });


        List<String> names = new LinkedList<>();
        for (String fileName : fileNames) {
            names.add(filePathToName(fileName));
        }
        return names;
    }

    /**
     * this class is to return the path of file
     * @param filePath String
     * @return String
     */

    public static String filePathToName(String filePath){
        int number = filePath.indexOf(".");
        return FileManager.fileNameToName(filePath.substring(0, number));
    }


}

class EquipmentWrapper{

    @Expose
    private Equipment equipment;

    public EquipmentWrapper() {

    }

    public EquipmentWrapper(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
