package persistence;

import com.google.gson.Gson;
import game.Equipment;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * this class is a fileManager to manage the files
 * @author Li Zhen
 */


public class FileManager {

    /**
     * this method is to transfer the normal version of String name to  specific FileName
     * @param name String
     * @return String
     */
    public static String nameToFileName(String name){
        name.toLowerCase();
        return name.replaceAll("\\s", "_");
    }

    /**
     *  this method is to tranfer fileName to equipment name
     * @param fileName String
     * @return String
     */

    public static String fileNameToName(String fileName){
        fileName.replaceAll("_","\\s");
        char[] name = fileName.toCharArray();
        name[0] -= 32;
        return String.valueOf(name);

    }

    /**
     * this method is to create a file with path
     * @param name String
     * @return File
     */
    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "/data/equipments/" + newName + ".eqp.json";
        return new File(newName);

    }

    /**
     * this method is to read file to create a equipment
     * @param name String
     * @return Equipment
     */
    public static Equipment read(String name){
        File file = FileManager.path(name);
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
        File file = new File("/data/equipments/" + name + ".eqp.json");
        if (file.exists()){
            file.delete();
            File file1 = new File("\"/data/equipments/\" + name + \".eqp.json\"");
            Gson gson = new Gson();
            String content = gson.toJson(equipment);
            FileManager.stringToFile(content,file1);

        }else {
            File file1 = new File("\"/data/equipments/\" + name + \".eqp.json\"");
            Gson gson = new Gson();
            String content = gson.toJson(equipment);
            FileManager.stringToFile(content,file1);
        }
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

                return name.contains(".eqp.json");
            }
        });
        nameList = new String[fileName.length];
        for (int i = 0; i < fileName.length; i++){
            int number = fileName[i].indexOf(".");
            nameList[i] = FileManager.fileNameToName(fileName[i].substring(0,number));
        }
        return nameList;


    }

    /**
     * this mehod is to transfer equipment to a file
     * @param content String
     * @param file File
     */


    public static void stringToFile(String content, File file){
        try {
            FileUtils.writeStringToFile(file, content, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method is to transfer the file to a Equipment
     * @param file File
     * @return String
     */

    public static String fileToString(File file){
        String content = null;
        try {
            content = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
