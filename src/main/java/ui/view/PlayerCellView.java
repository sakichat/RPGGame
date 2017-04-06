package ui.view;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Penelope on 2017-04-01.
 */
public class PlayerCellView extends View{
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(0xF4F4F4));
        g.drawRect(0, 0, 40, 5);

        ImageIcon playerImageView = new ImageIcon("data/images/" + getName());

        ImageIcon burningImageView = new ImageIcon("data/images/burning.png");

        ImageIcon freezingImageView = new ImageIcon("data/images/freezing.png");

    }
}
