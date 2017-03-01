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
    }

    public void removeCell(Point location){
        int x = location.getX();
        int y = location.getY();
        cells[y][x] = null;
    }

    public Cell getCell(Point location){

        Cell cell;

        int x = location.getX();
        int y = location.getY();
        cell = cells[y][x];

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
        cells[startY][startX] = null;
        cells[endY][endX] = cell;
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
