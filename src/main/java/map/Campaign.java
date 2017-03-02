package map;

import java.util.LinkedList;

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
        MapConnection connection = connections.get(id - 1);
        return connection;
    }

    public boolean validate(){

        // if no connection
        if (connections.size() == 0) {
            return false;
        }

        LinkedList<Integer> pendingIds = new LinkedList<>();
        LinkedList<Integer> visitedIds = new LinkedList<>();

        pendingIds.addLast(1);

        while (pendingIds.size() > 0) {
            int id = pendingIds.removeFirst();
            int targetId = getConnection(id).getTargetId();

            //  if id out of range
            if (targetId < 0 || targetId >= connections.size()) {
                return false;
            }

            //  if pending or visited, cycle detected
            if (pendingIds.contains(targetId) || visitedIds.contains(targetId)){
                return false;
            }

            visitedIds.addLast(id);

            if (targetId == 0) {
                break;
            }

            pendingIds.addLast(targetId);
        }

        //  if ends early, some maps are not reached
        if (visitedIds.size() != connections.size()) {
            return false;
        }

        return true;
    }
}
