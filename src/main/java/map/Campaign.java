package map;

import java.util.LinkedList;

/**
 * Created by Saki on 2017/3/1.
 */
public class Campaign {
    private String name;
    private LinkedList<MapConnection> connections = new LinkedList<>();

    public void addConnection(GameMap map){
        MapConnection connection = new MapConnection();
        connection.setMap(map);
        connections.add(connection);

        connection.setId(connections.size());
        connection.setTargetId(connections.size() + 1);
    }

    public void removeConnection(int id){
        connections.remove(id);
    }

    public MapConnection getConnection(int id){
        MapConnection connection = connections.get(id);
        return connection;
    }

    public boolean validate(){
        return true;
    }
}
