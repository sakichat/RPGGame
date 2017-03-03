package ui.view;

import map.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Penelope on 17/3/2.
 */
public class GameMapView extends View {
    private GameMap gameMap;

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
        setup();
    }

    private void setup(){
        this.setSize(gameMap.getSize() * GameMapLayerView.UNIT_SIZE, gameMap.getSize() * GameMapLayerView.UNIT_SIZE);
        initLayers();
    }

    private final static int _LAYER_BACKGROUND = 0;
    private final static int _LAYER_CONTENT = 1;

    private List<GameMapLayerView> layers = new LinkedList<>();

    private void initLayers() {
        initBackgroundLayer();
        initContentLayer();
    }

    private void newLayer(){
        GameMapLayerView gameMapLayerView = new GameMapLayerView();
        gameMapLayerView.setLocation(0, 0);
        gameMapLayerView.setGridSize(gameMap.getSize());
        add(gameMapLayerView);
        layers.add(gameMapLayerView);
    }

    private void initBackgroundLayer() {
        newLayer();
        GameMapLayerView layerView = layers.get(_LAYER_BACKGROUND);

        for (int i = 0; i < gameMap.getSize(); i++) {
            for (int j = 0; j < gameMap.getSize(); j++) {
                ImageView backgroundView = new ImageView();
                backgroundView.setName("grass_background.png");
                layerView.addCell(backgroundView, new Point(j, i));
            }
        }
    }

    private void initContentLayer(){
        newLayer();
        GameMapLayerView layerView = layers.get(_LAYER_CONTENT);
        int size = gameMap.getSize();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Point location = new Point(x, y);
                Cell cell = gameMap.getCell(location);
                if (cell != null) {
                    ImageView imageView = new ImageView();
                    imageView.setName(cell.getImageName());
                    layerView.addCell(imageView, location);
                }
            }
        }
    }


}
