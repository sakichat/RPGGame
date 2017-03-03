package logic;

import com.google.gson.annotations.Expose;

import java.util.Observable;

/**
 * Created by Saki on 2017/2/23.
 * @author Qi Xia
 * @version 0.1
 *
 * this is the cell class
 */
public abstract class Cell extends Observable{

    public Cell() {

    }

    @Expose
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

    @Expose
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