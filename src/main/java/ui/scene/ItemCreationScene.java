package ui.scene;

<<<<<<< Updated upstream
=======
import game.Equipment;

>>>>>>> Stashed changes
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class ItemCreationScene extends Scene {
    @Override
    protected void init() {
        super.init();

        titleName = "Create Item";
        backButton = true;
        saveButton = false;
    }

    protected void initSubviews() {
        JLabel nameLabel = new JLabel("Name", JLabel.RIGHT);
        nameLabel.setSize(120, 40);
        nameLabel.setLocation(20, 20);
        main.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setSize(160,40);
        nameField.setLocation(150, 20);
        main.add(nameField);

        JButton createButton = new JButton("Create");
        createButton.setSize(160, 40);
        createButton.setLocation(150, 90);
        main.add(createButton);

        repaint();

        back.addActionListener(new ActionListener() {
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
<<<<<<< Updated upstream
                ItemCreationScene.this.navigationView.push(itemEditingScene);
=======
                itemEditingScene.setEquipment(equipment);
                ItemCreationScene.this.viewFlow.push(itemEditingScene);
>>>>>>> Stashed changes
            }
        });
    }
}
