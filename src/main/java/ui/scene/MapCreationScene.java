package ui.scene;

import logic.map.GameMap;

import javax.swing.*;

/**
 * This is a MapCreationScene to show the scene for creating map name which extends Scene class
 * @author Siyu Chen
 * @version 0.2
 */
public class MapCreationScene extends Scene {

    private int gridWidth;
    private int gridHeight;

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
        JTextField textField;

        label = new JLabel("Name", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        textField = new JTextField();
        textField.setSize(160, 40);
        textField.setLocation(150, 20);
        contentView.add(textField);
        JTextField nameField = textField;

        label = new JLabel("Width", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 70);
        contentView.add(label);

        textField = new JTextField();
        textField.setSize(160, 40);
        textField.setLocation(150, 70);
        contentView.add(textField);
        JTextField gridWidthField = textField;

        label = new JLabel("", JLabel.LEFT);
        label.setSize(200, 40);
        label.setLocation(330, 70);
        contentView.add(label);
        JLabel widthCheckLabel = label;

        label = new JLabel("Height", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 120);
        contentView.add(label);

        textField = new JTextField();
        textField.setSize(160, 40);
        textField.setLocation(150, 120);
        contentView.add(textField);
        JTextField gridHeightField = textField;

        label = new JLabel("", JLabel.LEFT);
        label.setSize(200, 40);
        label.setLocation(330, 120);
        contentView.add(label);
        JLabel heightCheckLabel = label;

        JButton createButton = new JButton("Create");
        createButton.setSize(160, 40);
        createButton.setLocation(150, 190);
        contentView.add(createButton);

        repaint();

        backButton.addActionListener(e -> MapCreationScene.this.navigationView.pop());

        createButton.addActionListener(e -> {
            gridWidth = Integer.parseInt(gridWidthField.getText());
            gridHeight = Integer.parseInt(gridHeightField.getText());

            if (gridWidth > 12) {
                widthCheckLabel.setText("Maximum size is 12.");
            } else {
                widthCheckLabel.setText("");
            }

            if (gridHeight > 12) {
                heightCheckLabel.setText("Maximum size is 12.");
            } else {
                heightCheckLabel.setText("");
            }

            if (gridWidth <= 12 && gridHeight <= 12) {

                GameMap gameMap = new GameMap();

                gameMap.setName(nameField.getText());
                gameMap.setWidth(gridWidth);
                gameMap.setHeight(gridHeight);

                MapEditingScene mapEditingScene = new MapEditingScene();
                mapEditingScene.setGameMap(gameMap);
                MapCreationScene.this.navigationView.push(mapEditingScene);
            }
        });
    }
}
