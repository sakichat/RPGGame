package map;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Saki on 2017/2/20.
 */
public class GameMap {
    private int size;
    private Cell[][] cells = new Cell[size][size];
    private String name;
    private Point exitPoint;
    private Point enterPoint;

    public GameMap() {
    }

    public GameMap(int size, Cell[][] cells, String name) {
        this.size = size;
        this.cells = cells;
        this.name = name;
    }

    public void addContent(Content content, Point location){
        int x = location.getX();
        int y = location.getY();
        cells[x][y].content = content;
    }

    public void removeContent(Point location){
        int x = location.getX();
        int y = location.getY();
        cells[x][y].content = null;
    }

    public Content getContent(Point location){
        Content content;

        int x = location.getX();
        int y = location.getY();
        content = cells[x][y].content;

        return content;
    }

    public boolean hasContent(Point location){
        int x = location.getX();
        int y = location.getY();

        if(cells[x][y].content != null){
            return true;
        }

        return false;
    }

    public Cell getCell(Point location){
        Cell cell;

        int x = location.getX();
        int y = location.getY();

        cell = cells[x][y];

        return cell;
    }

    public List bfsSearch(Point source, int depth){
        LinkedList<Cell> searchCell = new LinkedList<>();

        int x = source.getX();
        int y = source.getY();

        searchCell.add(cells[x][y]);

        Queue<Point> searchResult = new LinkedList<>();

        LinkedList<Point> neighbour;
        neighbour = source.directions();
        for (int i = 0; i < 4; i++) {
            int neiX = neighbour.get(i).getX();
            int neiY = neighbour.get(i).getY();
            searchResult.add(neighbour.get(i));
            searchCell.add(cells[neiX][neiY]);
            neighbour.clear();
        }

        if(depth == 0){
            while(searchResult != null){
                Point newSource = searchResult.poll();
                neighbour = newSource.directions();
                for (int i = 0; i < neighbour.size(); i++) {
                    int neiX = neighbour.get(i).getX();
                    int neiY = neighbour.get(i).getY();
                    if(cells[neiX][neiY].content == null){
                        for (Cell cell : searchCell) {
                            if(!cells[neiX][neiY].equals(cell)){
                                searchResult.add(neighbour.get(i));
                                searchCell.add(cells[neiX][neiY]);
                            }
                        }
                    }
                }
                neighbour.clear();
            }
        }else{
            for (int i = 0; i < depth - 1; i++) {
                if(searchResult != null){
                    Point newSource = searchResult.poll();
                    neighbour = newSource.directions();
                    for (int j = 0; j < 4; j++) {
                        int neiX = neighbour.get(j).getX();
                        int neiY = neighbour.get(j).getY();
                        if(cells[neiX][neiY].content == null){
                            searchResult.add(neighbour.get(j));
                            searchCell.add(cells[neiX][neiY]);
                            neighbour.clear();
                        }
                    }
                }
            }
        }

        return searchCell;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getExitPoint() {
        return exitPoint;
    }

    public Point getEnterPoint() {
        return enterPoint;
    }
}
