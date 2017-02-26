package persistence;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class FileManager {
    public static String nameToFileName(String name){
        return name.replaceAll("\\s", "_");
    }

    public static String fileNameToName(String fileName){
        // TODO: 26/02/2017
        return null;
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
