package demo.ui;

import map.Point;
import ui.view.GameMapLayerView;
import ui.view.ImageView;

import javax.swing.*;

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
        gameMapLayerView.setGridSize(16);
        gameMapLayerView.setLocation(0, 0);
        this.add(gameMapLayerView);


        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {

                ImageView imageView = new ImageView();
                imageView.setName("four_direction_road.png");
                gameMapLayerView.addCell(imageView, new Point(j, i));

            }

        }

        this.repaint();
    }
}
