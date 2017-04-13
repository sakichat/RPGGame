package ui.view;

import logic.BaseUpdate;
import logic.Play;
import logic.PlayRuntime;
import logic.map.Cell;
import logic.map.GameMap;
import logic.map.Point;
import logic.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This GameMapView class extends View class, and it can build map views.
 * It contains four map layers: Background Layer for the basic map cells; Content Layer for adding items on map;
 * Target Layer for showing the selected cell; Event Layer for triggering the event on cell.
 * These four map layers are saved in a List<> for getting it easily.
 * @author Siyu Chen
 * @version 0.2
 */
public class GameMapView extends View implements Observer {


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
        if (this.gameMap != null) {
            this.gameMap.deleteObserver(this);
        }
        this.gameMap = gameMap;
        setup();
        gameMap.addObserver(this);
    }


    /**
     * This method is to set the size of this GameMapView, and to call initLayers() method.
     */
    private void setup(){
        this.setSize(getPreferredSize());
        initLayers();
    }


    /**
     * This getPreferredSize() function sets size for maps and map layers.
     * @return Dimension
     */
    public Dimension getPreferredSize(){
        return new Dimension(
                gameMap.getWidth() * GameMapLayerView.UNIT_SIZE,
                gameMap.getHeight() * GameMapLayerView.UNIT_SIZE);
    }

    private final static int _LAYER_BACKGROUND      = 0;
    private final static int _LAYER_RANGE           = 1;
    private final static int _LAYER_CONTENT         = 2;
    private final static int _LAYER_CURRENT         = 3;
    private final static int _LAYER_TARGET          = 4;
    private final static int _LAYER_EVENT           = 5;


    /**
     * This List<GameMapLayerView> is to save the four layers in a LinkedList<>
     */
    private List<GameMapLayerView> layers = new LinkedList<>();


    /**
     * This method is to call the methods for the four layers.
     */
    private void initLayers() {
        initBackgroundLayer();
        initRangeLayer();
        initContentLayer();
        initCurrentLayer();
        initTargetLayer();
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
        gameMapLayerView.setSize(getPreferredSize());
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
                layerView.addCell(backgroundView, new Point(i, j));
            }
        }

    }

    /**
     * This method creates a layer for showing attack range of players.
     */
    private void initRangeLayer() {
        newLayer();
        refreshRange();
    }

    /**
     * This method is to create the Content Layer,
     * and calls refreshContent() method to paint the layer for placing items.
     */
    private void initContentLayer(){
        newLayer();
        refreshContent();
    }


    private void initCurrentLayer() {
        newLayer();
        refreshCurrentLayer();
    }

    /**
     * This property is for a new ImageView
     */
    private ImageView selectionView;

    /**
     * This method is to show the selected cell on this layer
     */
    private void initTargetLayer(){
        newLayer();
        refreshTargetLayer();

    }


    /**
     * This method adds an event if a cell is pressed and to get the location of this cell
     */
    private void initEventLayer(){
        newLayer();
        GameMapLayerView layerView = layers.get(_LAYER_EVENT);

        int gridWidth = gameMap.getWidth();
        int gridHeight = gameMap.getHeight();

        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
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
     * This method gets location from the Event layer and pass the parameter to Target layer.
     * So that it can draw the selected cell on Target layer.
     * @param location
     */
    private void cellPressed(Point location){
        PlayRuntime.currentRuntime().getPlay().setTargetLocation(location);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (BaseUpdate.when(arg)
                .match(GameMap.Update.CELL)
                .check()) {
            SwingUtilities.invokeLater(this::refreshContent);

        } else if (BaseUpdate.when(arg)
                .match(Play.Update.RANGE)
                .check()) {
            SwingUtilities.invokeLater(this::refreshRange);

        } else if (BaseUpdate.when(arg)
                .match(Play.Update.TARGET)
                .check()) {
            SwingUtilities.invokeLater(this::refreshTargetLayer);
        }
    }


    /**
     * This method refreshes RangeLayer.
     */
    public void refreshRange(){
        GameMapLayerView layerView = layers.get(_LAYER_RANGE);
        layerView.removeAllCells();

        Play play = PlayRuntime.currentRuntime().getPlay();
        if (play.isRangeIndicationEnabled()) {
            play.getRangeIndicationLocations().forEach(point -> {
                ImageView imageView = new ImageView();
                imageView.setName(play.getRangeIndicationMode().getImageName());
                layerView.addCell(imageView, point);
            });
        }
        repaint();
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

        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                Point location = new Point(x, y);
                Cell cell = gameMap.getCell(location);
                if (cell instanceof Player) {
                    PlayerCellView playerCellView = new PlayerCellView();
                    playerCellView.setPlayer((Player) cell);
                    layerView.addCell(playerCellView, location);
                }else if (cell != null) {
                    ImageView imageView = new ImageView();
                    imageView.setName(cell.getImageName());
                    layerView.addCell(imageView, location);
                }
            }
        }

        repaint();
    }

    private void refreshCurrentLayer() {
        GameMapLayerView layerView = layers.get(_LAYER_CURRENT);

        Player mainPlayer = PlayRuntime.currentRuntime().getMainPlayer();
        if (mainPlayer != null) {
            Point location = mainPlayer.getLocation();
            ImageView imageView = new ImageView();
            imageView.setName("selected_current.png");
            layerView.addCell(imageView, location);
        }
        repaint();
    }

    private void refreshTargetLayer() {
        GameMapLayerView layerView = layers.get(_LAYER_TARGET);
        layerView.removeAllCells();

        Play play = PlayRuntime.currentRuntime().getPlay();
        if (play.isTargetLocationEnabled()) {
            Point targetLocation = PlayRuntime.currentRuntime().getPlay().getTargetLocation();
            ImageView imageView = new ImageView();
            imageView.setName("selected_target.png");
            layerView.addCell(imageView, targetLocation);
        }

        repaint();
    }
}
