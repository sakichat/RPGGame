package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import logic.GameMap;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Zhen
 * @version 0.1
 *
 * this class is to manage the files of map
 */

public class MapFileManager {
    /**
     * this is to new a  file
     * @return File
     */

    public static File folderPath(){
        return new File("data/maps");
    }
    /**
     * this method is to get a file with path
     * @param name String
     * @return File
     */


    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "data/maps/" + newName + ".map.json";
        System.out.println(newName);
        return new File(newName);

    }

    /**
     * this method is to read files of map
     * @param name String
     * @return GameMap
     */

    public static GameMap read(String name){
        File file = MapFileManager.path(name);
        String mapName = FileManager.fileToString(file);
        System.out.println(mapName);
        GameMap gameMap = new Gson().fromJson(mapName,GameMap.class);
        return gameMap;

    }
    /**
     * this method is to save file
     * @param gameMap GameMap
     */

    public static void save(GameMap gameMap){
        String name = gameMap.getName();
        File file = path(name);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String content = gson.toJson(gameMap);
        FileManager.stringToFile(content,file);

    }
    /**
     * this method is to get allNames of map
     * @return List<String>
     */

    public static List<String> allNames() {
        File folder = new File("data/maps/");

        String[] fileNames = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".map.json");
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
