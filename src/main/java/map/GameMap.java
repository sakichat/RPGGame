package map;

import java.util.LinkedList;

/**
 * Created by Saki on 2017/2/20.
 */
public class GameMap {
    private String name;
    private int size;
    private Cell[][] cells;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        cells = new Cell[size][size];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCell(Cell cell, Point location){
        int x = location.getX();
        int y = location.getY();
        cells[y][x] = cell;

        cell.location = location;
    }

    public void removeCell(Point location){
        int x = location.getX();
        int y = location.getY();
        cells[y][x] = null;
    }

    public Cell getCell(Point location){
        int x = location.getX();
        int y = location.getY();
        return cells[y][x];
    }

    public boolean hasCell(Point location){
        return getCell(location) != null;
    }

    public void moveCell(Point startPoint, Point endPoint){

        int startX = startPoint.getX();
        int startY = startPoint.getY();
        int endX = endPoint.getX();
        int endY = endPoint.getY();

        Cell cell = cells[startX][startY];
        cells[startY][startX] = null;
        cells[endY][endX] = cell;
    }

    public LinkedList<Entrance> getEntrances(){
        LinkedList<Entrance> entrances = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] instanceof Entrance){
                    Cell cell = cells[i][j];
                    Entrance entrance = (Entrance) cell;
                    entrances.add(entrance);
                }
            }
        }

        return entrances;
    }

    public LinkedList<Exit> getExits() {
        LinkedList<Exit> exits = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] instanceof Exit){
                    Cell cell = cells[i][j];
                    Exit exit = (Exit) cell;
                    exits.add(exit);
                }
            }
        }

        return exits;
    }
}
