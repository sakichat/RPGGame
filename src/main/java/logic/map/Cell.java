package logic.map;

import com.google.gson.annotations.Expose;

import java.util.Observable;

/**
 * @author Qi Xia
 * @version 0.3
 *
 * this is the cell class
 */
public class Cell extends Observable{

    /**
     * This inner class is enum the type.
     */
    public static enum Type {
        PLAYER, CHEST, OBSTACLE, ENTRANCE, EXIT
    }

    /**
     * The method is used to get the cellType.
     * @return
     */
    public Type getCellType(){
        String name = this.getClass().getSimpleName();
        return Type.valueOf(name.toUpperCase());
    }

    /**
     * this is the constructor
     */
    public Cell() {

    }

    /**
     * Property of location
     */
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

    /**
     * Property of imageName.
     */
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