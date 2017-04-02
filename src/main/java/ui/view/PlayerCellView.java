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

//    private final static int _WEAPON_EFFECT_VIEW = 0;
//    private final static int _PLAYER_IMAGE_VIEW = 1;
//
//    private List<View> playerCellViews= new LinkedList<>();
//
//    public PlayerCellView() {
//        ImageView imageView = new ImageView();
//        playerCellViews.add(imageView);
//    }

    @Override
    public void paint(Graphics g) {
        ImageIcon playerImageView = new ImageIcon("data/images/" + getName());


    }
}
