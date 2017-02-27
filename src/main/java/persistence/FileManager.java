package persistence;

import org.apache.commons.io.FileUtils;

import java.io.File;
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
