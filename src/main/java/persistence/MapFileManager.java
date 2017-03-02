package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import game.Player;
import map.GameMap;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by thereaghostflash on 2017-03-02.
 */
public class MapFileManager {

    public static File folderPath(){
        return new File("data/maps");
    }

    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "data/maps/" + newName + ".map.json";
        System.out.println(newName);
        return new File(newName);

    }

    public static GameMap read(String name){
        File file = MapFileManager.path(name);
        String mapName = FileManager.fileToString(file);
        GameMap gameMap = new Gson().fromJson(mapName,GameMap.class);
        return gameMap;

    }

    public static void save(GameMap gameMap){
        String name = gameMap.getName();
        File file = path(name);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String content = gson.toJson(gameMap);
        FileManager.stringToFile(content,file);

    }

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

    public static String filePathToName(String filePath){
        int number = filePath.indexOf(".");
        return FileManager.fileNameToName(filePath.substring(0, number));
    }

}
