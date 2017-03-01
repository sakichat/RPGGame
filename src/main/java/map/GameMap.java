package map;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Saki on 2017/2/20.
 */
public class GameMap {
    private String name;
    private int size;
    private Cell[][] cells = new Cell[size][size];

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        Cell cell = new Cell();
        Point location = new Point();
        addCell(cell , location);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameMap() {
    }

    public GameMap(int size, Cell[][] cells, String name) {
        this.size = size;
        this.cells = cells;
        this.name = name;
    }

    public void addCell(Cell cell, Point location){
        int x = location.getX();
        int y = location.getY();
        cells[x][y] = cell;
    }

    public void removeCell(Point location){ //传参？
        int x = location.getX();
        int y = location.getY();
        cells[x][y] = null;
    }

    public Cell getCell(Point location){

        Cell cell;

        int x = location.getX();
        int y = location.getY();
        cell = cells[x][y];

        return cell;
    }

    public boolean hasCell(Point location){

        if(getCell(location) != null){
            return true;
        }

        return false;
    }

    public void moveCell(Point startPoint, Point endPoint){

        int startX = startPoint.getX();
        int startY = startPoint.getY();
        int endX = endPoint.getX();
        int endY = endPoint.getY();

        Cell cell = cells[startX][startY];
        cells[startX][startY] = null;
        cells[endX][endY] = cell;
    }

    public LinkedList<Entrance> getEntrances(){
        LinkedList<Entrance> entrances = new LinkedList<>();
        Cell entranceCell;
        Entrance entrancePoint;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] instanceof Entrance){
                    entranceCell = cells[i][j];
                    entrancePoint = (Entrance) entranceCell;
                    entrances.add(entrancePoint);
                }
            }
        }

        return entrances;
    }

    public LinkedList<Exit> getExits() {
        LinkedList<Exit> exits = new LinkedList<>();
        Cell exitCell;
        Exit exitPoint;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] instanceof Entrance){
                    exitCell = cells[i][j];
                    exitPoint = (Exit) exitCell;
                    exits.add(exitPoint);
                }
            }
        }

        return exits;
    }
}
