package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import logic.Play;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GU_HAN on 2017-04-01.
 */
public class PlayFileManager {
    public static File folderPath(){
          return new File("data/plays");
    }

    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "data/plays" + newName + ".play.json";
        return new File(newName);
    }

    /**
     *
     * @param name
     * @return
     */
    public static Play read(String name){
        File file = PlayFileManager.path(name);
        String content = FileManager.fileToString(file);
        Play play = new Gson().fromJson(content, Play.class);
        return null;
    }

    public static void save(Play play){
        String name = play.getName();
        File file = path(name);
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        String content = gson.toJson(play);
        FileManager.stringToFile(content, file);
    }

    public static List<String> allNames(){
        File folder = new File("data/plays/");

        String[] fileNames = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".play.json");
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
