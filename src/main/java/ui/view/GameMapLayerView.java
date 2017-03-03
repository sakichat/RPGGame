package ui.view;

import logic.Point;

import java.awt.*;

/**
 * This class is for building a layer on game map which extends View.
 * @author Siyu Chen
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
    private int gridSize;
    private View[][] cells;


    /**
     * @return gridSize
     */
    public int getGridSize() {
        return gridSize;
    }

    /**
     * This method is to set gridSize which presents the number of cells on each side of the game map.
     * And using gridSize to set the size of this game map view.
     * @param gridSize
     */
    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;

        cells = new View[gridSize][gridSize];
        setSize(gridSize * UNIT_SIZE, gridSize * UNIT_SIZE);
    }

    /**
     *
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

    public void removeCell(Point location) {
        int x = location.getX();
        int y = location.getY();

        this.remove(getCell(location));
        cells[y][x] = null;
    }

    public View getCell(Point location) {
        int x = location.getX();
        int y = location.getY();

        return cells[y][x];
    }

    public void moveCell(Point from, Point to) {
        View cell = getCell(from);
        removeCell(from);
        addCell(cell, to);
    }

    public void removeAllCells(){
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                Point point = new Point(x, y);
                View cell = getCell(point);
                if (cell != null) {
                    removeCell(point);
                }
            }
        }
    }

}
