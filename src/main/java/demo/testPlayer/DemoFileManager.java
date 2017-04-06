package demo.testPlayer;

import persistence.FileManager;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GU_HAN on 2017-04-06.
 */
public class DemoFileManager {

    public static File folderPath(){
        return new File("data/demotest");
    }

    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "data/demotest/" + newName + ".demo.json";
        return new File(newName);

    }

    public static TestPlayer read(String name){
        File file = DemoFileManager.path(name);
        String content = FileManager.fileToString(file);
        TestPlayer testPlayer = FileManager.defaultGson().fromJson(content,TestPlayer.class);
        return testPlayer;

    }

    public static void save(TestPlayer testPlayer){
        String name = testPlayer.getName();
        File file = path(name);
        String content = FileManager.defaultGson().toJson(testPlayer);
        FileManager.stringToFile(content,file);

    }
    /**
     * this method is to get allNames of map
     * @return List<String>
     */

    public static List<String> allNames() {
        File folder = new File("data/demotest/");

        String[] fileNames = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".demo.json");
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
