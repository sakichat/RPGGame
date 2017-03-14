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
    private int width;
    private int height;

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
        textField.setSize(120, 40);
        textField.setLocation(150, 70);
        contentView.add(textField);
        JTextField widthField = textField;

        label = new JLabel("Height", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 120);
        contentView.add(label);

        textField = new JTextField();
        textField.setSize(120, 40);
        textField.setLocation(150, 120);
        contentView.add(textField);
        JTextField heightField = textField;

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
//                gameMap.setWidth(widthField.getText());
//                gameMap.setHeight(heightField.getText());
                MapEditingScene mapEditingScene = new MapEditingScene();
                mapEditingScene.setGameMap(gameMap);
                MapCreationScene.this.navigationView.push(mapEditingScene);
            }
        });
    }
}
