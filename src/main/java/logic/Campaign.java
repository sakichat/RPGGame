package logic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Saki on 2017/3/1.
 */
public class Campaign {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<String> mapNames = new LinkedList<>();

    public List<String> getMapNames() {
        return mapNames;
    }

    public String getMapName(int index) {
        return mapNames.get(index);
    }

    public void addMapName(String mapName) {
        mapNames.add(mapName);
    }

    public void removeMapName(int index) {
        mapNames.remove(index);
    }

    public final static String VALIDATION_SUCCESS = "Valid";
    public final static String VALIDATION_ERROR_NO_MAP = "No map";

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
