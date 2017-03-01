package map;

/**
 * Created by Saki on 2017/3/1.
 */
public class MapConnection {
    private int id;
    private GameMap map;
    private int targetId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
}
