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

    public boolean mapValidatorConnection(){
        int[] check = {2, 3, 4, 5, 0};

        for (MapConnection connection : connections) {
            for (int i = 0; i < 5; i++) {
                if (connection.getTargetId() == check[i]){
                    check[i] = 1;
                }
            }
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
