package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import logic.Campaign;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Zhen
 * @version 0.1
 *
 * this class is to manage the files of campaign
 */
public class CampaignFileManager {
    /**
     * this method is to get new File
     * @return file File
     */
    public static File folderPath(){
        return new File("data/campaigns");
    }

    /**
     * this method is to get a file with path
     * @param name String
     * @return File
     */
    public static File path(String name){
        String newName = FileManager.nameToFileName(name);
        newName = "data/campaigns/" + newName + ".cam.json";
        return new File(newName);
    }

    /**
     * this method is to read files of Campaign
     * @param name String
     * @return Campaign
     */

    public static Campaign read(String name){
        File file = CampaignFileManager.path(name);
        String content = FileManager.fileToString(file);
        Campaign campaign = new Gson().fromJson(content,Campaign.class);
        return campaign;

    }

    /**
     * this method is to save file
     * @param campaign Campaign
     */

    public static void save(Campaign campaign){
        String name = campaign.getName();
        File file = path(name);
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        String content = gson.toJson(campaign);
        FileManager.stringToFile(content,file);

    }

    /**
     * this method is to get allNames of campaign
     * @return List<String>
     */

    public static List<String> allNames() {
        File folder = new File("data/campaigns/");

        String[] fileNames = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".cam.json");
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
