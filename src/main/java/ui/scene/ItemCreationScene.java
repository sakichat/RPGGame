package ui.scene;

import logic.Equipment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a ItemCreationScene to show the scene for creating item name which extends Scene class
 * @author Siyu Chen
 * @version 0.2
 */
public class ItemCreationScene extends Scene {

    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        title = "Create Item";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    /**
     * This method creates components on the main scene
     * And adds events on backButton and createButton
     */
    protected void initSubviews() {
        JLabel nameLabel = new JLabel("Name", JLabel.RIGHT);
        nameLabel.setSize(120, 40);
        nameLabel.setLocation(20, 20);
        contentView.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setSize(160,40);
        nameField.setLocation(150, 20);
        contentView.add(nameField);

        JButton createButton = new JButton("Create");
        createButton.setSize(160, 40);
        createButton.setLocation(150, 90);
        contentView.add(createButton);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemCreationScene.this.navigationView.pop();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipment equipment = new Equipment(nameField.getText());
                ItemEditingScene itemEditingScene = new ItemEditingScene();
                itemEditingScene.setEquipment(equipment);
                ItemCreationScene.this.navigationView.push(itemEditingScene);
            }
        });
    }
}
