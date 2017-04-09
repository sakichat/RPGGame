package ui.view;

import logic.player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Penelope on 2017-04-01.
 */
public class PlayerCellView extends View implements Observer{
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        player.addObserver(this);
    }

    @Override
    public void update(Observable o, Object x) {
        if (x.equals(Player.HP_CHANGE)) {
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(0xDB2C5A));
        g.fillRect(0, 0, getPlayer().getTotalHp(), 5);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(getPlayer().getTotalHp(), 0, 40 - getPlayer().getTotalHp(), 5);

        g.setColor(new Color(0xF4F4F4));
        g.drawRect(0, 0, 40, 5);

        ImageIcon effectImageView = new ImageIcon("data/images/" + getPlayer().getEffects());
        g.drawImage(effectImageView.getImage(), 0, 0, null);

        ImageIcon playerImageView = new ImageIcon("data/images/" + getPlayer().getImageName());
        g.drawImage(playerImageView.getImage(), 0, 0, null);

    }
}
