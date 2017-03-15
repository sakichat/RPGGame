package ui.view;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines a ImageView to paint images on cells
 * @author Siyu Chen
 * @version 0.1
 */
public class ImageView extends View {

    /**
     * This property is for the name of a ImageView in order to assign a file name on the image
     */
    private String name;

    /**
     * getter
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * This method sets name of a ImageView and calls repaint() method
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
        repaint();
    }

    /**
     * This method overrides paint() method in its superclass
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        ImageIcon image = new ImageIcon("data/images/" + name);

        g.drawImage(image.getImage(), 0, 0, null);
    }
}
