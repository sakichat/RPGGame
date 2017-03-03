package ui.view;

import map.Point;

import java.awt.*;

/**
 * Created by Penelope on 17/3/1.
 */
public class GameMapLayerView extends View {

    public final static int UNIT_SIZE = 40;

    public GameMapLayerView(){
        setBackground(new Color(0, 0, 0, Color.TRANSLUCENT));
    }

    private int gridSize;
    private View[][] cells;


    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;

        cells = new View[gridSize][gridSize];
        setSize(gridSize * UNIT_SIZE, gridSize * UNIT_SIZE);
    }



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

}
