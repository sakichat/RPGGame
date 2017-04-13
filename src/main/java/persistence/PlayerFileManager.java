package persistence;

import logic.player.Player;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Zhen
 * @version 0.2
 *
 * this class is to manage the files of currentPlayer
 */
public class PlayerFileManager {
    /**
     * this method is to get new File
     * @return file File
     */

    public static File folderPath(){
        return new File("data/players");
    }

    /**
     * this method is to get file path
     * @param name String
     * @return File
     */

    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "data/players/" + newName + ".ply.json";
        return new File(newName);

    }

    /**
     * this method is to read files of Player
     * @param name String
     * @return Player
     */

    public static Player read(String name){
        File file = PlayerFileManager.path(name);
        String content = FileManager.fileToString(file);
        Player player = FileManager.defaultGson().fromJson(content,Player.class);
        return player;

    }

    /**
     * this method is to save the files of Player
     * @param player Player
     */

    public static void save(Player player){
        String name = player.getName();
        File file = path(name);
        String content = FileManager.defaultGson().toJson(player);
        FileManager.stringToFile(content,file);

    }

    /**
     * this method is to get all names of Player
     * @return List<String>
     */

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
