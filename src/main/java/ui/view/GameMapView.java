package ui.view;

import logic.Cell;
import logic.GameMap;
import logic.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

/**
 * This GameMapView class extends View class, and it can build map views.
 * It contains four map layers: Background Layer for the basic map cells; Content Layer for adding items on map;
 * Highlight Layer for showing the selected cell; Event Layer for triggering the event on cell.
 * These four map layers are saved in a List<> for getting it easily.
 * @author Siyu Chen
 * @version 0.1
 */
public class GameMapView extends View {

    /**
     * It is a implements for Delegate
     */
    public interface Delegate {
        void gameMapViewSelect(GameMapView gameMapView, Point location);
    }

    /**
     * This is a property for delegate
     */
    private Delegate delegate;

    /**
     * getter
     * @return Delegate
     */
    public Delegate getDelegate() {
        return delegate;
    }

    /**
     * setter
     * @param delegate
     */
    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    /**
     * This is a property for GameMap
     */
    private GameMap gameMap;

    /**
     * getter
     * @return GameMap
     */
    public GameMap getGameMap() {
        return gameMap;
    }


    /**
     * This is a method to set GameMap property, and it calls setup() method.
     * @param gameMap
     */
    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
        setup();
    }

    /**
     * This method is to set the size of this GameMapView, and to call initLayers() method.
     */
    private void setup(){
        this.setSize(gameMap.getWidth() * GameMapLayerView.UNIT_SIZE, gameMap.getHeight() * GameMapLayerView.UNIT_SIZE);
        initLayers();
    }

    private final static int _LAYER_BACKGROUND  = 0;
    private final static int _LAYER_CONTENT     = 1;
    private final static int _LAYER_HIGHLIGHT   = 2;
    private final static int _LAYER_EVENT       = 3;


    /**
     * This List<GameMapLayerView> is to save the four layers in a LinkedList<>
     */
    private List<GameMapLayerView> layers = new LinkedList<>();


    /**
     * This method is to call the methods for the four layers.
     */
    private void initLayers() {
        initBackgroundLayer();
        initContentLayer();
        initHighlightLayer();
        initEventLayer();
    }

    /**
     * This method is to create a new GameMapLayerView for each layer.
     */
    private void newLayer(){
        GameMapLayerView gameMapLayerView = new GameMapLayerView();
        gameMapLayerView.setLocation(0, 0);
        gameMapLayerView.setGridWidth(gameMap.getWidth());
        gameMapLayerView.setGridHeight(gameMap.getHeight());
        add(gameMapLayerView);
        layers.add(gameMapLayerView);
    }


    /**
     * This method is to create the Background Layer, and calls ImageView to draw the background on the map.
     */
    private void initBackgroundLayer() {
        newLayer();
        GameMapLayerView layerView = layers.get(_LAYER_BACKGROUND);

        for (int i = 0; i < gameMap.getWidth(); i++) {
            for (int j = 0; j < gameMap.getHeight(); j++) {
                ImageView backgroundView = new ImageView();
                backgroundView.setName("grass_background.png");
                layerView.addCell(backgroundView, new Point(j, i));
            }
        }

    }

    /**
     * This method is to create the Content Layer,
     * and calls refreshContent() method to paint the layer for placing items.
     */
    private void initContentLayer(){
        newLayer();
        refreshContent();
    }

    /**
     * The selectedLocation property is for location of the cell which has been chosen.
     */
    private Point selectedLocation;


    /**
     * This method is for classes to get the location of the selected cell
     * @return selectedLocation
     */
    public Point getSelectedLocation() {
        return selectedLocation;
    }

    /**
     * This property is for a new ImageView
     */
    private ImageView selectionView;

    /**
     * This method is to show the selected cell on this layer
     */
    private void initHighlightLayer(){
        newLayer();
        GameMapLayerView layerView = layers.get(_LAYER_HIGHLIGHT);

        selectedLocation = new Point(0, 0);
        selectionView = new ImageView();
        selectionView.setName("selected.png");
        layerView.addCell(selectionView, selectedLocation);
    }

    /**
     * This method adds an event if a cell is pressed and to get the location of this cell
     */
    private void initEventLayer(){
        newLayer();
        GameMapLayerView layerView = layers.get(_LAYER_EVENT);

        int gridWidth = gameMap.getWidth();
        int gridHeight = gameMap.getHeight();

        for (int y = 0; y < gridWidth; y++) {
            for (int x = 0; x < gridHeight; x++) {
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

    /**
     * This method gets location from the Event layer and pass the parameter to Highlight layer.
     * So that it can draw the selected cell on Highlight layer.
     * @param location
     */
    private void cellPressed(Point location){
        GameMapLayerView layerView = layers.get(_LAYER_HIGHLIGHT);
        layerView.moveCell(selectedLocation, location);
        selectedLocation = location;
        repaint();

        delegate.gameMapViewSelect(this, location);
    }

    /**
     * This method refreshes the Content layer when it occurs some event on that,
     * for example, add a new cell view, remove a cell view, or move a cell view, etc.
     */
    public void refreshContent(){
        GameMapLayerView layerView = layers.get(_LAYER_CONTENT);
        layerView.removeAllCells();

        int gridWidth = gameMap.getWidth();
        int gridHeight = gameMap.getHeight();

        for (int y = 0; y < gridWidth; y++) {
            for (int x = 0; x < gridHeight; x++) {
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
