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

        return true;
    }
}
