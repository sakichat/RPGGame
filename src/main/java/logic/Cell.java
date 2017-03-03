package logic;

import java.util.Observable;

/**
 * Created by Saki on 2017/2/23.
 * this is the cell class
 */
public abstract class Cell extends Observable{
    protected Point location;

    /**
     * this method is to get Location
     * @return Point
     */
    public Point getLocation() {
        return location;
    }

    /**
     * this method is to set Location
     * @param location Point
     */

    public void setLocation(Point location) {
        this.location = location;
    }

    protected String imageName;

    /**
     * this method  is to get name of image
     * @return String
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * this method is to set name of image
     * @param imageName String
     */

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}