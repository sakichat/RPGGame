package logic.map;

import com.google.gson.annotations.Expose;

import java.util.Observable;

/**
 * @author Qi Xia
 * @version 0.2
 *
 * this is the cell class
 */
public class Cell extends Observable{

    public static enum Type {
        PLAYER, CHEST, OBSTACLE, ENTRANCE, EXIT
    }

    public Type getCellType(){
        // TODO: 06/04/2017
        return null;
    }

    /**
     * this is the constructor
     */
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