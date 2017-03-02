package map;

import java.util.LinkedList;

/**
 * Created by Saki on 2017/3/1.
 */
public class Campaign {
    private String name;
    private LinkedList<MapConnection> connections = new LinkedList<>();

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

    public boolean mapValidatorConnection(){
        LinkedList<Integer> visited = new LinkedList<>();
        for (MapConnection connection : connections) {
            if (!visited.contains(connection.getTargetId())){
                visited.add(connection.getTargetId());
            }
        }

        if (visited.size() == connections.size() && mapContainsCircle(visited) == true){
            return true;
        }

        return false;
    }

    private boolean mapContainsCircle(LinkedList<Integer> visited){

        for (int i = 0; i < visited.size() - 1; i++) {
            if (visited.getLast() == visited.get(i)){
                return false;
            }
        }
        return true;
    }
}
