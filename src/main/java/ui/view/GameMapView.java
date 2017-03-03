package ui.view;

import logic.Cell;
import logic.GameMap;
import logic.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Penelope on 17/3/2.
 */
public class GameMapView extends View {

    public interface Delegate {
        void gameMapViewSelect(GameMapView gameMapView, Point location);
    }

    private Delegate delegate;

    public Delegate getDelegate() {
        return delegate;
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

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

    private final static int _LAYER_BACKGROUND  = 0;
    private final static int _LAYER_CONTENT     = 1;
    private final static int _LAYER_HIGHLIGHT   = 2;
    private final static int _LAYER_EVENT       = 3;

    private List<GameMapLayerView> layers = new LinkedList<>();

    private void initLayers() {
        initBackgroundLayer();
        initContentLayer();
        initHighlightLayer();
        initEventLayer();
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
        refreshContent();
    }

    private Point selectedLocation;

    public Point getSelectedLocation() {
        return selectedLocation;
    }

    private ImageView selectionView;

    private void initHighlightLayer(){
        newLayer();
        GameMapLayerView layerView = layers.get(_LAYER_HIGHLIGHT);

        selectedLocation = new Point(0, 0);
        selectionView = new ImageView();
        selectionView.setName("selected.png");
        layerView.addCell(selectionView, selectedLocation);

    }

    private void initEventLayer(){
        newLayer();
        GameMapLayerView layerView = layers.get(_LAYER_EVENT);
        int size = gameMap.getSize();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Point location = new Point(x, y);
                GlassView glassView = new GlassView();
                layerView.addCell(glassView, location);

                glassView.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        cellPressed(location);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }
        }
    }

    private void cellPressed(Point location){
        GameMapLayerView layerView = layers.get(_LAYER_HIGHLIGHT);
        layerView.moveCell(selectedLocation, location);
        selectedLocation = location;
        repaint();

        delegate.gameMapViewSelect(this, location);
    }

    public void refreshContent(){
        GameMapLayerView layerView = layers.get(_LAYER_CONTENT);
        layerView.removeAllCells();

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

        repaint();
    }
}
