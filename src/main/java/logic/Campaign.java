package logic;

import com.google.gson.annotations.Expose;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Qi Xia
 * @version 0.3
 * this class is the Campaign
 */
public class Campaign {

    @Expose
    private String name;

    /**
     * this method is to get name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * this method is to set name
     * @param name String
     */

    public void setName(String name) {
        this.name = name;
    }

    @Expose
    private List<String> mapNames = new LinkedList<>();

    /**
     * this method is to get names of maps
     * @return List<String>
     */

    public List<String> getMapNames() {
        return mapNames;
    }

    /**
     * this method is to get index of name of map
     * @param index int
     * @return String
     */

    public String getMapName(int index) {
        return mapNames.get(index);
    }

    /**
     * this method is to add name of map
     * @param mapName String
     */

    public void addMapName(String mapName) {
        mapNames.add(mapName);
    }

    /**
     * this method is to remove the name of maps
     * @param index int
     */

    public void removeMapName(int index) {
        mapNames.remove(index);
    }


    public final static String VALIDATION_SUCCESS = "Valid";
    public final static String VALIDATION_ERROR_NO_MAP = "No map";

    /**
     * this method is to validate the map
     * @return String
     */

    public String validate(){
        return mapNames.size() > 0 ? VALIDATION_SUCCESS : VALIDATION_ERROR_NO_MAP;
    }
}
