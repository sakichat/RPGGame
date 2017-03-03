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



        for (int i = 0; i < gameMapLayerView.getGridSize(); i++) {
            for (int j = 0; j < gameMapLayerView.getGridSize(); j++) {

                ImageView imageView = new ImageView();
                imageView.setName("grass_background.png");
                gameMapLayerView.addCell(imageView, new Point(j, i));

            }

        }

        ImageView selected = new ImageView();
        selected.setName("selected.png");
        gameMapLayerView.addCell(selected, new Point(1, 1));

        this.repaint();
    }
}
