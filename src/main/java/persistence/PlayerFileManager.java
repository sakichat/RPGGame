package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import game.Equipment;
import game.Player;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by thereaghostflash on 2017-02-28.
 */
public class PlayerFileManager {

    public static File folderPath(){
        return new File("data/players");
    }

    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "data/players/" + newName + ".ply.json";
        System.out.println(newName);
        return new File(newName);

    }

    public static Player read(String name){
        File file = EquipmentFileManager.path(name);
        String playerName = FileManager.fileToString(file);
        Player player = new Gson().fromJson(playerName,Player.class);
        return player;

    }

    public static void save(Player player){
        String name = player.getName();
        File file = path(name);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String content = gson.toJson(player);
        FileManager.stringToFile(content,file);

    }

    public static List<String> allNames(){
        File folder = new File("data/players/");

        String[] fileNames = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".ply.json");
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
