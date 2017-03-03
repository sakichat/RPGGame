package logic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Saki on 2017/3/1.
 * @author Qi Xia
 * @version 0.1
 *
 * this class is the Campaign
 */
public class Campaign {

    private String name;

    /**
     * this method is to get name
     * @return
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

//    public final static String VALIDATION_ERROR_ID_OUT_OF_RANGE = "A map is linked to no where";
//    public final static String VALIDATION_ERROR_CYCLE = "Cycle is not allowed in the map";
//    public final static String VALIDATION_ERROR_USELESS_MAP = "Some map is not used in this campaign";

//    public String validate(){
//        // if no connection
//        if (connections.size() == 0) {
//            return VALIDATION_ERROR_NO_MAP;
//        }
//
//        LinkedList<Integer> pendingIds = new LinkedList<>();
//        LinkedList<Integer> visitedIds = new LinkedList<>();
//
//        pendingIds.addLast(1);
//
//        while (pendingIds.size() > 0) {
//            int id = pendingIds.removeFirst();
//            visitedIds.addLast(id);
//
//            int targetId = getConnection(id).getTargetId();
//
//            //  if id out of range
//            if (targetId < 0 || targetId > connections.size()) {
//                return VALIDATION_ERROR_ID_OUT_OF_RANGE;
//            }
//
//            //  if pending or visited, cycle detected
//            if (pendingIds.contains(targetId) || visitedIds.contains(targetId)){
//                return VALIDATION_ERROR_CYCLE;
//            }
//
//
//            if (targetId == 0) {
//                break;
//            }
//
//            pendingIds.addLast(targetId);
//        }
//
//        //  if ends early, some maps are not reached
//        if (visitedIds.size() != connections.size()) {
//            return VALIDATION_ERROR_USELESS_MAP;
//        }
//
//        return VALIDATION_SUCCESS;
//    }
}
