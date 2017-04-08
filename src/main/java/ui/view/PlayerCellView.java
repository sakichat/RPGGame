package ui.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Penelope on 2017-04-01.
 */
public class PlayerCellView extends View{
    private String name;
    private String effectName;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(0xF4F4F4));
        g.drawRect(0, 0, 40, 5);

        ImageIcon effectImageView = new ImageIcon("data/images/" + getEffectName());
        g.drawImage(effectImageView.getImage(), 0, 0, null);

        ImageIcon playerImageView = new ImageIcon("data/images/" + getName());
        g.drawImage(playerImageView.getImage(), 0, 0, null);

    }
}
