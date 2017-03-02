package map;

import java.util.Observable;

/**
 * Created by Saki on 2017/2/23.
 */
public abstract class Cell extends Observable{
    protected Point location;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}