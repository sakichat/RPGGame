package logic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Saki on 2017/3/1.
 */
public class Campaign {
    private String name;
    private LinkedList<MapConnection> connections = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addConnection(String name){
        MapConnection connection = new MapConnection();
        connection.setMapName(name);
        connections.add(connection);

        connection.setId(connections.size());
    }

    public void removeConnection(int id){
        connections.remove(id - 1);
    }

    public MapConnection getConnection(int id){
        return connections.get(id - 1);
    }

    public List<MapConnection> getConnections() {
        return connections;
    }

    public final static String VALIDATION_SUCCESS = "Valid";
    public final static String VALIDATION_ERROR_NO_MAP = "No map";
    public final static String VALIDATION_ERROR_ID_OUT_OF_RANGE = "A map is linked to no where";
    public final static String VALIDATION_ERROR_CYCLE = "Cycle is not allowed in the map";
    public final static String VALIDATION_ERROR_USELESS_MAP = "Some map is not used in this campaign";

    public String validate(){
        // if no connection
        if (connections.size() == 0) {
            return VALIDATION_ERROR_NO_MAP;
        }

        LinkedList<Integer> pendingIds = new LinkedList<>();
        LinkedList<Integer> visitedIds = new LinkedList<>();

        pendingIds.addLast(1);

        while (pendingIds.size() > 0) {
            int id = pendingIds.removeFirst();
            visitedIds.addLast(id);

            int targetId = getConnection(id).getTargetId();

            //  if id out of range
            if (targetId < 0 || targetId > connections.size()) {
                return VALIDATION_ERROR_ID_OUT_OF_RANGE;
            }

            //  if pending or visited, cycle detected
            if (pendingIds.contains(targetId) || visitedIds.contains(targetId)){
                return VALIDATION_ERROR_CYCLE;
            }


            if (targetId == 0) {
                break;
            }

            pendingIds.addLast(targetId);
        }

        //  if ends early, some maps are not reached
        if (visitedIds.size() != connections.size()) {
            return VALIDATION_ERROR_USELESS_MAP;
        }

        return VALIDATION_SUCCESS;
    }
}
