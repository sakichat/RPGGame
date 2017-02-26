package game;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zhaozhe on 26/02/2017.
 */
public class FileManager {
    public static String nameToFileName(String name){
        return name.replaceAll("\\s", "_");
    }

    public static String getEquipmentFolderPath(){
        return "data/equipments";
    }

    public static void stringToFile(String content, File file){
        try {
            FileUtils.writeStringToFile(file, content, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
