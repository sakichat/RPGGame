package ui.scene;

import logic.equipment.Equipment;
import logic.equipment.EquipmentFactory;

import javax.swing.*;

/**
 * This is a ItemCreationScene to show the scene for creating item name which extends Scene class
 * @author Siyu Chen
 * @version 0.3
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

        backButton.addActionListener(e -> ItemCreationScene.this.navigationView.pop());

        createButton.addActionListener(e -> {
            Equipment equipment = new EquipmentFactory().newEquipment(nameField.getText());
            ItemEditingScene itemEditingScene = new ItemEditingScene();
            itemEditingScene.setEquipment(equipment);
            ItemCreationScene.this.navigationView.push(itemEditingScene);
        });
    }
}
