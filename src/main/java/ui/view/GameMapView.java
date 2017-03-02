package ui.view;

import map.GameMap;

import java.util.List;

/**
 * Created by Penelope on 17/3/2.
 */
public class GameMapView extends View {
    private GameMap gameMap;
    private List<GameMapLayerView> layers;

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;

    }

    private final static int _LAYER_BACKGROUND = 0;

    private void initBackground() {

    }

    private void initLayers() {

    }

}
