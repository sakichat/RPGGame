package demo.file;

import persistence.FileManager;

import java.io.File;


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
