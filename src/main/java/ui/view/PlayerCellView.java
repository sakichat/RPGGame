package ui.view;

import logic.effect.Effect;
import logic.effect.EffectBurning;
import logic.effect.EffectFreezing;
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

    private int showInHpBar() {
        double hpPercentage = (double)player.getHp() / (double)player.getTotalHp();
        int hpQuantity = (int)(hpPercentage * 40);

        return hpQuantity;
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon playerImageView = new ImageIcon("data/images/" + player.getImageName());
        g.drawImage(playerImageView.getImage(), 0, 0, null);

        for (Effect effect : player.getEffects()) {
            if (effect instanceof EffectBurning) {
                ImageIcon imageIcon = new ImageIcon("data/images/" + effect.getImageName());
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            }

            if (effect instanceof EffectFreezing) {
                ImageIcon imageIcon = new ImageIcon("data/images/" + effect.getImageName());
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            }
        }

        g.setColor(new Color(0x32CD32));
        g.fillRect(0, 0, showInHpBar(), 5);

        g.setColor(new Color(0x8B0000));
        g.fillRect(showInHpBar(), 0, 40 - showInHpBar(), 5);

        g.setColor(new Color(0x000000));
        g.drawRect(0, 0, 40, 5);

    }
}
