package ui.scene;

import logic.GameMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a MapCreationScene to show the scene for creating map name which extends Scene class
 * @author Siyu Chen
 * @version 0.1
 */
public class MapCreationScene extends Scene {
    private int size;

    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        title = "Create Map";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    /**
     * This method creates components on the main scene
     * And adds events on backButton and createButton
     */
    protected void initSubviews() {

        JLabel label;
        JButton button;

        label = new JLabel("Name", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 20);
        contentView.add(label);
        JLabel mapName = label;

        JTextField nameField = new JTextField();
        nameField.setSize(160, 40);
        nameField.setLocation(150, 20);
        contentView.add(nameField);

        label = new JLabel("Size", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 70);
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setLocation(150, 70);
        label.setText("4 x 4");
        contentView.add(label);
        JLabel sizeLabel = label;
        size = 4;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 120);
        contentView.add(button);
        button.setText("4 x 4");
        JButton smallSize = button;

        smallSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeLabel.setText(smallSize.getText());
                size = 4;

                repaint();
            }
        });

        button = new JButton("8 x 8");
        button.setSize(100, 40);
        button.setLocation(260, 120);
        contentView.add(button);
        JButton mediumSize = button;

        mediumSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeLabel.setText(mediumSize.getText());
                size = 8;

                repaint();
            }
        });


        button = new JButton("12 x 12");
        button.setSize(100, 40);
        button.setLocation(370, 120);
        contentView.add(button);
        JButton largeSize = button;

        largeSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeLabel.setText(largeSize.getText());
                size = 12;

                repaint();
            }
        });

        JButton createButton = new JButton("Create");
        createButton.setSize(160, 40);
        createButton.setLocation(150, 190);
        contentView.add(createButton);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapCreationScene.this.navigationView.pop();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMap gameMap = new GameMap();
                gameMap.setName(nameField.getText());
                gameMap.setSize(size);
                MapEditingScene mapEditingScene = new MapEditingScene();
                mapEditingScene.setGameMap(gameMap);
                MapCreationScene.this.navigationView.push(mapEditingScene);
            }
        });
    }
}
