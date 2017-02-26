package demo.file;

import game.FileManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zhaozhe on 26/02/2017.
 */
public class FileDemo {
    public static void main(String[] args) {

        File file = new File("file/file.txt");

        // write
        String content = "hahaha\nhehehe";
        FileManager.stringToFile(content, file);

        // read
        String string = FileManager.fileToString(file);
        System.out.println(string);
    }
}
