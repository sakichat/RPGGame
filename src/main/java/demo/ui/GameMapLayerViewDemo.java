package demo.ui;

import logic.Point;
import ui.view.GameMapLayerView;
import ui.view.ImageView;
import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Penelope on 17/3/1.
 */
public class GameMapLayerViewDemo extends JFrame{
    public static void main(String[] args) {
        GameMapLayerViewDemo gameMapLayerViewDemo = new GameMapLayerViewDemo();
        gameMapLayerViewDemo.setSize(800, 800);
        gameMapLayerViewDemo.setVisible(true);
    }

    public GameMapLayerViewDemo() {
        setLayout(null);

        GameMapLayerView gameMapLayerView = new GameMapLayerView();
        gameMapLayerView.setGridWidth(10);
        gameMapLayerView.setGridHeight(8);
        gameMapLayerView.setLocation(0, 0);
        this.add(gameMapLayerView);

//        for (int i = 0; i < gameMapLayerView.getHeight(); i++) {
//            for (int j = 0; j < gameMapLayerView.getWidth(); j++) {
//
//                View view = new View();
//                view.setSize(40, 40);
//                view.setBackground(new Color(000000));


//                ImageView imageView = new ImageView();
//                imageView.setName("grass_background.png");
//                gameMapLayerView.addCell(view, new Point(j, i));

//            }

//        }

//        ImageView selected = new ImageView();
//        selected.setName("grass_background.png");
//        gameMapLayerView.addCell(selected, new Point(1, 1));

        this.repaint();
    }
}
