package ui.view;

import logic.map.Point;

import java.awt.*;

/**
 * This class is for building a layer on game map which extends View.
 * @author Siyu Chen
 * @version 0.2
 */
public class GameMapLayerView extends View {

    public final static int UNIT_SIZE = 40;

    /**
     * This method is to set the default background of a layer view to transparent
     * in order to show several different layers in the same time on a map view.
     */
    public GameMapLayerView(){
        setBackground(new Color(0, 0, 0, Color.TRANSLUCENT));
    }

    /**
     * These two parameters are the size of a game map and a double dimension array to save cell views respectively.
     */
    private int gridWidth;
    private int gridHeight;
    private View[][] cells;

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;

        cells = new View[gridHeight][gridWidth];
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;

        cells = new View[gridHeight][gridWidth];
    }


    /**
     * This method is to add a cell on GameMapView
     * @param cell
     * @param location
     */
    public void addCell(View cell, Point location) {
        int x = location.getX();
        int y = location.getY();
        cells[y][x] = cell;
        cell.setLocation(x * UNIT_SIZE, y * UNIT_SIZE);
        cell.setSize(UNIT_SIZE, UNIT_SIZE);
        this.add(cell);
    }

    /**
     * This method is to remove a cell from GameMapView
     * @param location
     */
    public void removeCell(Point location) {
        int x = location.getX();
        int y = location.getY();

        this.remove(getCell(location));
        cells[y][x] = null;
    }

    /**
     * This method is to get a location of a specific cell
     * @param location
     * @return cells[y][x]
     */
    public View getCell(Point location) {
        int x = location.getX();
        int y = location.getY();

        return cells[y][x];
    }

    /**
     * This method is to move a cell from a specific location to another one
     * @param from
     * @param to
     */
    public void moveCell(Point from, Point to) {
        View cell = getCell(from);
        removeCell(from);
        addCell(cell, to);
    }

    /**
     * This function is to clear the whole GameMapViewLayer in order to add new items on that
     */
    public void removeAllCells(){
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                Point point = new Point(x, y);
                View cell = getCell(point);
                if (cell != null) {
                    removeCell(point);
                }
            }
        }
    }

}
