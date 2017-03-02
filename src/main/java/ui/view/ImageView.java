package ui.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Penelope on 17/3/1.
 */
public class ImageView extends View {
    public ImageView() {
        setSize(40, 40);
    }

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
        super.paint(g);

        ImageIcon image = new ImageIcon("data/images/" + name);
        g.drawImage(image.getImage(), 40, 40, null);
    }
}
