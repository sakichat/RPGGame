package map;

/**
 * Created by Saki on 2017/2/20.
 */
public abstract class MapValidator {
    protected GameMap gameMap;

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public abstract boolean validate();
}
