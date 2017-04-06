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
    private String enchantmentName;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getEnchantmentName() {
        return enchantmentName;
    }

    public void setEnchantmentName(String enchantmentName) {
        this.enchantmentName = enchantmentName;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(0xF4F4F4));
        g.drawRect(0, 0, 40, 5);

        ImageIcon enchantmentImageView = new ImageIcon("data/images/" + getEnchantmentName());
        g.drawImage(enchantmentImageView.getImage(), 0, 0, null);

        ImageIcon playerImageView = new ImageIcon("data/images/" + getName());
        g.drawImage(playerImageView.getImage(), 0, 0, null);

    }
}
