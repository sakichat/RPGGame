package ui.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Penelope on 17/3/1.
 */
public class ImageView extends View {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon image = new ImageIcon("data/images/" + name);
        g.drawImage(image.getImage(), 0, 0, null);
    }
}
